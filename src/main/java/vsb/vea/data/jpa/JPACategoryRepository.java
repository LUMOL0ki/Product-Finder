package vsb.vea.data.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.models.Category;

public class JPACategoryRepository extends JPABaseRepository<Category> implements ICategoryRepository {

	@Override
	public List<Category> findByName(String name) {
		return null;
	}
}
