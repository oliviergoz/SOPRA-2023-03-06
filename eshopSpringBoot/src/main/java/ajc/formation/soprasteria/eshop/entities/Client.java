package ajc.formation.soprasteria.eshop.entities;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.eshop.entities.Adresse;
import ajc.formation.soprasteria.eshop.entities.Civilite;
import ajc.formation.soprasteria.eshop.entities.Commande;
import ajc.formation.soprasteria.eshop.entities.jsonviews.JsonViews;

@Entity
@Table(name = "customer")
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
@AttributeOverride(name = "nom", column = @Column(name = "customer_last_name"))
@AttributeOverride(name = "adresse.numero", column = @Column(name = "customer_number"))
@AttributeOverride(name = "adresse.rue", column = @Column(name = "customer_street"))
@AttributeOverride(name = "adresse.codePostal", column = @Column(name = "customer_zip_code"))
@AttributeOverride(name = "adresse.ville", column = @Column(name = "customer_city"))
public class Client extends Personne {
	@Column(name = "customer_first_name", nullable = false)
	@NotBlank
	@JsonView(JsonViews.Simple.class)
	private String prenom;
	@Enumerated(EnumType.STRING)
	@JsonView(JsonViews.Simple.class)
	@Column(name = "customer_civility")
	private Civilite civilite;
	@JsonView({ JsonViews.ClientWithCommandes.class, JsonViews.ClientWithCompte.class })
	@OneToMany(mappedBy = "client")
	private Set<Commande> commandes;
	@OneToOne
	@JoinColumn(name = "customer_user_id", foreignKey = @ForeignKey(name = "customer_user_id_fk"))
	@JsonView(JsonViews.ClientWithCompte.class)
	private Compte compte;

	public Client() {

	}

	public Client(String nom, Adresse adresse, String prenom, Civilite civilite) {
		super(nom, adresse);
		this.prenom = prenom;
		this.civilite = civilite;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		if (prenom != null) {
			this.prenom = prenom;
		}
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
