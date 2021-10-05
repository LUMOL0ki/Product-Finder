package vsb.vea.web.controllers;

import java.util.List;

import vsb.vea.exceptions.FormatException;
import vsb.vea.models.Category;
import vsb.vea.services.CategoryService;
import vsb.vea.web.mapper.CategoryMapper;
import vsb.vea.web.models.CategoryBrief;
import vsb.vea.web.models.CategoryDetail;
import vsb.vea.web.models.CategoryInput;

public class CategoryController {
	private CategoryService service;
	
	public CategoryController(CategoryService service) {
		this.service = service;
	}
	
	public List<CategoryBrief> get(){
		return CategoryMapper.toCategoryBrief(service.get());
	}
	
	public CategoryDetail findById(int id) {
		Category category = null;
		try {
			category = service.findById(id);
			return category != null ? CategoryMapper.toCategoryDetail(category) : null;
		} catch (FormatException e) {
			e.printStackTrace(); //TODO: exception handler.
			return null;
		}
	}
	
	public List<CategoryBrief> findByName(String name){
		try {
			return CategoryMapper.toCategoryBrief(service.findByName(name));
		} catch (FormatException e) {
			e.printStackTrace(); //TODO: exception handler.
			return null;
		}
	}
	
	public void create(CategoryInput category) throws FormatException {
		if(category != null) {
			service.create(CategoryMapper.fromCategoryInput(category));
		}
		else {
			throw new FormatException("Category is in invalid format.");
		}
	}

	public void edit(int id, CategoryInput category) throws FormatException {
		service.edit(null);
		if(category != null) {
			service.edit(CategoryMapper.fromCategoryInput(id, category));
		}
		else {
			throw new FormatException("Category is in invalid format.");
		}
	}

	public void remove(int id) {
		try {
			service.remove(id);
		} catch (FormatException e) {
			e.printStackTrace(); // TODO Auto-generated catch block
		}
	}
}
