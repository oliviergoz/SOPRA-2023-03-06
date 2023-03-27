package formationJpa.entities.classId;

import java.io.Serializable;
import java.util.Objects;

import formationJpa.entities.Commande;
import formationJpa.entities.Produit;

public class AchatClassId implements Serializable{
	private Commande commande;
	private Produit produit;

	public AchatClassId() {

	}

	public AchatClassId(Commande commande, Produit produit) {
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
		AchatClassId other = (AchatClassId) obj;
		return Objects.equals(commande, other.commande) && Objects.equals(produit, other.produit);
	}

}
