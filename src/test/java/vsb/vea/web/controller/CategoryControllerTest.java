package vsb.vea.web.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.exceptions.FormatException;
import vsb.vea.services.CategoryService;
import vsb.vea.web.controllers.CategoryController;
import vsb.vea.web.models.CategoryBrief;
import vsb.vea.web.models.CategoryInput;

public class CategoryControllerTest {

	private CategoryController categoryController;
	private CategoryService categoryService;
	private ICategoryRepository categoryRepository;
	
	public CategoryControllerTest(ICategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
		categoryService = new CategoryService(this.categoryRepository);
		categoryController = new CategoryController(categoryService);
	}
	
	@Test
	public void Get() {
		assertTrue(categoryController.get().size() == categoryRepository.Count());
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 1, Integer.MAX_VALUE})
	public void FindById(int id) {
		if(id <= 0) {
			assertTrue(categoryController.findById(id) == null);
		}
		else {
			for(CategoryBrief category : categoryController.get()) {
				if(category.id == id) {
					assertTrue(categoryController.findById(id) != null);					
				}
			}
		}
	}

	public void FindByName(String name) {
		
	}
	
	@Test
	public void Create() {
		int before = categoryRepository.Count();
		CategoryInput categoryInput = new CategoryInput();
		categoryInput.name = "test";
		categoryInput.description = null;
		try {
			categoryController.create(categoryInput);
		} catch (FormatException e) {
			e.printStackTrace();
		}
		int after = categoryRepository.Count();
		assertTrue(before < after);
	}
	
	public void Edit() {
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 1, 4, Integer.MAX_VALUE})
	public void Remove(int id) {
		int before = categoryRepository.Count();
		categoryController.remove(id);
		int after = categoryRepository.Count();
		if(id <= 0) {
			assertTrue("not removed", before == after);
		}
		else {
			for(CategoryBrief category : categoryController.get()) {
				if(category.id == id) {
					assertTrue("not removed", before > after);					
				}
			}
		}
	}
}
