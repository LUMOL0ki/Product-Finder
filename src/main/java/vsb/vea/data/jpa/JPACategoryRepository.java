package vsb.vea.data.jpa;

import java.util.List;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.models.Category;

public class JPACategoryRepository extends JPABaseRepository<Category> implements ICategoryRepository {

	@Override
	public List<Category> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
