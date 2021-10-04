package vsb.vea.models;

import java.util.Date;
import java.util.List;

public class Supplier {
	public int id;
	public String name;
	public String description;
	public int addressId;
	public Address address;
	public String web;
	public List<Product> products;
	public Date created;
}
