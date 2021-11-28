package vsb.vea.data.jpa;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.models.Category;

/**
 * 
 * @author Lukas Moravec
 *
 */
@Repository
@ConditionalOnProperty(
		  value="dataAccessSource", 
		  havingValue = "jpa", 
		  matchIfMissing = false)
public class JPACategoryRepository extends JPABaseRepository<Category> implements ICategoryRepository {

	@Override
	public List<Category> findByName(String name) {
		return context.createQuery("SELECT c FROM Category c where lower(c.name) like lower(:name)", Category.class)
				.setParameter("name", name)
				.getResultList(); 
	}

	@Override
	public List<Category> get() {
	    return context.createQuery("SELECT c FROM Category c", Category.class).getResultList();
	}

	@Override
	public Category findById(long id) {
		return context.find(Category.class, id);
	}

	@Override
	public long count() {
		return context.createQuery("SELECT count(c) FROM Category c", long.class).getSingleResult();
	}

	@Override
	public boolean exists(Category entity) {
		if(entity.getId() != null && this.findById(entity.getId()) != null) {
			return true;
		}else {
			return false;	
		}
	}
}
