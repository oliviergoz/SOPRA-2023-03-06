package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Produit;
import formationJpa.entities.heritage.deuxTables.Fournisseur;

public class DaoFournisseurJpaImpl implements DaoFournisseur {

	@Override
	public Fournisseur save(Fournisseur obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Fournisseur obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// suppression en cascade
		// ContextJpa.getDaoProduit().deleteByFournisseur(obj);
		// on remplace la reference du fournisseur à supprimer
		ContextJpa.getDaoProduit().setFournisseurToNullByFournisseur(obj);
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Fournisseur.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Fournisseur findByKey(Long key) {
		Fournisseur fournisseur = null;
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		fournisseur = em.find(Fournisseur.class, key);
		em.close();
		return fournisseur;
	}

	public Fournisseur findByKeyFetchProduits(Long key) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Fournisseur> query = em.createQuery(
				"select distinct f from Fournisseur f left join fetch f.produits  where f.id=:key", Fournisseur.class);
		query.setParameter("key", key);
		Fournisseur fournisseur = query.getSingleResult();
		em.close();
		return fournisseur;
	}

	public List<Fournisseur> findAllFetchProduits() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Fournisseur> query = em
				.createQuery("select distinct f from Fournisseur f left join fetch f.produits ", Fournisseur.class);
		List<Fournisseur> fournisseurs = query.getResultList();
		em.close();
		return fournisseurs;
	}

	@Override
	public List<Fournisseur> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Fournisseur> query = em.createQuery("from Fournisseur p", Fournisseur.class);
		List<Fournisseur> fournisseurs = query.getResultList();
		em.close();
		return fournisseurs;
	}

}
