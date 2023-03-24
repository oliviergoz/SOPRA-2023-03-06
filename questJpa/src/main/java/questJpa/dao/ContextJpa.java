package questJpa.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContextJpa {
	private static ContextJpa singleton;
	private EntityManagerFactory emf;
	private static DaoPersonne daoPersonne=new DaoPersonneJpaImpl();
	private static DaoFormation daoFormation=new DaoFormationJpaImpl();
	private static DaoModule daoModule=new DaoModuleJpaImpl();

	public static DaoPersonne getDaoPersonne() {
		return daoPersonne;
	}

	public static DaoFormation getDaoFormation() {
		return daoFormation;
	}

	public static DaoModule getDaoModule() {
		return daoModule;
	}

	private ContextJpa() {
		emf = Persistence.createEntityManagerFactory("quest");
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
