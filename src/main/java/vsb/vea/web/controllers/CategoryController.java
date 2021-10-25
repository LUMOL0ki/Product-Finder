package vsb.vea.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vsb.vea.exceptions.FormatException;
import vsb.vea.models.Category;
import vsb.vea.services.CategoryService;
import vsb.vea.web.mapper.CategoryMapper;
import vsb.vea.web.models.CategoryBrief;
import vsb.vea.web.models.CategoryDetail;
import vsb.vea.web.models.CategoryInput;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	public CategoryController() {
		
	}
	
	public CategoryController(CategoryService service) {
		this.service = service;
	}
	
	@RequestMapping("/")	
	public List<CategoryBrief> get(){
		return CategoryMapper.toCategoryBrief(service.get());
	}

	@RequestMapping("/find/{id}")
	public CategoryDetail findById(@PathVariable int id) {
		Category category = null;
		try {
			category = service.findById(id);
			return category != null ? CategoryMapper.toCategoryDetail(category) : null;
		} catch (FormatException e) {
			e.printStackTrace(); //TODO: exception handler.
			return null;
		}
	}

	@RequestMapping("/find/{name}")
	public List<CategoryBrief> findByName(@PathVariable String name){
		try {
			return CategoryMapper.toCategoryBrief(service.findByName(name));
		} catch (FormatException e) {
			e.printStackTrace(); //TODO: exception handler.
			return null;
		}
	}

	@RequestMapping("/create")
	public void create(CategoryInput category) throws FormatException {
		if(category != null) {
			service.create(CategoryMapper.fromCategoryInput(category));
		}
		else {
			throw new FormatException("Category is in invalid format.");
		}
	}

	@RequestMapping("/edit/{id}")
	public void edit(@PathVariable int id, CategoryInput category) throws FormatException {
		service.edit(null);
		if(category != null) {
			service.edit(CategoryMapper.fromCategoryInput(id, category));
		}
		else {
			throw new FormatException("Category is in invalid format.");
		}
	}

	@RequestMapping("/remove/{id}")
	public void remove(@PathVariable int id) {
		try {
			service.remove(id);
		} catch (FormatException e) {
			e.printStackTrace(); // TODO Auto-generated catch block
		}
	}
}
