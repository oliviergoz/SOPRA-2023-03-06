package questJpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import questJpa.config.JpaConfig;
import questJpa.dao.DaoFormateur;
import questJpa.entites.Formateur;

public class AppTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
		DaoFormateur daoFormateur = ctx.getBean(DaoFormateur.class);

		daoFormateur.save(new Formateur("lll", "llllll", "llllll", false));

	}

}
