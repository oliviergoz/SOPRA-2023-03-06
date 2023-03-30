package demoSpring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import demoSpring.beans.IPersonne;
import demoSpring.beans.Moto;
import demoSpring.beans.Personne;
import demoSpring.beans.Vehicule;

@Configuration
@ComponentScan({ "demoSpring.beans" })
public class SpringConfig {

	@Bean("yamaha")
	public Vehicule moto() {
		return new Moto();
	}

	@Bean("olivier")
	public IPersonne olivier(@Qualifier("yamaha") Vehicule vehicule) {
		Personne olivier = new Personne();
		System.out.println(vehicule);
		olivier.setVehicule(vehicule);
		System.out.println("---------bean---------");
		System.out.println(olivier.getVehicule());
		System.out.println(olivier);
		return olivier;
	}
}
