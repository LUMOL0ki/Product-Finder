package vsb.vea.models;

import java.util.Date;

public class Item {
	private int id;
	private String name;
	private String description;
	private String ean;
	private int supplierId;
	private Supplier supplier;
	private int categoryId;
	private Category category;
	private StatusType status;
	private Date created;
		
	public Item() {
		super();
	}

	public Item(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
		
	public Item(int id, String name, String ean) {
		super();
		this.id = id;
		this.name = name;
		this.ean = ean;
	}

	public Item(int id, String name, String description, String ean, int supplierId, int categoryId,
			StatusType status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ean = ean;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.status = status;
	}
		
	public Item(String name, String description, String ean, int supplierId, int categoryId) {
		super();
		this.name = name;
		this.description = description;
		this.ean = ean;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
	}

	public Item(int id, String name, String description, String ean, Supplier supplier, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ean = ean;
		this.supplier = supplier;
		this.category = category;
	}
		
	public Item(int id, String name, String description, String ean, int supplierId, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ean = ean;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
	}

	public Item(int id, String name, String description, String ean, int supplierId, Supplier supplier, int categoryId,
			Category category, StatusType status, Date created) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ean = ean;
		this.supplierId = supplierId;
		this.supplier = supplier;
		this.categoryId = categoryId;
		this.category = category;
		this.status = status;
		this.created = created;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
