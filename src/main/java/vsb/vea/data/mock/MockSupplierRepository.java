package vsb.vea.data.mock;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.ISupplierRepository;
import vsb.vea.models.Supplier;

@Repository
public class MockSupplierRepository extends MockBaseRepository<Supplier> implements ISupplierRepository {
		
	public MockSupplierRepository() {
		super();		
	}

	@PostConstruct
	protected void initialize() {
		
	}
	
	@Override
	public List<Supplier> findByName(String name) {
		return entities.stream().filter(s -> s.getName().contains(name)).collect(Collectors.toList());
	}

}
