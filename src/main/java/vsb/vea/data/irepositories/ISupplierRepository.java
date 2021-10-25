package vsb.vea.data.irepositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import vsb.vea.models.Supplier;

@Repository
public interface ISupplierRepository extends IBaseRepository<Supplier> {
	Supplier findById(int id);
	List<Supplier> findByName(String name);
}
