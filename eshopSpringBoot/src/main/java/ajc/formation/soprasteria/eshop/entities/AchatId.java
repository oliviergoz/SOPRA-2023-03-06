package ajc.formation.soprasteria.eshop.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.eshop.entities.jsonviews.JsonViews;

@Embeddable
public class AchatId implements Serializable {
	@ManyToOne
	@JoinColumn(name = "purchase_v2_shipping_id", foreignKey = @ForeignKey(name = "purchase_v2_shipping_id_fk"), insertable = false, updatable = false)
	private Commande commande;
	@ManyToOne
	@JoinColumn(name = "purchase_v2_product_id", foreignKey = @ForeignKey(name = "purchase_v2_product_id_fk"), insertable = false, updatable = false)
	@JsonView(JsonViews.CommandeWithAchats.class)
	private Produit produit;

	public AchatId() {

	}

	public AchatId(Commande commande, Produit produit) {
		super();
		this.commande = commande;
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commande, produit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AchatId other = (AchatId) obj;
		return Objects.equals(commande, other.commande) && Objects.equals(produit, other.produit);
	}

}
