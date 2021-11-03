package vsb.vea.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.exceptions.FormatException;
import vsb.vea.helpers.StringHelper;
import vsb.vea.models.Product;
import vsb.vea.models.StatusType;

@Service
public class ProductService extends BaseService<Product, IProductRepository> {

	@Autowired
	public ProductService(IProductRepository repository) {
		super(repository);
	}

	private void setProductStatus(long id, StatusType status) throws Exception {
		if(id > 0) {
			Product product = repository.findById(id);
			if(product != null) {
				product.setStatus(status);
				repository.edit(product);
			}
			else {
				throw new Exception("Product does not exist.");
			}
		}
		else {
			throw new FormatException("Invalid product key format.");
		}
	}
	
	public Product findById(long id) throws FormatException {
		if(id > 0) {
			Product product = repository.findById(id);
			return product == null ? null : product;	
		}
		else {
			throw new FormatException("Invalid product key format.");
		}
	}
	
	public List<Product> findByName(String name) throws FormatException{
		if(!StringHelper.isNullOrEmpty(name)) {
			return repository.findByName(name);	
		}
		else {
			throw new FormatException("Product name is in invalid format.");
		}
	}
	
	public Product findByEAN(String ean) throws FormatException{
		if(!StringHelper.isNullOrEmpty(ean)) {
			return repository.findByEAN(ean);
		}
		else {
			throw new FormatException("Product EAN is in invalid format.");
		}
	}

	public List<Product> findByNameOrEAN(String filter) throws FormatException{
		if(!StringHelper.isNullOrEmpty(filter)) {
			return repository.findByNameOrEAN(filter);	
		}
		else {
			throw new FormatException("Product name is in invalid format.");
		}
	}
	
	public void remove(long id) throws FormatException {
		Product product = repository.findById(id);
		if(product != null) {
			repository.remove(product);
		}
		else {
			throw new FormatException("Product does not exists.");
		}
	}
	
	public void setProductAsReviewing(long id) throws Exception {
		setProductStatus(id, StatusType.REVIEWING);
	}
	
	public void setProductAsApproved(long id) throws Exception {
		setProductStatus(id, StatusType.APPROVED);
	}
	
	public void setProductAsRejected(long id) throws Exception {
		setProductStatus(id, StatusType.REJECTED);
	}
}
