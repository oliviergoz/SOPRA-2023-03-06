package formationJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import formationJpa.dao.ContextJpa;
import formationJpa.dao.DaoProduit;
import formationJpa.entities.Produit;

public class AppTest {
	public static void main(String[] args) {

		DaoProduit daoProduit = ContextJpa.getDaoProduit();

		Produit tele = new Produit("tele", 1000);

		tele = daoProduit.save(tele);

		System.out.println(daoProduit.findAll());

		daoProduit.save(new Produit("pc", 500));
		System.out.println(daoProduit.findAll());

		daoProduit.deleteByKey(1L);
		System.out.println(daoProduit.findAll());

		// a faire en dernier une fois!!
		ContextJpa.destroy();
	}
}
