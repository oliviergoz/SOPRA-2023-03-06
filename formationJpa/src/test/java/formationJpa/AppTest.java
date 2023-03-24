package formationJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import formationJpa.dao.ContextJpa;
import formationJpa.dao.DaoClient;
import formationJpa.dao.DaoPersonneUneTable;
import formationJpa.dao.DaoProduit;
import formationJpa.entities.Civilite;
import formationJpa.entities.Produit;
import formationJpa.entities.heritage.deuxTables.Client;
import formationJpa.entities.heritage.deuxTables.Personne;
import formationJpa.entities.heritage.uneTable.ClientUneTable;
import formationJpa.entities.heritage.uneTable.FournisseurUneTable;

public class AppTest {
	public static void main(String[] args) {

		DaoProduit daoProduit = ContextJpa.getDaoProduit();
		DaoPersonneUneTable daoPersonneUneTable = ContextJpa.getDaoPersonneUneTable();
		DaoClient daoClient = ContextJpa.getDaoClient();

		Produit tele = new Produit("tele", 1000);

		for (int i = 0; i < 1000; i++) {
			tele.setDescription(tele.getDescription() + "ljljljk lkj lkj kl ");
		}

		tele = daoProduit.save(tele);

		// a faire en dernier une fois!!

//		ClientUneTable client = new ClientUneTable("client1", null, "client1", Civilite.M);
//		daoPersonneUneTable.save(client);
//
//		FournisseurUneTable frs = new FournisseurUneTable("frs1", null, "contact frs1");
//		daoPersonneUneTable.save(frs);
//
//		System.out.println(daoPersonneUneTable.findAll());
//		
//		System.out.println(daoPersonneUneTable.findAllClient());
//		System.out.println(daoPersonneUneTable.findAllFournisseur());

		Client client = new Client("client1", null, "client1", Civilite.MME);

		daoClient.save(client);
		
		
		ContextJpa.destroy();
	}
}
