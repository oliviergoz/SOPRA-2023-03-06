package formationJpa.entities;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "person")
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private Long id;
	@Column(name = "first_name", nullable = false)
	private String prenom;
	@Column(name = "last_name", nullable = false)
	private String nom;
	@Enumerated(EnumType.STRING)
	@Column(name = "civility", length = 3)
	private Civilite civilite;
	//@Transient //pas de correspondance dans la base
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "numero",column = @Column(name="personn_adress_number",length = 50)),
		@AttributeOverride(name="rue",column = @Column(name="personn_street")),
		@AttributeOverride(name="codePostal",column = @Column(name="personn_zip_code",length = 20)),
		@AttributeOverride(name="ville",column = @Column(name="personn_city"))
	})
	private Adresse adresse;

	public Personne() {

	}

	public Personne(String prenom, String nom, Civilite civilite) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.civilite = civilite;
	}

	public Personne(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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
		Personne other = (Personne) obj;
		return Objects.equals(id, other.id);
	}

}
