package vsb.vea.models;

import java.util.Date;

public class Product {
	public int id;
	public String name;
	public String description;
	public String EAN;
	public int supplierId;
	public Supplier supplier;
	public int categoryId;
	public Category category;
	public StatusType status;
	public Date created;
}
