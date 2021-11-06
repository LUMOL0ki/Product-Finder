package vsb.vea.web.models;

public class ProductDetail extends ProductBrief {
	private String description;
	private String ean;
	private SupplierBrief supplier;
	private CategoryBrief category;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEan() {
		return ean;
	}
	public void setEan(String ean) {
		this.ean = ean;
	}
	public SupplierBrief getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierBrief supplier) {
		this.supplier = supplier;
	}
	public CategoryBrief getCategory() {
		return category;
	}
	public void setCategory(CategoryBrief category) {
		this.category = category;
	}	
}
