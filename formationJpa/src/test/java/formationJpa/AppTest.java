package formationJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import formationJpa.dao.ContextJpa;
import formationJpa.dao.DaoAchatAvecClassId;
import formationJpa.dao.DaoAchatAvecEmbeddedId;
import formationJpa.dao.DaoClient;
import formationJpa.dao.DaoCommande;
import formationJpa.dao.DaoFournisseur;
import formationJpa.dao.DaoPersonneUneTable;
import formationJpa.dao.DaoProduit;
import formationJpa.entities.Civilite;
import formationJpa.entities.Commande;
import formationJpa.entities.Produit;
import formationJpa.entities.classId.AchatAvecClassId;
import formationJpa.entities.classId.AchatClassId;
import formationJpa.entities.embeddedId.AchatAvecEmbeddedId;
import formationJpa.entities.embeddedId.AchatEmbeddedId;
import formationJpa.entities.heritage.deuxTables.Client;
import formationJpa.entities.heritage.deuxTables.Fournisseur;
import formationJpa.entities.heritage.deuxTables.Personne;
import formationJpa.entities.heritage.uneTable.ClientUneTable;
import formationJpa.entities.heritage.uneTable.FournisseurUneTable;

public class AppTest {
	public static void main(String[] args) {

		testCommande();
		testCommandeV2();
		ContextJpa.destroy();
	}

	private static void testCommande() {
		DaoProduit daoProduit = ContextJpa.getDaoProduit();
		DaoClient daoClient = ContextJpa.getDaoClient();
		DaoFournisseur daoFournisseur = ContextJpa.getDaoFournisseur();
		DaoCommande daoCommande = ContextJpa.getDaoCommande();
		DaoAchatAvecEmbeddedId daoAchat = ContextJpa.getDaoAchat();

		Fournisseur fournisseur = new Fournisseur("frs1", null, "frs1");
		fournisseur = daoFournisseur.save(fournisseur);

		Produit tele = new Produit("tele", 1000);

		
		tele.setFournisseur(fournisseur);
		tele = daoProduit.save(tele);

		Produit produit2 = new Produit("produit2", 100);
		produit2.setFournisseur(fournisseur);
		produit2 = daoProduit.save(produit2);
		
		Client client=new Client("client1", null, "client1", null);
		client=daoClient.save(client);
		
		
		Commande commande=new Commande(client);
		commande=daoCommande.save(commande);
		
		AchatAvecEmbeddedId achat1=new AchatAvecEmbeddedId(new AchatEmbeddedId(commande,tele), 2);
		System.out.println("-------------achat avec embedded id--------------------");
		daoAchat.save(achat1);
		daoAchat.save(new AchatAvecEmbeddedId(new AchatEmbeddedId(commande, produit2), 10));
		System.out.println("-------------select v1-----------------");
		AchatAvecEmbeddedId achat= daoAchat.findByKey(new AchatEmbeddedId(commande, produit2));
		System.out.println(achat.getKey().getCommande().getNumero());
		System.out.println(achat.getKey().getProduit().getLibelle());
		System.out.println(achat.getQuantite());

	}
	
	private static void testCommandeV2() {
		DaoProduit daoProduit = ContextJpa.getDaoProduit();
		DaoClient daoClient = ContextJpa.getDaoClient();
		DaoFournisseur daoFournisseur = ContextJpa.getDaoFournisseur();
		DaoCommande daoCommande = ContextJpa.getDaoCommande();
		DaoAchatAvecClassId daoAchat = ContextJpa.getDaoAchatIdClass();

		Fournisseur fournisseur = new Fournisseur("frs1", null, "frs1");
		fournisseur = daoFournisseur.save(fournisseur);

		Produit tele = new Produit("tele", 1000);

		
		tele.setFournisseur(fournisseur);
		tele = daoProduit.save(tele);

		Produit produit2 = new Produit("produit2", 100);
		produit2.setFournisseur(fournisseur);
		produit2 = daoProduit.save(produit2);
		
		Client client=new Client("client1", null, "client1", null);
		client=daoClient.save(client);
		
		
		Commande commande=new Commande(client);
		commande=daoCommande.save(commande);
		
		AchatAvecClassId achat1=new AchatAvecClassId(commande,tele, 2);
		System.out.println("-------------------achat avec idClass------------------");
		daoAchat.save(achat1);
		daoAchat.save(new AchatAvecClassId(commande, produit2, 10));
		System.out.println("------------------select v2-------------------");
		AchatAvecClassId achat= daoAchat.findByKey(new AchatClassId(commande, produit2));
		System.out.println(achat.getCommande().getNumero());
		System.out.println(achat.getProduit().getLibelle());
		System.out.println(achat.getQuantite());
	}
}
