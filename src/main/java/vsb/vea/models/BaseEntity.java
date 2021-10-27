package vsb.vea.models;

public abstract class BaseEntity<Tkey> {
	
	protected Tkey id;

	public Tkey getId() {
		return id;
	}

	public void setId(Tkey id) {
		this.id = id;
	}
}