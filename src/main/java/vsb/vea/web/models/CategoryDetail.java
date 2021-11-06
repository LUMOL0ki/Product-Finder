package vsb.vea.web.models;

import java.util.List;

public class CategoryDetail extends CategoryBrief {
	private String description;
	private List<ProductBrief> products;
	
	public CategoryDetail() {
		super();
	}
	
	public CategoryDetail(String name, String description) {
		super(name);
		this.description = description;
	}

	public CategoryDetail(long id, String name, String description) {
		super(name);
		this.id = id;
		this.description = description;
	}

	public CategoryDetail(String name, String description, List<ProductBrief> products) {
		super(name);
		this.description = description;
		this.products = products;
	}

	public CategoryDetail(long id, String name, String description, List<ProductBrief> products) {
		super(name);
		this.id = id;
		this.description = description;
		this.products = products;
	}

	
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
