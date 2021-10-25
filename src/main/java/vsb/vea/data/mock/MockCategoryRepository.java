package vsb.vea.data.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.models.Category;

@Repository
public class MockCategoryRepository implements ICategoryRepository {

	private List<Category> categories;

	public MockCategoryRepository() {
		categories = new ArrayList<Category>();
	}
	
	@Override
	public List<Category> get() {
		return categories;
	}

	@Override
	public void create(Category entity) {
		// TODO Auto-generated method stub
		categories.add(entity);
	}

	@Override
	public void edit(Category entity) {
		categories.set(categories.indexOf(findById(entity.getId())), entity);
	}

	@Override
	public void remove(Category entity) {
		categories.removeIf(e -> e.getId() == entity.getId());
	}

	@Override
	public int Count() {
		return categories.size();
	}

	@Override
	public Category findById(int id) {
		return categories.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Category> findByName(String name) {
		return categories.stream().filter(c -> c.getName().contains(name)).collect(Collectors.toList());
	}

}
