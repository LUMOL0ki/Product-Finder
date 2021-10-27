package vsb.vea.data.jdbc;

import java.util.List;

import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.models.Product;

public class JdbcProductRepository implements IProductRepository {

	@Override
	public List<Product> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product create(Product entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(Product entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Product entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

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
