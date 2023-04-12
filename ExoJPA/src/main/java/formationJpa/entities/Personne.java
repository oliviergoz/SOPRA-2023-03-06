package formationJpa.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personne")
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "personne_id")
	private Long id;
	@Column(name = "personne_name")
	private String nom;
	@Column(name = "personne_firstname")
	private String prenom;

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne() {

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(prenom, id, nom);
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
		return Objects.equals(prenom, other.prenom) && Objects.equals(id, other.id) && Objects.equals(nom, other.nom);
	}

}
