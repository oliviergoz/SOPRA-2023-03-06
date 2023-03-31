package eshop.entities;

import java.util.Objects;

import javax.persistence.Column;
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
@IdClass(AchatKey.class)
public class Achat {
	@Id
	@ManyToOne
	@JoinColumn(name = "purchase_v2_shipping_id", foreignKey = @ForeignKey(name = "purchase_v2_shipping_id_fk"))
	private Commande commande;
	@Id
	@ManyToOne
	@JoinColumn(name = "purchase_v2_product_id", foreignKey = @ForeignKey(name = "purchase_v2_product_id_fk"))
	private Produit produit;
	@Column(name="quantity")
	private int quantite;

	public Achat() {

	}

	public Achat(Commande commande, Produit produit, int quantite) {
		super();
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
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

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
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
		Achat other = (Achat) obj;
		return Objects.equals(commande, other.commande) && Objects.equals(produit, other.produit);
	}

}
