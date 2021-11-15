package vsb.vea.web.models;

import javax.validation.constraints.NotEmpty;

public class SupplierInput {
	@NotEmpty(message = "name cannot be empty.")
	private String name;
	private String description;
	private AddressInput address;
	private String web;
	
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
	public AddressInput getAddress() {
		return address;
	}
	public void setAddress(AddressInput address) {
		this.address = address;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
}
