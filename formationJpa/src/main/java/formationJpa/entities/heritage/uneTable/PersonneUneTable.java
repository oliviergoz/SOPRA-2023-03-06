package formationJpa.entities.heritage.uneTable;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import formationJpa.entities.Adresse;

@Entity
@Table(name = "personUneTable")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type",discriminatorType = DiscriminatorType.STRING,length = 10)
public abstract class PersonneUneTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private Long id;
	@Column(name = "name", nullable = false)
	private String nom;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "numero", column = @Column(name = "personn_adress_number", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "personn_street")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "personn_zip_code", length = 20)),
			@AttributeOverride(name = "ville", column = @Column(name = "personn_city")) })
	private Adresse adresse;

	public PersonneUneTable() {

	}

	public PersonneUneTable(String nom, Adresse adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
		PersonneUneTable other = (PersonneUneTable) obj;
		return Objects.equals(id, other.id);
	}

}
