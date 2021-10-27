package vsb.vea.models;

import java.util.Date;
import java.util.List;

public class Parcel extends Item{

	public Parcel(long id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	public Parcel(long id, String name, String description, String ean, int supplierId, int categoryId,
			StatusType status) {
		super(id, name, description, ean, supplierId, categoryId, status);
		// TODO Auto-generated constructor stub
	}

	public Parcel(long id, String name, String description, String ean, int supplierId, Supplier supplier,
			int categoryId, Category category, StatusType status, Date created) {
		super(id, name, description, ean, supplierId, supplier, categoryId, category, status, created);
		// TODO Auto-generated constructor stub
	}
	
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
