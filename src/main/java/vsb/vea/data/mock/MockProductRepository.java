package vsb.vea.data.mock;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.helpers.StringHelper;
import vsb.vea.models.Product;

@Repository
public class MockProductRepository extends MockBaseRepository<Product> implements IProductRepository {

	public MockProductRepository() {
		super();
	}
	
	@PostConstruct
	protected void initialize() {
		this.create(new Product("Item A", "123456"));
		this.create(new Product("Item B", "123457"));
		this.create(new Product("Item C", "123458"));
		this.create(new Product("Item D", "123459"));
		this.create(new Product("Item A", "123456"));
		this.create(new Product("Item B", "123457"));
		this.create(new Product("Item C", "123458"));
		this.create(new Product("Item D", "123459"));
		this.create(new Product("Item A", "123456"));
		this.create(new Product("Item B", "123457"));
		this.create(new Product("Item C", "123458"));
		this.create(new Product("Item D", "123459"));
		this.create(new Product("Item A", "123456"));
		this.create(new Product("Item B", "123457"));
		this.create(new Product("Item C", "123458"));
		this.create(new Product("Item D", "123459"));
	}
	
	@Override
	public List<Product> findByName(String name) {
		return entities.stream().filter(p -> StringHelper.containsCaseInsensitive(p.getName(), name)).collect(Collectors.toList());
	}

	@Override
	public Product findByEAN(String ean) {
		return entities.stream().filter(p -> p.getEan().equals(ean)).collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Product> findByNameOrEAN(String filter) {
		return entities.stream()
				.filter(p -> p.getEan().equals(filter) || StringHelper.containsCaseInsensitive(p.getName(), filter)).collect(Collectors.toList());
	}

}
