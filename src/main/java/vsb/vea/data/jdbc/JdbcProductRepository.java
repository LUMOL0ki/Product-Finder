package vsb.vea.data.jdbc;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.models.Product;

@Repository
@ConditionalOnProperty(
		  value="dataAccessSource", 
		  havingValue = "jdbc", 
		  matchIfMissing = true)
public class JdbcProductRepository extends JdbcBaseRepository<Product>  implements IProductRepository {

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource).withTableName("Product").usingGeneratedKeyColumns("id")
				.usingColumns("name", "description", "ean", "supplierId", "categoryId", "status");
	}

	@PostConstruct
	public void init() {
		try (Statement stm = jdbcTemplate.getDataSource().getConnection().createStatement()) {
			stm.executeUpdate("CREATE TABLE Product (" + "id INT NOT NULL auto_increment," + " name varchar(255), "
					+ "description varchar(800), " + "ean varchar(14), " + "supplierId int, " + "cateoryId int, " + "status varchar(80), " + " PRIMARY KEY (id), "
							+ "FOREIGN KEY (supplierId) REFERENCES supplier(id), " + "FOREIGN KEY (categoryId) REFERENCES category(id)" + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findByEAN(String ean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByNameOrEAN(String filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(Product entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Product entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exists(Product entity) {
		// TODO Auto-generated method stub
		return false;
	}


}
