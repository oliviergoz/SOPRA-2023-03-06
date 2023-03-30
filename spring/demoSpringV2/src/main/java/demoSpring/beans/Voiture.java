package demoSpring.beans;

import org.springframework.stereotype.Component;

//@Component("voiture")
@Component
public class Voiture implements Vehicule {

	public Voiture() {

	}

	public void infos() {
		System.out.println("je suis une voiture");
	}
}
