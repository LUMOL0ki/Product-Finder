package vsb.vea.models;

import java.util.Date;

public class Address extends BaseEntity<Long> {
	public String line;
	public String city;
	public String postalCode;
	public String country;
	public Date created;
	
	public Address(String line, String city, String postalCode, String country) {
		super();
		this.line = line;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}

	public Address(long id, String line, String city, String postalCode, String country) {
		super();
		this.id = id;
		this.line = line;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}
	
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
}
