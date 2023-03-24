package formationJpa.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity // Produit est un entite=>associe à un table de la base
@Table(name = "product") // par defaut le nom de la class est utilisé (attention au probleme des
							// majuscules avec certaines base
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;
	@Column(name = "label", nullable = false, length = 255)
	private String libelle;
	@Column(name = "price")
	private double prix;
	@Column(name = "description", columnDefinition = "TEXT")
	@Lob
	private String description;

	// obligatoire pour jpa
	public Produit() {

	}

	public Produit(String libelle, double prix) {
		super();
		this.libelle = libelle;
		this.prix = prix;
	}

	public Produit(Long id, String libelle, double prix) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
	}

	public Produit(String libelle, double prix, String description) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		Produit other = (Produit) obj;
		return Objects.equals(id, other.id);
	}

}
