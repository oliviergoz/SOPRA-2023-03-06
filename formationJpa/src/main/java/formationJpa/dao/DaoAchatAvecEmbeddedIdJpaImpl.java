package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Commande;
import formationJpa.entities.embeddedId.AchatAvecEmbeddedId;
import formationJpa.entities.embeddedId.AchatEmbeddedId;

public class DaoAchatAvecEmbeddedIdJpaImpl implements DaoAchatAvecEmbeddedId {

	@Override
	public AchatAvecEmbeddedId save(AchatAvecEmbeddedId obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(AchatAvecEmbeddedId obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(AchatEmbeddedId key) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(AchatAvecEmbeddedId.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public AchatAvecEmbeddedId findByKey(AchatEmbeddedId key) {
		AchatAvecEmbeddedId commande = null;
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		commande = em.find(AchatAvecEmbeddedId.class, key);
		em.close();
		return commande;
	}

	@Override
	public List<AchatAvecEmbeddedId> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<AchatAvecEmbeddedId> query = em.createQuery("from AchatAvecEmbeddedId c", AchatAvecEmbeddedId.class);
		List<AchatAvecEmbeddedId> achats = query.getResultList();
		em.close();
		return achats;
	}

}
