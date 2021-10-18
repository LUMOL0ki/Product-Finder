package vsb.vea.data.mock;

import java.util.ArrayList;
import java.util.List;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.models.Category;

public class MockCategoryRepository implements ICategoryRepository {

	private List<Category> categories;

	public MockCategoryRepository() {
		categories = new ArrayList<Category>();
	}
	
	@Override
	public List<Category> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Category entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Category entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Category entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int Count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
