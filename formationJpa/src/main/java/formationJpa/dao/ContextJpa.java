package formationJpa.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContextJpa {
	private static ContextJpa singleton;
	private EntityManagerFactory emf;
	private static DaoProduit daoProduit = new DaoProduitJpaImpl();
	private static DaoPersonne daoPersonne = new DaoPersonneJpaImpl();

	public static DaoPersonne getDaoPersonne() {
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
