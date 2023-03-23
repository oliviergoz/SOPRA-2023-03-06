package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Produit;

public class DaoProduitJpaImpl implements DaoProduit {

	@Override
	public Produit save(Produit obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Produit obj) {
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
		em.remove(em.find(Produit.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Produit findByKey(Long key) {
		Produit produit = null;
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		produit = em.find(Produit.class, key);
		em.close();
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		// requete JPQL
		// select instance from Entity instance where ...
		// TypedQuery<Produit> query = em.createQuery("select p from Produit p",
		// Produit.class);
		TypedQuery<Produit> query = em.createQuery("from Produit p", Produit.class);
		List<Produit> produits = query.getResultList();
		em.close();
		return produits;
	}

}
