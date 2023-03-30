package demoSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demoSpring.beans.IPersonne;
import demoSpring.beans.Personne;
import demoSpring.beans.Vehicule;
import demoSpring.config.SpringConfig;

public class AppTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

		System.out.println(ctx.getBean("fiona", IPersonne.class));
		System.out.println(ctx.getBean("fiona", IPersonne.class).getVehicule());
		IPersonne olivier = ctx.getBean("olivier", IPersonne.class);
		System.out.println(olivier);
		System.out.println(olivier.getVehicule());
		// arret de spring
		ctx.close();

	}
}
