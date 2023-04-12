package formationJpa.entities;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="formation")
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="formation_id")
	private Long id;
	@Column(name="formation_name")
	private String nom;
	@Column(name="date")
	private LocalDate date;
	
	
	public Formation(String nom, LocalDate date) {
		super();
		this.nom = nom;
		this.date = date;
	}
	
	public Formation() {
		
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


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	@Override
	public int hashCode() {
		return Objects.hash(date, id, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formation other = (Formation) obj;
		return Objects.equals(date, other.date) && Objects.equals(id, other.id) && Objects.equals(nom, other.nom);
	}

	
}
