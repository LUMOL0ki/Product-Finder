package vsb.vea.services;

import java.util.List;

import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.exceptions.FormatException;
import vsb.vea.helpers.StringHelper;
import vsb.vea.models.Product;
import vsb.vea.models.StatusType;

public class ProductService extends BaseService<Product, IProductRepository> {

	public ProductService(IProductRepository repository) {
		super(repository);
	}

	private void setProductStatus(int id, StatusType status) throws Exception {
		if(id > 0) {
			Product product = repository.findById(id);
			if(product != null) {
				product.status = status;
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
	
	public Product findById(int id) throws FormatException {
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
			return repository.findByName(filter);	
		}
		else {
			throw new FormatException("Product name is in invalid format.");
		}
	}
	
	public void remove(int id) throws FormatException {
		Product product = repository.findById(id);
		if(product != null) {
			repository.remove(product);
		}
		else {
			throw new FormatException("Product does not exists.");
		}
	}
	
	public void setProductAsReviewing(int id) throws Exception {
		setProductStatus(id, StatusType.REVIEWING);
	}
	
	public void setProductAsApproved(int id) throws Exception {
		setProductStatus(id, StatusType.APPROVED);
	}
	
	public void setProductAsRejected(int id) throws Exception {
		setProductStatus(id, StatusType.REJECTED);
	}
}
