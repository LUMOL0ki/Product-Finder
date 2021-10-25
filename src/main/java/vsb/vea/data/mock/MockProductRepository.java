package vsb.vea.data.mock;

import java.util.List;

import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.models.Product;

@Repository
public class MockProductRepository implements IProductRepository {

	private List<Product> products;
	
	@Override
	public List<Product> get() {
		return products;
	}

	@Override
	public void create(Product entity) {
		products.add(entity);
	}

	@Override
	public void edit(Product entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Product entity) {
		//products.removeIf(p -> p.)
	}

	@Override
	public int Count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product findById(int id) {
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
