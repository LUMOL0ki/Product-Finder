package vsb.vea.services;

import java.util.List;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.exceptions.FormatException;
import vsb.vea.helpers.StringHelper;
import vsb.vea.models.Category;

public class CategoryService extends BaseService<Category, ICategoryRepository> {
	
	public CategoryService(ICategoryRepository repository) {
		super(repository);
	}
	
	public Category findById(int id) throws FormatException {
		if(id > 0) {
			Category category = repository.findById(id);
			return category == null ? null : category;	
		}
		else {
			throw new FormatException("Invalid category key format.");
		}
	}
	
	public List<Category> findByName(String name) throws FormatException{
		if(!StringHelper.isNullOrEmpty(name)) {
			return repository.findByName(name);	
		}
		else {
			throw new FormatException("Category name is in invalid format.");
		}
	}

	public void remove(int id) throws FormatException {
		Category category = repository.findById(id);
		if(category != null) {
			repository.remove(category);
		}
		else {
			throw new FormatException("Category does not exists.");
		}
	}
}
