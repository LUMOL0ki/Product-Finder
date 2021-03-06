package vsb.vea.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Item extends BaseEntity<Long> {
	@NotEmpty(message = "name cannot be empty.")
	protected String name;
	protected String description;
    @Column(unique = true)
	@Length(min = 13, max = 13)
	protected String ean;
	@Column(name = "supplier_id", insertable = false, updatable = false)
	protected Long supplierId;
	@ManyToOne
	protected Supplier supplier = new Supplier();
	@Column(name = "category_id", insertable = false, updatable = false)
	protected Long categoryId;
	@ManyToOne
	protected Category category = new Category();
	protected StatusType status;
	protected Date created = new Date();
		
	public Item() {
		created = new Date();
	}

	public Item(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Item(String name, String ean) {
		super();
		this.name = name;
		this.ean = ean;
	}
		
	public Item(Long id, String name, String ean) {
		super();
		this.id = id;
		this.name = name;
		this.ean = ean;
	}
	
	public Item(String name, String description, String ean, long supplierId, long categoryId) {
		super();
		this.name = name;
		this.description = description;
		this.ean = ean;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
	}
	
	public Item(Long id, String name, String description, String ean, long supplierId, long categoryId,
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

	public Item(String name, String description, String ean, Supplier supplier, Category category) {
		super();
		this.name = name;
		this.description = description;
		this.ean = ean;
		this.supplier = supplier;
		this.category = category;
	}
	
	public Item(Long id, String name, String description, String ean, Supplier supplier, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ean = ean;
		this.supplier = supplier;
		this.category = category;
	}
		
	public Item(Long id, String name, String description, String ean, long supplierId, long categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ean = ean;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
	}

	public Item(Long id, String name, String description, String ean, long supplierId, Supplier supplier, long categoryId,
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
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
		this.supplier.setId(supplierId);
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
		this.category.setId(categoryId);
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
	
	@PrePersist
	protected void onCreate() {
	  created = new Date();
	}
}
