package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.classId.AchatAvecClassId;
import formationJpa.entities.classId.AchatClassId;
import formationJpa.entities.heritage.deuxTables.Client;

public class DaoAchatAvecClassIdJpaImpl implements DaoAchatAvecClassId {

	@Override
	public AchatAvecClassId save(AchatAvecClassId obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(AchatAvecClassId obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(AchatClassId key) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(AchatClassId.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public AchatAvecClassId findByKey(AchatClassId key) {
		AchatAvecClassId achat = null;
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		achat = em.find(AchatAvecClassId.class, key);
		em.close();
		return achat;
	}

	@Override
	public List<AchatAvecClassId> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<AchatAvecClassId> query = em.createQuery("from AchatAvecClassId p", AchatAvecClassId.class);
		List<AchatAvecClassId> achats = query.getResultList();
		em.close();
		return achats;
	}

}
