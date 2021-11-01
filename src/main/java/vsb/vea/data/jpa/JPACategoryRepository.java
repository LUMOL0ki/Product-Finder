package vsb.vea.data.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.models.Category;

public class JPACategoryRepository implements ICategoryRepository {

	@PersistenceContext
 	private EntityManager context;
	
	@Override
	public List<Category> get() {
		return null;
	}

	@Override
	public Category create(Category entity) {
		return null;
	}

	@Override
	public void edit(Category entity) {
		
	}

	@Override
	public void remove(Category entity) {
		
	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public Category findById(long id) {
		return null;
	}

	@Override
	public List<Category> findByName(String name) {
		return null;
	}
}
