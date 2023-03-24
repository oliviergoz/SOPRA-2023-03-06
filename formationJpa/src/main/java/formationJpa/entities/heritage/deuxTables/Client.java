package formationJpa.entities.heritage.deuxTables;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import formationJpa.entities.Adresse;
import formationJpa.entities.Civilite;

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
	private String prenom;
	@Enumerated(EnumType.STRING)
	@Column(name = "customer_civility")
	private Civilite civilite;

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
		this.prenom = prenom;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

}
