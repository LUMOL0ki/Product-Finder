package vsb.vea.data.mock;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.helpers.StringHelper;
import vsb.vea.models.Category;
import vsb.vea.models.Product;
import vsb.vea.models.Supplier;

@Repository
@ConditionalOnProperty(
		  value="dataAccessSource", 
		  havingValue = "mock", 
		  matchIfMissing = false)
public class MockProductRepository extends MockBaseRepository<Product> implements IProductRepository {

	public MockProductRepository() {
		super();
	}
	
	@PostConstruct
	protected void initialize() {
		this.create(new Product("Item A", "", "123456", new Supplier(1, "Kofola"), new Category(1, "A")));
		this.create(new Product("Item B", "", "123457", 1, 1));
		this.create(new Product("Item C", "", "123458", 1, 1));
		this.create(new Product("Item D", "", "123459", 1, 1));
		this.create(new Product("Item A", "", "123456", 1, 1));
		this.create(new Product("Item B", "", "123457", 1, 1));
		this.create(new Product("Item C", "", "123458", 1, 1));
		this.create(new Product("Item D", "", "123459", 1, 1));
		this.create(new Product("Item A", "", "123456", 1, 1));
		this.create(new Product("Item B", "", "123457", 1, 1));
		this.create(new Product("Item C", "", "123458", 1, 1));
		this.create(new Product("Item D", "", "123459", 1, 1));
		this.create(new Product("Item A", "", "123456", 1, 1));
		this.create(new Product("Item B", "", "123457", 1, 1));
		this.create(new Product("Item C", "", "123458", 1, 1));
		this.create(new Product("Item D", "", "123459", 1, 1));
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
