package vsb.vea.data.jpa;

import java.util.List;

import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.models.Product;

public class JPAProductRepository extends JPABaseRepository<Product> implements IProductRepository {

	@Override
	public List<Product> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findByEAN(String ean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByNameOrEAN(String filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
