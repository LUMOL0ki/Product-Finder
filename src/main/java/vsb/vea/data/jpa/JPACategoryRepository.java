package vsb.vea.data.jpa;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.models.Category;

@Repository
@ConditionalOnProperty(
		  value="dataAccessSource", 
		  havingValue = "jpa", 
		  matchIfMissing = false)
public class JPACategoryRepository extends JPABaseRepository<Category> implements ICategoryRepository {
	
	@Override
	public List<Category> findByName(String name) {
		return null;
	}

	@Override
	public List<Category> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exists(Category entity) {
		// TODO Auto-generated method stub
		return false;
	}
}
