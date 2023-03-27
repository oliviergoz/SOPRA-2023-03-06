package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Commande;

public class DaoCommandeJpaImpl implements DaoCommande {

	@Override
	public Commande save(Commande obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Commande obj) {
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
		em.remove(em.find(Commande.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Commande findByKey(Long key) {
		Commande commande = null;
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		commande = em.find(Commande.class, key);
		em.close();
		return commande;
	}

	@Override
	public List<Commande> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Commande> query = em.createQuery("from Commande c", Commande.class);
		List<Commande> commandes = query.getResultList();
		em.close();
		return commandes;
	}

}
