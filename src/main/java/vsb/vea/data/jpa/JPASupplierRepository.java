package vsb.vea.data.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

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
		TypedQuery<Supplier> query = context.createQuery("SELECT s FROM Supplier s WHERE lower(s.name) like lower(?1)", Supplier.class);
		return query.setParameter(1, name).getResultList(); 
	}

	@Override
	public List<Supplier> get() {
	    return context.createQuery("SELECT s FROM Supplier s", Supplier.class).getResultList();
	}

	@Override
	public Supplier findById(long id) {
		return context.find(Supplier.class, id);
	}

	@Override
	public long count() {
		return context.createQuery("SELECT count(s) FROM Supplier s", long.class).getSingleResult();
	}

	@Override
	public boolean exists(Supplier entity) {
		TypedQuery<Boolean> query = context.createQuery("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Supplier s WHERE s.name = :name", Boolean.class);
		return query.setParameter("name", entity.getName()).getSingleResult();
	}
}
