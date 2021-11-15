package vsb.vea.web.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import vsb.vea.data.irepositories.ISupplierRepository;
import vsb.vea.exceptions.FormatException;
import vsb.vea.services.SupplierService;
import vsb.vea.web.controllers.SupplierController;
import vsb.vea.web.models.SupplierBrief;
import vsb.vea.web.models.SupplierInput;

public abstract class SupplierControllerTest {

	protected SupplierController controller;
	protected SupplierService service;
	protected ISupplierRepository repository;
	
	public SupplierControllerTest(ISupplierRepository supplierRepository) {
		this.repository = supplierRepository;
		service = new SupplierService(this.repository);
		controller = new SupplierController(service);
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
			for(SupplierBrief supplier : controller.get()) {
				if(supplier.getId() == id) {
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
		SupplierInput supplierInput = new SupplierInput();
		supplierInput.setName("test");
		supplierInput.setDescription(null);
		controller.create(supplierInput);
		long after = repository.count();
		assertTrue(before < after);
	}
	
	public void Edit() throws FormatException {
		long before = repository.count();
		SupplierInput supplierInput = new SupplierInput();
		supplierInput.setName("test");
		supplierInput.setDescription(null);
		controller.edit(1, supplierInput);
		long after = repository.count();
		
		assertTrue(before == after && controller.findById(1).getName() == supplierInput.getName());
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
			for(SupplierBrief supplier : controller.get()) {
				if(supplier.getId() == id) {
					assertTrue("not removed", before > after);					
				}
			}
		}
	}
}
