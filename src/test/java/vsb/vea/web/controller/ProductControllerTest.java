package vsb.vea.web.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.exceptions.FormatException;
import vsb.vea.services.ProductService;
import vsb.vea.web.controllers.ProductController;
import vsb.vea.web.models.ProductBrief;
import vsb.vea.web.models.ProductInput;

public abstract class ProductControllerTest {

	protected ProductController controller;
	protected ProductService service;
	protected IProductRepository repository;
	
	public ProductControllerTest(IProductRepository productRepository) {
		this.repository = productRepository;
		service = new ProductService(this.repository);
		controller = new ProductController(service);
	}
	
	@Test
	public void Get() {
		assertTrue(controller.get().size() == repository.count());
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 1, Integer.MAX_VALUE})
	public void FindById(long id) {
		if(id <= 0) {
			assertTrue(controller.findById(id) == null);
		}
		else {
			for(ProductBrief product : controller.get()) {
				if(product.getId() == id) {
					assertTrue(controller.findById(id) != null);					
				}
			}
		}
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"", " ", "A", "SSDDSFDDFDF"})
	public void FindByName(String name) {
		if(name == null || name == "" || name == " ") {
			assertTrue(controller.findByName(name) == null);
		}
		else if(name.length() > 0) {
			assertTrue(controller.findByName(name).size() >= 0);
		}
	}
	
	@Test
	public void Create() throws FormatException {
		long before = repository.count();
		ProductInput productInput = new ProductInput();
		productInput.name = "test";
		productInput.description = null;
		controller.create(productInput);
		long after = repository.count();
		assertTrue(before < after);
	}
	
	public void Edit() throws FormatException {
		long before = repository.count();
		ProductInput productInput = new ProductInput();
		productInput.name = "test";
		productInput.description = null;
		controller.edit(1, productInput);
		long after = repository.count();
		
		assertTrue(before == after && controller.findById(1).getName() == productInput.name);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 1, 4, Integer.MAX_VALUE})
	public void Remove(long id) {
		long before = repository.count();
		controller.remove(id);
		long after = repository.count();
		if(id <= 0) {
			assertTrue("not removed", before == after);
		}
		else {
			for(ProductBrief product : controller.get()) {
				if(product.getId() == id) {
					assertTrue("not removed", before > after);					
				}
			}
		}
	}
}
