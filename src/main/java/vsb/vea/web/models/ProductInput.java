package vsb.vea.web.models;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ProductInput {
	@NotEmpty(message = "Name cannot be empty.")
	public String name;
	public String description;
	@NotEmpty(message = "Ean cannot be empty.")
	@Length(message = "Invalid EAN format.", min = 18, max = 18)
	public String ean;
	public long supplierId;
	public long categoryId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
}
