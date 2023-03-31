package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.entities.Fournisseur;
import eshop.entities.Produit;

@Repository
public class DaoProduitJpaImpl implements DaoProduit {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public Produit save(Produit obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional
	public void delete(Produit obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Produit.class, key));
	}

	@Override
	public Produit findByKey(Long key) {
		Produit produit = null;
		produit = em.find(Produit.class, key);
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		// requete JPQL
		// select instance from Entity instance where ...
		// TypedQuery<Produit> query = em.createQuery("select p from Produit p",
		// Produit.class);
		TypedQuery<Produit> query = em.createQuery("from Produit p", Produit.class);
		List<Produit> produits = query.getResultList();
		return produits;
	}

	public List<Produit> findByLibelle(String libelle) {
		TypedQuery<Produit> query = em.createQuery("from Produit p where p.libelle like :param", Produit.class);
		query.setParameter("param", libelle);
		List<Produit> produits = query.getResultList();
		return produits;
	}

	public List<Produit> findByLibelleContaining(String libelle) {
		TypedQuery<Produit> query = em.createQuery("from Produit p where p.libelle like :libelle", Produit.class);
		query.setParameter("libelle", "%" + libelle + "%");
		List<Produit> produits = query.getResultList();
		return produits;
	}

	public List<Produit> findByFournisseur(Fournisseur fournisseur) {
		TypedQuery<Produit> query = em.createQuery("from Produit p where p.fournisseur=:fournisseur", Produit.class);
		query.setParameter("fournisseur", fournisseur);
		List<Produit> produits = query.getResultList();
		return produits;
	}

	public long count() {
		return em.createQuery("select count(p) from Produit p", Long.class).getSingleResult();
	}

	// update ou delete
	public void deleteByFournisseur(Fournisseur fournisseur) {
		Query query = em.createQuery("delete from Produit p where p.fournisseur=:fournisseur");
		query.setParameter("fournisseur", fournisseur);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();
	}

	public void setFournisseurToNullByFournisseur(Fournisseur fournisseur) {
		Query query = em.createQuery("update Produit p set p.fournisseur=null where p.fournisseur=:fournisseur");
		query.setParameter("fournisseur", fournisseur);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();
	}

}
