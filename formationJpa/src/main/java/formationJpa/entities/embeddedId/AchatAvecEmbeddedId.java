package formationJpa.entities.embeddedId;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="purchase_v1")
public class AchatAvecEmbeddedId {
	// infos commande et du produit
	@EmbeddedId
	private AchatEmbeddedId key;
	@Column(name="quantity")
	private int quantite;

	public AchatAvecEmbeddedId() {

	}

	public AchatAvecEmbeddedId(AchatEmbeddedId key, int quantite) {
		super();
		this.key = key;
		this.quantite = quantite;
	}

	public AchatEmbeddedId getKey() {
		return key;
	}

	public void setKey(AchatEmbeddedId key) {
		this.key = key;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AchatAvecEmbeddedId other = (AchatAvecEmbeddedId) obj;
		return Objects.equals(key, other.key);
	}

}
