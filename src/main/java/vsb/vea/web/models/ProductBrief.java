package vsb.vea.web.models;

public class ProductBrief extends BaseDataTransferObject<Long> {
	private String name;
	private String ean;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEan() {
		return ean;
	}
	public void setEan(String ean) {
		this.ean = ean;
	}
}
