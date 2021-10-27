package vsb.vea.models;

import java.util.Date;
import java.util.List;

public class Supplier extends BaseEntity<Long> {
	private String name;
	private String description;
	private long addressId;
	private Address address;
	private String web;
	private List<Product> products;
	private Date created;
	
	public Supplier() {
		
	}
	
	public Supplier(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Supplier(String name, String description, Address address, String web) {
		super();
		this.name = name;
		this.description = description;
		this.address = address;
		this.web = web;
	}
	
	public Supplier(long id, String name, String description, Address address, String web) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.web = web;
	}

	public Supplier(long id, String name, String description, long addressId, Address address, String web) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.addressId = addressId;
		this.address = address;
		this.web = web;
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
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
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
}
