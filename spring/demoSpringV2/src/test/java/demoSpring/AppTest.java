package demoSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demoSpring.beans.IPersonne;
import demoSpring.beans.Vehicule;

public class AppTest {
	public static void main(String[] args) {
		// lancement de spring
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		// on peut utiliser spring
		// ne marche que si une seule Personne de disponible
		// Personne unePersonne = ctx.getBean(Personne.class);

		// Personne olivier=(Personne)ctx.getBean("olivier");

		IPersonne olivier = ctx.getBean("olivier", IPersonne.class);
		System.out.println(olivier);
		System.out.println(ctx.getBean("jeanne", IPersonne.class));
		// System.out.println(ctx.getBean(Personne.class));
		System.out.println(olivier.getPrenom());
		IPersonne jeanne = ctx.getBean("jeanne", IPersonne.class);
		jeanne.getVehicule().infos();

		System.out.println("----------------");
		ctx.getBean("voiture", Vehicule.class).infos();
		
		System.out.println(ctx.getBean("fiona", IPersonne.class));
		
		// arret de spring
		ctx.close();

	}
}
