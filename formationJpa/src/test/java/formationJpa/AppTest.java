package formationJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import formationJpa.dao.ContextJpa;
import formationJpa.dao.DaoClient;
import formationJpa.dao.DaoFournisseur;
import formationJpa.dao.DaoPersonneUneTable;
import formationJpa.dao.DaoProduit;
import formationJpa.entities.Civilite;
import formationJpa.entities.Produit;
import formationJpa.entities.heritage.deuxTables.Client;
import formationJpa.entities.heritage.deuxTables.Fournisseur;
import formationJpa.entities.heritage.deuxTables.Personne;
import formationJpa.entities.heritage.uneTable.ClientUneTable;
import formationJpa.entities.heritage.uneTable.FournisseurUneTable;

public class AppTest {
	public static void main(String[] args) {

		DaoProduit daoProduit = ContextJpa.getDaoProduit();
		DaoClient daoClient = ContextJpa.getDaoClient();
		DaoFournisseur daoFournisseur = ContextJpa.getDaoFournisseur();

		Fournisseur fournisseur = new Fournisseur("frs1", null, "frs1");
		fournisseur=daoFournisseur.save(fournisseur);
		
		System.out.println(fournisseur.getId());

		Produit tele = new Produit("tele", 1000);

		for (int i = 0; i < 1000; i++) {
			tele.setDescription(tele.getDescription() + "ljljljk lkj lkj kl ");
		}

		tele.setFournisseur(fournisseur);
		System.out.println("------------save tele--------------");
		tele = daoProduit.save(tele);

		ContextJpa.destroy();
	}
}
