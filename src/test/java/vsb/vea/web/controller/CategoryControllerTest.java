package vsb.vea.web.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.services.CategoryService;
import vsb.vea.web.controllers.CategoryController;

public class CategoryControllerTest {

	private CategoryController categoryController;
	
	public CategoryControllerTest(ICategoryRepository categoryRepository) {
		categoryController = new CategoryController(new CategoryService(categoryRepository));
	}
	
	@Test
	public void Get() {
		categoryController.get();
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
