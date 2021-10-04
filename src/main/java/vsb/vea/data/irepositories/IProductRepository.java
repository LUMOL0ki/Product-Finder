package vsb.vea.data.irepositories;

import java.util.List;

import vsb.vea.models.Product;

public interface IProductRepository extends IBaseRepository<Product> {
	Product findById(int id);
	List<Product> findByName(String name);
	Product findByEAN(String ean);
	List<Product> findByNameOrEAN(String filter);
}
