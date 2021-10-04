package vsb.vea.data.irepositories;

import java.util.List;

import vsb.vea.models.Supplier;

public interface ISupplierRepository extends IBaseRepository<Supplier> {
	Supplier findById(int id);
	List<Supplier> findByName(String name);
}
