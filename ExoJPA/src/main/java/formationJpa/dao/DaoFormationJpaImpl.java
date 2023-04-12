package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Formation;

public class DaoFormationJpaImpl implements DaoFormation {

	@Override
	public Formation save(Formation obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Formation obj) {
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
		em.remove(em.find(Formation.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Formation findByKey(Long key) {
		Formation formation = null;
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		formation = em.find(Formation.class, key);
		em.close();
		return formation;
	}

	@Override
	public List<Formation> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		// ci-dessous, select ... from Entity ... where ...
		TypedQuery<Formation> query = em.createQuery("select f from Formation f", Formation.class);
		List<Formation> formations = query.getResultList();
		em.close();
		return formations;
	}

}
