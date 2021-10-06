package vsb.vea.web.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.services.ProductService;
import vsb.vea.web.controllers.ProductController;

public class ProductControllerTest {

	protected ProductController productController;
	
	public ProductControllerTest(IProductRepository productRepository) {
		productController = new ProductController(new ProductService(productRepository));
	}
	
	@Test
	public void Get() {
		assertTrue(false);
	}

	public void FindById(int id) {
		
	}

	public void FindByName(String name) {
		
	}
	
	public void Create() {
		
	}
	
	public void Edit() {
		
	}
	
	public void Remove() {
		
	}
}
