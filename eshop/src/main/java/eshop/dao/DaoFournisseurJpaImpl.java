package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.entities.Fournisseur;

@Repository
public class DaoFournisseurJpaImpl implements DaoFournisseur {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Fournisseur save(Fournisseur obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional
	public void delete(Fournisseur obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Fournisseur.class, key));
	}

	@Override
	public Fournisseur findByKey(Long key) {
		Fournisseur fournisseur = null;
		fournisseur = em.find(Fournisseur.class, key);
		return fournisseur;
	}

	public Fournisseur findByKeyFetchProduits(Long key) {
		TypedQuery<Fournisseur> query = em.createQuery(
				"select distinct f from Fournisseur f left join fetch f.produits  where f.id=:key", Fournisseur.class);
		query.setParameter("key", key);
		Fournisseur fournisseur = query.getSingleResult();
		return fournisseur;
	}

	public List<Fournisseur> findAllFetchProduits() {
		TypedQuery<Fournisseur> query = em
				.createQuery("select distinct f from Fournisseur f left join fetch f.produits ", Fournisseur.class);
		List<Fournisseur> fournisseurs = query.getResultList();
		return fournisseurs;
	}

	@Override
	public List<Fournisseur> findAll() {
		TypedQuery<Fournisseur> query = em.createQuery("from Fournisseur p", Fournisseur.class);
		List<Fournisseur> fournisseurs = query.getResultList();
		return fournisseurs;
	}

}
