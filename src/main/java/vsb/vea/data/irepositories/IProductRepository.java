package vsb.vea.data.irepositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import vsb.vea.models.Product;

@Repository
public interface IProductRepository extends IBaseRepository<Product> {
	List<Product> findByName(String name);
	Product findByEAN(String ean);
	List<Product> findByNameOrEAN(String filter);
}
