package vsb.vea.data.jdbc;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.ISupplierRepository;
import vsb.vea.models.Supplier;

@Repository
@ConditionalOnProperty(
		  value="dataAccessSource", 
		  havingValue = "jdbc", 
		  matchIfMissing = true)
public class JdbcSupplierRepository extends JdbcBaseRepository<Supplier>  implements ISupplierRepository {

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
	public Supplier create(Supplier entity) {
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
