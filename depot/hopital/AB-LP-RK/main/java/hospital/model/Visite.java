package hospital.model;

import java.util.Date;
import java.util.Objects;

public class Visite  {
	private int numero;
	private double cout=20;
	private String salle;
	private Date date;
	private Patient patient;
	private Compte medecin;
	
	public Visite() {
		
	}
	

	public Visite(int numero, double cout, String salle, Date date, Patient patient, Compte medecin) {
		super();
		this.numero = numero;
		this.cout = cout;
		this.salle = salle;
		this.date = date;
		this.patient = patient;
		this.medecin = medecin;
	}


	public Visite(double cout, String salle, Date date, Patient patient, Compte medecin) {
		super();
		this.cout = cout;
		this.salle = salle;
		this.date = date;
		this.patient = patient;
		this.medecin = medecin;
	}


	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getCout() {
		return cout;
	}

	public void setCout(double cout) {
		this.cout = cout;
	}

	public String getSalle() {
		return salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Compte getMedecin() {
		return medecin;
	}

	public void setMedecin(Compte medecin) {
		this.medecin = medecin;
	}
	
	public int getIdPatient () {
		return getPatient().getId();
	}
	
	public int getIdMedecin () {
		return getMedecin().getId();
	}


	@Override
	public int hashCode() {
		return Objects.hash(date);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visite other = (Visite) obj;
		return Objects.equals(date, other.date);
	}
	
	
}
