package eshop.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import eshop.entities.Commande;
import eshop.entities.Produit;

@Entity
@Table(name = "purchase_v2")

public class Achat {

	@EmbeddedId
	private AchatId id;

	@Column(name = "quantity")
	private int quantite;

	public Achat() {

	}

	public Achat(AchatId id, int quantite) {
		super();
		this.id = id;
		this.quantite = quantite;
	}

	public AchatId getId() {
		return id;
	}

	public void setId(AchatId id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Achat other = (Achat) obj;
		return Objects.equals(id, other.id);
	}

}
