package vsb.vea.data.mock;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.helpers.StringHelper;
import vsb.vea.models.Category;

@Repository
public class MockCategoryRepository extends MockBaseRepository<Category> implements ICategoryRepository {
	
	public MockCategoryRepository() {
		super();
	}

	@PostConstruct
	protected void initialize() {
		this.create(new Category("A"));
		this.create(new Category("B"));
		this.create(new Category("C"));
		this.create(new Category("D"));
		this.create(new Category("E"));
	}

	@Override
	public List<Category> findByName(String name) {
		return entities.stream().filter(c -> StringHelper.containsCaseInsensitive(c.getName(), name)).collect(Collectors.toList());
	}

}
