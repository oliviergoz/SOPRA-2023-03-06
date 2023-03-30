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

		IPersonne p = ctx.getBean("fiona", IPersonne.class);
		p.demoAspect();
		p.setPrenom("fiona");
		p.getPrenom();
		p.setPrenom("ddddd");
		p.getPrenom();
		// arret de spring
		ctx.close();

	}
}
