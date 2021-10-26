package vsb.vea.data.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.models.Product;

@Repository
public class MockProductRepository implements IProductRepository {

	private List<Product> products;
		
	public MockProductRepository() {
		super();
		products = new ArrayList<Product>();
	}

	@PostConstruct
	private void initialize() {
		
	}
	
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
		products.set(products.indexOf(findById(entity.getId())), entity);
	}

	@Override
	public void remove(Product entity) {
		products.removeIf(p -> p.getId() == entity.getId());
	}

	@Override
	public int Count() {
		return products.size();
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return products.stream().filter(p -> p.getId() == id).collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Product> findByName(String name) {
		return products.stream().filter(p -> p.getName().contains(name)).collect(Collectors.toList());
	}

	@Override
	public Product findByEAN(String ean) {
		return products.stream().filter(p -> p.getEan() == ean).collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Product> findByNameOrEAN(String filter) {
		return products.stream().filter(p -> p.getEan() == filter || p.getName().contains(filter)).collect(Collectors.toList());
	}

}
