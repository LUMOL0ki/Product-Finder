package vsb.vea.data.mock;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.ISupplierRepository;
import vsb.vea.helpers.StringHelper;
import vsb.vea.models.Address;
import vsb.vea.models.Supplier;

@Repository
@ConditionalOnProperty(
		  value="dataAccessSource", 
		  havingValue = "mock", 
		  matchIfMissing = false)
public class MockSupplierRepository extends MockBaseRepository<Supplier> implements ISupplierRepository {
		
	public MockSupplierRepository() {
		super();		
	}

	@PostConstruct
	protected void initialize() {
		this.create(new Supplier("Kofola", "", new Address("sample line", "sample city", "111 11", "sample country"), "www.example.com"));
		this.create(new Supplier("Supplier A", "", new Address("sample line", "sample city", "111 11", "sample country"), "www.example.com"));
		this.create(new Supplier("Supplier B", "", new Address("sample line", "sample city", "111 11", "sample country"), "www.example.com"));
		this.create(new Supplier("Supplier C", "", new Address("sample line", "sample city", "111 11", "sample country"), "www.example.com"));
		this.create(new Supplier("Supplier D", "", new Address("sample line", "sample city", "111 11", "sample country"), "www.example.com"));
	}
	
	@Override
	public List<Supplier> findByName(String name) {
		return entities.stream().filter(s -> StringHelper.containsCaseInsensitive(s.getName(), name)).collect(Collectors.toList());
	}

}
