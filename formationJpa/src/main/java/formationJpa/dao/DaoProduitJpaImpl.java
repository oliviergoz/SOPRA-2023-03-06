package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Produit;
import formationJpa.entities.heritage.deuxTables.Fournisseur;

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

	public List<Produit> findByLibelle(String libelle) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Produit> query = em.createQuery("from Produit p where p.libelle like :param", Produit.class);
		query.setParameter("param", libelle);
		List<Produit> produits = query.getResultList();
		em.close();
		return produits;
	}

	public List<Produit> findByLibelleContaining(String libelle) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Produit> query = em.createQuery("from Produit p where p.libelle like :libelle", Produit.class);
		query.setParameter("libelle", "%" + libelle + "%");
		List<Produit> produits = query.getResultList();
		em.close();
		return produits;
	}

	public List<Produit> findByFournisseur(Fournisseur fournisseur) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Produit> query = em.createQuery("from Produit p where p.fournisseur=:fournisseur", Produit.class);
		query.setParameter("fournisseur", fournisseur);
		List<Produit> produits = query.getResultList();
		em.close();
		return produits;
	}

	public long count() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Long> count = em.createQuery("select count(p) from Produit p", Long.class);
		long resultat = count.getSingleResult();
		em.close();
		return resultat;
	}

}
