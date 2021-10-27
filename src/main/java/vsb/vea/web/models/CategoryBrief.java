package vsb.vea.web.models;

public class CategoryBrief extends BaseDataTransferObject<Long> {
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
