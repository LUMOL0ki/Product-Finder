package vsb.vea.models;

import javax.persistence.Id;

public abstract class BaseEntity<Tkey> {
	@Id
	protected Tkey id;

	public Tkey getId() {
		return id;
	}

	public void setId(Tkey id) {
		this.id = id;
	}
}
