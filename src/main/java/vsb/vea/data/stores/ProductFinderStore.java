package vsb.vea.data.stores;

import vsb.vea.data.irepositories.ICategoryRepository;
import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.data.irepositories.ISupplierRepository;
import vsb.vea.models.Product;

public class ProductFinderStore {
	public IProductRepository productRepository;
	public ICategoryRepository categoryRepository;
	public ISupplierRepository supplierRepository;
	
	public ProductFinderStore(
			IProductRepository productRepository, 
			ICategoryRepository categoryRepository, 
			ISupplierRepository supplierRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.supplierRepository = supplierRepository;
	}
	
	public void createProduct(Product product) {
		
	}
	
	public void beginTransaction() {
		
	}
	
	public void commitTransaction() {
		
	}
	
	public void rollback() {
		
	}
}
