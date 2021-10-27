package vsb.vea.web.models;

public class SupplierDetail extends SupplierBrief {
	private String name;
	private String description;
	private AddressDetail address;
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
	public AddressDetail getAddress() {
		return address;
	}
	public void setAddress(AddressDetail address) {
		this.address = address;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
}
