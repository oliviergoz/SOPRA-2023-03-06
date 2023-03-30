package demoSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demoSpring.beans.Personne;

public class AppTest {
	public static void main(String[] args) {
		// lancement de spring
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		// on peut utiliser spring
		// ne marche que si une seule Personne de disponible
		//Personne unePersonne = ctx.getBean(Personne.class);

		// Personne olivier=(Personne)ctx.getBean("olivier");

		Personne olivier = ctx.getBean("olivier", Personne.class);
		System.out.println(olivier);
		System.out.println(ctx.getBean("jeanne", Personne.class));
		//System.out.println(ctx.getBean(Personne.class));
		System.out.println(olivier.getPrenom());
		// arret de spring
		ctx.close();

	}
}
