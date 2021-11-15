package vsb.vea.data.jpa;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.ISupplierRepository;
import vsb.vea.models.Supplier;

@Repository
@ConditionalOnProperty(
		  value="dataAccessSource", 
		  havingValue = "jpa", 
		  matchIfMissing = false)
public class JPASupplierRepository extends JPABaseRepository<Supplier> implements ISupplierRepository {

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
