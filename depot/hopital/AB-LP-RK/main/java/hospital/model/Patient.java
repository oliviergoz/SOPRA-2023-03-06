package hospital.model;

import java.util.Objects;

public class Patient {
	private String prenom;
	private String nom;
	private int id;
	
	public Patient () {
		
	}
	
	public Patient(String prenom, String nom ,int id) {
		this.prenom=prenom;
		this.nom=nom;
		this.id=id;
	}
	
	public void setPrenom(String prenom) {
		this.prenom=prenom;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public void setId (int id) {
		this.id=id;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getId() {
		return id;
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
		Patient other = (Patient) obj;
		return id == other.id;
	}
	
	
}
