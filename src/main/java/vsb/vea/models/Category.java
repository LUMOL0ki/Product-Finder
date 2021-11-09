package vsb.vea.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Category extends BaseEntity<Long> {
	@NotEmpty(message = "name cannot be empty.")
	private String name;
	private String description;
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	private Date created;
	
	public Category() {
		created = new Date();
	}
	
	public Category(@NotEmpty(message = "name cannot be empty.") String name) {
		super();
		this.name = name;
	}

	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Category(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Category(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Category(long id, String name, String description, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.products = products;
	}
	
	public Category(long id, String name, String description, List<Product> products, Date created) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.products = products;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return name;
	}
}
