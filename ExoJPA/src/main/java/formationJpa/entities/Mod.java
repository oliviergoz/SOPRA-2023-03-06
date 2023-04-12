package formationJpa.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "module")
public class Mod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mod_id")
	private Long id;
	@Column(name = "mod_name")
	private String nom;
	@Column(name = "duration")
	private int duree;

	public Mod(String nom, int duree) {
		super();
		this.nom = nom;
		this.duree = duree;
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

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Mod() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(duree, id, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mod other = (Mod) obj;
		return duree == other.duree && Objects.equals(id, other.id) && Objects.equals(nom, other.nom);
	}



}

