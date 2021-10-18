package vsb.vea.models;

import java.util.Date;

public class Item {
	public int id;
	public String name;
	public String description;
	public String ean;
	public int supplierId;
	public Supplier supplier;
	public int categoryId;
	public Category category;
	public StatusType status;
	public Date created;
}
