package formationJpa.entities.heritage.deuxTables;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import formationJpa.entities.Adresse;
import formationJpa.entities.Produit;

@Entity
@Table(name = "supplier")
@AttributeOverride(name = "id", column = @Column(name = "supplier_id"))
@AttributeOverride(name = "nom", column = @Column(name = "supplier_name"))
@AttributeOverride(name = "adresse.numero", column = @Column(name = "supplier_number"))
@AttributeOverride(name = "adresse.rue", column = @Column(name = "supplier_street"))
@AttributeOverride(name = "adresse.codePostal", column = @Column(name = "supplier_zip_code"))
@AttributeOverride(name = "adresse.ville", column = @Column(name = "supplier_city"))
public class Fournisseur extends Personne {
	@Column(name = "supplier_contact", nullable = false)
	private String contact;
	@OneToMany(mappedBy = "fournisseur")
	//on peut utiliser des List ou des Set
	//si 1 collection=>List
	//si plusieurs collections=>Set
	private List<Produit> produits;

	public Fournisseur() {

	}

	public Fournisseur(String nom, Adresse adresse, String contact) {
		super(nom, adresse);
		this.contact = contact;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
