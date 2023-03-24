package formationJpa.entities.heritage.uneTable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import formationJpa.entities.Adresse;
import formationJpa.entities.Civilite;

@DiscriminatorValue("customer")
@Entity
public class ClientUneTable extends PersonneUneTable {
	@Column(name = "customer_first_name")
	private String prenom;
	@Enumerated(EnumType.STRING)
	@Column(name="customer_civility")
	private Civilite civilite;

	public ClientUneTable() {

	}

	public ClientUneTable(String nom, Adresse adresse, String prenom, Civilite civilite) {
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
