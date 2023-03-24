package formationJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import formationJpa.dao.ContextJpa;
import formationJpa.dao.DaoPersonne;
import formationJpa.dao.DaoProduit;
import formationJpa.entities.Civilite;
import formationJpa.entities.Personne;
import formationJpa.entities.Produit;

public class AppTest {
	public static void main(String[] args) {

		DaoProduit daoProduit = ContextJpa.getDaoProduit();
		DaoPersonne daoPersonne = ContextJpa.getDaoPersonne();

		Produit tele = new Produit("tele", 1000);

		for (int i = 0; i < 1000; i++) {
			tele.setDescription(tele.getDescription() + "ljljljk lkj lkj kl ");
		}

		tele = daoProduit.save(tele);

		// a faire en dernier une fois!!

		Personne personne = new Personne("olivier", "gozlan", Civilite.MME);
		daoPersonne.save(personne);

		System.out.println(daoPersonne.findByKey(1L).getCivilite().getTexte());

		ContextJpa.destroy();
	}
}
