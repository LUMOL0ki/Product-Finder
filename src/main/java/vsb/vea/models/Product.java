package vsb.vea.models;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Product extends Item{

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(long id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	public Product(String name, String ean) {
		super(name, ean);
		// TODO Auto-generated constructor stub
	}
	
	public Product(long id, String name, String ean) {
		super(id, name, ean);
		// TODO Auto-generated constructor stub
	}

	public Product(long id, String name, String description, String ean, int supplierId, int categoryId,
			StatusType status) {
		super(id, name, description, ean, supplierId, categoryId, status);
		// TODO Auto-generated constructor stub
	}
	
	public Product(long id, String name, String description, String ean, int supplierId, int categoryId) {
		super(id, name, description, ean, supplierId, categoryId);
		// TODO Auto-generated constructor stub
	}

	public Product(String name, String description, String ean, int supplierId, int categoryId) {
		super(name, description, ean, supplierId, categoryId);
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name, String description, String ean, Supplier supplier, Category category) {
		super(name, description, ean, supplier, category);
		// TODO Auto-generated constructor stub
	}
	
	public Product(long id, String name, String description, String ean, Supplier supplier, Category category) {
		super(id, name, description, ean, supplier, category);
		// TODO Auto-generated constructor stub
	}

	public Product(long id, String name, String description, String ean, int supplierId, Supplier supplier,
			int categoryId, Category category, StatusType status, Date created) {
		super(id, name, description, ean, supplierId, supplier, categoryId, category, status, created);
		// TODO Auto-generated constructor stub
	}
}
