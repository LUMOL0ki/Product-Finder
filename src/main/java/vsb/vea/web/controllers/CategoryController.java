package vsb.vea.web.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
	
	@GetMapping("/")	
    @ResponseBody
	public List<CategoryBrief> get(){
		return service.get().stream().map(CategoryMapper::toCategoryBrief).collect(Collectors.toList());
	}

	@RequestMapping("/find/{id}")
	public CategoryDetail findById(@PathVariable long id) {
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
			return service.findByName(name).stream().map(CategoryMapper::toCategoryBrief).collect(Collectors.toList());
		} catch (FormatException e) {
			e.printStackTrace(); //TODO: exception handler.
			return null;
		}
	}

	@PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
	public CategoryDetail create(CategoryInput category) {
		if(category != null) {
			return CategoryMapper.toCategoryDetail(service.create(CategoryMapper.fromCategoryInput(category)));
		}
		else {
			return null;
		}
	}

	@PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
	public void edit(@PathVariable long id, CategoryInput category) {
		service.edit(null);
		if(category != null) {
			service.edit(CategoryMapper.fromCategoryInput(id, category));
		}
		else {
			
		}
	}

	@DeleteMapping("/remove/{id}")
	public void remove(@PathVariable long id) {
		try {
			service.remove(id);
		} catch (FormatException e) {
			e.printStackTrace(); // TODO Auto-generated catch block
		}
	}
}
