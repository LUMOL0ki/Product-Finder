package vsb.vea.models;

import java.util.Date;

public class Address extends BaseEntity<Long> {
	public String line;
	public String city;
	public String postalCode;
	public String country;
	public Date created;
}
