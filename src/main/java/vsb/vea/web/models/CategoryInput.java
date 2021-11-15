package vsb.vea.web.models;

import javax.validation.constraints.NotEmpty;

public class CategoryInput {
	@NotEmpty(message = "Name cannot be empty.")
	private String name;
	private String description;
	
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
}
