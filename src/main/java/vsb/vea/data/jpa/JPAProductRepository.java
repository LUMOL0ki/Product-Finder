package vsb.vea.data.jpa;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.models.Product;

@Repository
@ConditionalOnProperty(
		  value="dataAccessSource", 
		  havingValue = "jpa", 
		  matchIfMissing = false)
public class JPAProductRepository extends JPABaseRepository<Product> implements IProductRepository {

	@PostConstruct
	protected void initialize() {
 
	}
	
	@Override
	public List<Product> findByName(String name) {
		TypedQuery<Product> query = context.createQuery("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(:name)", Product.class);
		return query.setParameter("name", name).getResultList(); 
	}

	@Override
	public Product findByEAN(String ean) {
		TypedQuery<Product> query = context.createQuery("SELECT p FROM Product p WHERE p.ean = ?1", Product.class);
		return query.setParameter(1, ean).getSingleResult(); 
	}

	@Override
	public List<Product> findByNameOrEAN(String filter) {
		TypedQuery<Product> query = context.createQuery("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%',:filter,'%')) OR p.ean = :filter", Product.class);
		return query.setParameter("filter", filter).getResultList();
	}

	@Override
	public List<Product> get() {
	    return context.createQuery("SELECT p FROM Product p", Product.class).getResultList();
	}

	@Override
	public Product findById(long id) {
		return context.find(Product.class, id);
	}

	@Override
	public long count() {
		return context.createQuery("SELECT count(p) FROM Product p", long.class).getSingleResult();
	}

	@Override
	public boolean exists(Product entity) {
		TypedQuery<Boolean> query = context.createQuery("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Product p WHERE p.id = ?1 AND p.name = ?2", Boolean.class);
		return query.setParameter(1, entity.getId()).setParameter(2, entity.getName()).getSingleResult();
	}

}
