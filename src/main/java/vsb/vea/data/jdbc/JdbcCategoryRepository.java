package vsb.vea.data.jdbc;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.models.Category;

@Repository
@ConditionalOnProperty(
		  value="dataAccessSource", 
		  havingValue = "jdbc", 
		  matchIfMissing = true)
public class JdbcCategoryRepository extends JdbcBaseRepository<Category> implements ICategoryRepository {

	@Override
	public List<Category> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
