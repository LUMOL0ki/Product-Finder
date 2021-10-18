package vsb.vea.models;

import java.util.List;

public class Parcel extends Item{
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
