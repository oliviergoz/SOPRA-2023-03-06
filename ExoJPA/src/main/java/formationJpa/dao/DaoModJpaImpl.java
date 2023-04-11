package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Mod;

public class DaoModJpaImpl implements DaoMod{

	@Override
	public Mod save(Mod obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Mod obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Mod.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Mod findByKey(Long key) {
		Mod mod = null;
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		mod = em.find(Mod.class, key);
		em.close();
		return mod;
	}

	@Override
	public List<Mod> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		// ci-dessous, select ... from Entity ... where ...
		TypedQuery<Mod> query = em.createQuery("select m from Mod m", Mod.class);
		List<Mod> modules = query.getResultList();
		em.close();
		return modules;
	}

}
