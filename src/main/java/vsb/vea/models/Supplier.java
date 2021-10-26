package vsb.vea.models;

import java.util.Date;
import java.util.List;

public class Supplier {
	private int id;
	private String name;
	private String description;
	private int addressId;
	private Address address;
	private String web;
	private List<Product> products;
	private Date created;
	
	public Supplier(int id, String name) {
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
	
	public Supplier(int id, String name, String description, Address address, String web) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.web = web;
	}

	public Supplier(int id, String name, String description, int addressId, Address address, String web) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.addressId = addressId;
		this.address = address;
		this.web = web;
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
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
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
