package vsb.vea.models;

import java.util.Date;
import java.util.List;

public class Category {
	public int id;
	public String name;
	public String description;
	public List<Product> products;
	public Date created;
}
