package vsb.vea.data.jpa;

import java.util.List;

import vsb.vea.data.irepositories.ISupplierRepository;
import vsb.vea.models.Supplier;

public class JPASupplierRepository extends JPABaseRepository<Supplier> implements ISupplierRepository {

	@Override
	public List<Supplier> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
