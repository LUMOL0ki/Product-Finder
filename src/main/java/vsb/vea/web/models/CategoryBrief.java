package vsb.vea.web.models;

public class CategoryBrief extends BaseDataTransferObject<Long> {
	private String name;
		
	public CategoryBrief() {
		super();
	}

	public CategoryBrief(String name) {
		super();
		this.name = name;
	}

	public CategoryBrief(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
