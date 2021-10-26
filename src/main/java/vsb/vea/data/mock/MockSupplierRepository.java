package vsb.vea.data.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.ISupplierRepository;
import vsb.vea.models.Supplier;

@Repository
public class MockSupplierRepository implements ISupplierRepository {

	private List<Supplier> suppliers;
		
	public MockSupplierRepository() {
		super();
		suppliers = new ArrayList<Supplier>();		
	}

	@PostConstruct
	private void initialize() {
		
	}
	
	@Override
	public List<Supplier> get() {
		return suppliers;
	}

	@Override
	public void create(Supplier entity) {
		suppliers.add(entity);
	}

	@Override
	public void edit(Supplier entity) {
		suppliers.set(suppliers.indexOf(findById(entity.getId())), entity);
	}

	@Override
	public void remove(Supplier entity) {
		suppliers.removeIf(s -> s.getId() == entity.getId());
	}

	@Override
	public int Count() {
		return suppliers.size();
	}

	@Override
	public Supplier findById(int id) {
		// TODO Auto-generated method stub
		return suppliers.stream().filter(s -> s.getId() == id).collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Supplier> findByName(String name) {
		return suppliers.stream().filter(s -> s.getName().contains(name)).collect(Collectors.toList());
	}

}
