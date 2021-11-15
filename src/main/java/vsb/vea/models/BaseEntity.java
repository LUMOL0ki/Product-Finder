package vsb.vea.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class BaseEntity<Tkey> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Tkey id;

	public Tkey getId() {
		return id;
	}

	public void setId(Tkey id) {
		this.id = id;
	}
}
