package vsb.vea.web.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import vsb.vea.exceptions.FormatException;
import vsb.vea.models.Category;
import vsb.vea.services.CategoryService;
import vsb.vea.web.mapper.CategoryMapper;
import vsb.vea.web.models.CategoryBrief;
import vsb.vea.web.models.CategoryDetail;
import vsb.vea.web.models.CategoryInput;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private final CategoryService service;
    	
	public CategoryController(CategoryService service) {
		this.service = service;
	}
	
	@GetMapping	
    @ResponseBody
	public ResponseEntity<List<CategoryBrief>> get(){
		return ResponseEntity.ok(service.get().stream().map(CategoryMapper::toCategoryBrief).collect(Collectors.toList()));
	}

	@GetMapping("/test")
	public String test() {
		return "success";
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<CategoryDetail> findById(@PathVariable long id) {
		Category category = null;
		try {
			category = service.findById(id);
			return category != null ? ResponseEntity.ok(CategoryMapper.toCategoryDetail(category)) : new ResponseEntity<CategoryDetail>(HttpStatus.NOT_FOUND);
		} catch (FormatException e) {
			e.printStackTrace();
			return new ResponseEntity<CategoryDetail>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/find/{name}")
	public  ResponseEntity<List<CategoryBrief>> findByName(@PathVariable String name){
		try {
			return ResponseEntity.ok(service.findByName(name).stream().map(CategoryMapper::toCategoryBrief).collect(Collectors.toList()));
		} catch (FormatException e) {
			e.printStackTrace(); //TODO: exception handler.
			return new ResponseEntity<List<CategoryBrief>>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
	public ResponseEntity<CategoryDetail> create(CategoryInput category) {
		if(category != null) {
			return ResponseEntity.ok(CategoryMapper.toCategoryDetail(service.create(CategoryMapper.fromCategoryInput(category))));
		}
		else {
			return new ResponseEntity<CategoryDetail>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> edit(@PathVariable long id, CategoryInput category) {
		service.edit(null);
		if(category != null) {
			service.edit(CategoryMapper.fromCategoryInput(id, category));
			return ResponseEntity.ok("Successfully edited");
		}
		else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> remove(@PathVariable long id) {
		try {
			service.remove(id);
			return ResponseEntity.ok("Successfully removed");
		} catch (FormatException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
}
