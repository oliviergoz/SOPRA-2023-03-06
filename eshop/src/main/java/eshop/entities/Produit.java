package eshop.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.entities.jsonviews.JsonViews;

@Entity // Produit est un entite=>associe à un table de la base
@Table(name = "product") // par defaut le nom de la class est utilisé (attention au probleme des
							// majuscules avec certaines base

public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	@JsonView({ JsonViews.Simple.class })
	private Long id;
	@NotBlank(message = "il faut un libelle")
	@Column(name = "label", nullable = false, length = 255)
	@JsonView(JsonViews.Simple.class)
	private String libelle;
	@DecimalMin(value = "0.1")
	@Column(name = "price")
	@JsonView(JsonViews.Simple.class)
	private double prix;
	@Column(name = "description", columnDefinition = "TEXT")
	@Lob
	@JsonView(JsonViews.Simple.class)
	private String description;
	// 1 produit associe a 1 fournisseur=>????ToOne
	// 1 produit peut etre associe à plusieurs fournisseurs=>????ToMany
	// 1 fournisseur distribue 1 et 1 seul produit =>One?????
	// 1 fournissuer peut distribuer plusieurs produit =>Many????
	@ManyToOne // (fetch = FetchType.EAGER) valeur par defaut pour les relations @XXXToOne
	@JoinColumn(name = "product_supplier_id", foreignKey = @ForeignKey(name = "product_supplier_id_fk"))
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	private Fournisseur fournisseur;

	// obligatoire pour jpa
	public Produit() {

	}

	public Produit(String libelle, double prix, String description, Fournisseur fournisseur) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.description = description;
		this.fournisseur = fournisseur;
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

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
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
