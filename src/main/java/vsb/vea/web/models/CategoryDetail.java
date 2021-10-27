package vsb.vea.web.models;

import java.util.List;

public class CategoryDetail extends CategoryBrief {
	private String description;
	private List<ProductBrief> products;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<ProductBrief> getProducts() {
		return products;
	}
	public void setProducts(List<ProductBrief> products) {
		this.products = products;
	}
}
