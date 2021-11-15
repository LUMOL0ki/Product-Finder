package vsb.vea.web.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.exceptions.FormatException;
import vsb.vea.services.CategoryService;
import vsb.vea.web.controllers.CategoryController;
import vsb.vea.web.mapper.CategoryMapper;
import vsb.vea.web.models.CategoryBrief;
import vsb.vea.web.models.CategoryInput;

public abstract class CategoryControllerTest {

	private CategoryController controller;
	private CategoryService service;
	private ICategoryRepository repository;
	
	public CategoryControllerTest(ICategoryRepository categoryRepository) {
		this.repository = categoryRepository;
		service = new CategoryService(this.repository);
		controller = new CategoryController(service);
	}
	
	@Test
	public void Get() {
		assertTrue(controller.get().getBody().size() == repository.count());
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 1, Integer.MAX_VALUE})
	public void FindById(long id) {
		if(id <= 0) {
			assertTrue(controller.findById(id) == null);
		}
		else {
			for(CategoryBrief category : controller.get().getBody()) {
				if(category.getId() == id) {
					assertTrue(repository.exists(CategoryMapper.fromCategoryBrief(category)) && controller.findById(id) != null);					
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
			assertTrue(controller.findByName(name).getBody().size() >= 0);
		}
	}
	
	@Test
	public void Create() throws FormatException {
		long before = repository.count();
		CategoryInput categoryInput = new CategoryInput();
		categoryInput.setName("test");
		categoryInput.setDescription(null);
		controller.create(categoryInput);
		long after = repository.count();
		assertTrue(before < after);
	}
	
	public void Edit() throws FormatException {
		long before = repository.count();
		CategoryInput categoryInput = new CategoryInput();
		categoryInput.setName("test");
		categoryInput.setDescription(null);
		controller.edit(1, categoryInput);
		long after = repository.count();
		
		assertTrue(before == after && controller.findById(1).getBody().getName() == categoryInput.getName());
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
			for(CategoryBrief category : controller.get().getBody()) {
				if(category.getId() == id) {
					assertTrue("not removed", before > after);					
				}
			}
		}
	}
}
