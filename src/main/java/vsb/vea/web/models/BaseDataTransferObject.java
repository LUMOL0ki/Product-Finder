package vsb.vea.web.models;

public abstract class BaseDataTransferObject<Tkey> {
	protected Tkey id;

	public Tkey getId() {
		return id;
	}

	public void setId(Tkey id) {
		this.id = id;
	}
}
