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

import vsb.vea.data.irepositories.ISupplierRepository;
import vsb.vea.models.Supplier;

@Repository
@ConditionalOnProperty(
		  value="dataAccessSource", 
		  havingValue = "jdbc", 
		  matchIfMissing = true)
public class JdbcSupplierRepository extends JdbcBaseRepository<Supplier>  implements ISupplierRepository {

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource).withTableName("Supplier").usingGeneratedKeyColumns("id")
				.usingColumns("name", "description", "addressId", "web", "created");
	}

	@PostConstruct
	public void init() {
		try (Statement stm = jdbcTemplate.getDataSource().getConnection().createStatement()) {
			stm.executeUpdate("CREATE TABLE Supplier (" + "id INT NOT NULL auto_increment," + " name varchar(255), "
					+ "description varchar(800), " + "addressId int, " + "web varchar(300), " + " PRIMARY KEY (id), "
					/* + "FOREIGN KEY (addressId) REFERENCES address(id)"*/ + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Supplier> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(Supplier entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Supplier entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exists(Supplier entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
