package vsb.vea.data.jdbc;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.models.Category;

public class JdbcCategoryRepository extends JdbcBaseRepository<Category> implements ICategoryRepository {

	@Override
	public List<Category> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
