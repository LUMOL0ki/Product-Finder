package vsb.vea.data.mock;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.models.Product;

@Repository
public class MockProductRepository extends MockBaseRepository<Product> implements IProductRepository {

	@PostConstruct
	protected void initialize() {
		
	}

	@Override
	public List<Product> findByName(String name) {
		return entities.stream().filter(p -> p.getName().contains(name)).collect(Collectors.toList());
	}

	@Override
	public Product findByEAN(String ean) {
		return entities.stream().filter(p -> p.getEan() == ean).collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Product> findByNameOrEAN(String filter) {
		return entities.stream().filter(p -> p.getEan() == filter || p.getName().contains(filter)).collect(Collectors.toList());
	}

}
