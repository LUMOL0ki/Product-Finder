package vsb.vea.web.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vsb.vea.data.irepositories.ISupplierRepository;
import vsb.vea.services.SupplierService;
import vsb.vea.web.controllers.SupplierController;

public class SupplierControllerTest {

	protected SupplierController supplierController;
	
	public SupplierControllerTest(ISupplierRepository supplierRepository) {
		supplierController = new SupplierController(new SupplierService(supplierRepository));
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
