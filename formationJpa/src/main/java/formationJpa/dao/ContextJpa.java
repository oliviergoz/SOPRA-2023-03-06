package formationJpa.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContextJpa {
	private static ContextJpa singleton;
	private EntityManagerFactory emf;
	private static DaoProduit daoProduit = new DaoProduitJpaImpl();
	private static DaoPersonneUneTable daoPersonne = new DaoPersonneUneTableJpaImpl();
	private static DaoClient daoClient = new DaoClientJpaImpl();
	private static DaoFournisseur daoFournisseur = new DaoFournisseurJpaImpl();
	private static DaoAchatAvecEmbeddedId daoAchat = new DaoAchatAvecEmbeddedIdJpaImpl();
	private static DaoCommande daoCommande = new DaoCommandeJpaImpl();
	private static DaoAchatAvecClassId daoAchatIdClass = new DaoAchatAvecClassIdJpaImpl();

	public static DaoAchatAvecClassId getDaoAchatIdClass() {
		return daoAchatIdClass;
	}

	public static DaoCommande getDaoCommande() {
		return daoCommande;
	}

	public static DaoClient getDaoClient() {
		return daoClient;
	}

	public static DaoAchatAvecEmbeddedId getDaoAchat() {
		return daoAchat;
	}

	public static DaoFournisseur getDaoFournisseur() {
		return daoFournisseur;
	}

	public static DaoPersonneUneTable getDaoPersonneUneTable() {
		return daoPersonne;
	}

	public static DaoProduit getDaoProduit() {
		return daoProduit;
	}

	private ContextJpa() {
		emf = Persistence.createEntityManagerFactory("eshop");
	}

	public static ContextJpa getInstance() {
		if (singleton == null) {
			singleton = new ContextJpa();
		}
		return singleton;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

	public static void destroy() {
		if (singleton != null) {
			singleton.getEntityManagerFactory().close();
			singleton = null;
		}
	}
}
