package vsb.vea.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.exceptions.FormatException;
import vsb.vea.helpers.StringHelper;
import vsb.vea.models.Category;

@Service
public class CategoryService extends BaseService<Category, ICategoryRepository> {
	
	public CategoryService() {
		super();
	}

	@Autowired
	public CategoryService(ICategoryRepository repository) {
		super(repository);
	}

	@PostConstruct
	protected void initialize() {
		/*this.create(new Category("A"));
		this.create(new Category("B"));
		this.create(new Category("C"));
		this.create(new Category("D"));
		this.create(new Category("E"));*/
	}
	
	public Category findById(long id) throws FormatException {
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

	public void remove(long id) throws FormatException {
		Category category = repository.findById(id);
		if(category != null) {
			repository.remove(category);
		}
		else {
			throw new FormatException("Category does not exists.");
		}
	}
}
