package vsb.vea.data.jdbc;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.models.Category;

@Repository
@ConditionalOnProperty(
		  value="dataAccessSource", 
		  havingValue = "jdbc", 
		  matchIfMissing = true)
public class JdbcCategoryRepository extends JdbcBaseRepository<Category> implements ICategoryRepository {

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insert;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource).withTableName("Category").usingGeneratedKeyColumns("id")
				.usingColumns("name", "description");
	}

	@PostConstruct
	public void init() {
		try (Statement stm = jdbcTemplate.getDataSource().getConnection().createStatement()) {
			stm.executeUpdate("CREATE TABLE Category (" + "id INT NOT NULL auto_increment," + " name varchar(255), "
					+ "description varchar(800), " + " PRIMARY KEY (id)" + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Category> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> get() {
		return jdbcTemplate.query("select * from Category", new CategoryMapper());
	}

	@Override
	public Category findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category create(Category entity) {
		if (entity.getId() == 0) {
			insert.execute(new BeanPropertySqlParameterSource(entity));
		} else {
			// update
		}
		return null;
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
