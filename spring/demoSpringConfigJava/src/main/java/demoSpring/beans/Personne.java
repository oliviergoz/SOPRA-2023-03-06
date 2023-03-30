package demoSpring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fiona")
public class Personne implements IPersonne {
	private String prenom;
	@Autowired
	@Qualifier("voiture")
	private Vehicule vehicule;

	public Personne() {

	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	@Override
	public void demoAspect() {
		System.out.println("demoAspect de personne");
		//throw new IllegalArgumentException();
	}

}
