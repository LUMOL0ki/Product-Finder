package vsb.vea.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vsb.vea.data.irepositories.ISupplierRepository;
import vsb.vea.exceptions.FormatException;
import vsb.vea.helpers.StringHelper;
import vsb.vea.models.Supplier;

@Service
public class SupplierService extends BaseService<Supplier, ISupplierRepository> {

	@Autowired
	public SupplierService(ISupplierRepository repository) {
		super(repository);
	}

	public Supplier findById(long id) throws FormatException {
		if(id > 0) {
			Supplier supplier = repository.findById(id);
			return supplier == null ? null : supplier;	
		}
		else {
			throw new FormatException("Invalid category key format.");
		}
	}
	
	public List<Supplier> findByName(String name) throws FormatException{
		if(!StringHelper.isNullOrEmpty(name)) {
			return repository.findByName(name);	
		}
		else {
			throw new FormatException("Category name is in invalid format.");
		}
	}
	
	public void remove(long id) throws FormatException {
		Supplier supplier = repository.findById(id);
		if(supplier != null) {
			repository.remove(supplier);
		}
		else {
			throw new FormatException("Supplier does not exists.");
		}
	}
}
