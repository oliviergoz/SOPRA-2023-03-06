package eshop.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.entities.Achat;
import eshop.entities.Commande;

@Repository
public class DaoCommandeJpaImpl implements DaoCommande {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Commande save(Commande obj) {
		boolean create = false;
		Set<Achat> achats = obj.getAchats();
		if (obj.getNumero() != null) {
			obj = em.merge(obj);
		} else {
			em.persist(obj);
			create = true;
		}
		if (create) {
			achats.forEach(achat -> {
			});
		}
		return obj;
	}

	@Override
	public void delete(Commande obj) {
		deleteByKey(obj.getNumero());
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		Commande commande = em.find(Commande.class, key);
		commande.getAchats().forEach(achat -> {
			em.remove(em.merge(achat));
		});
		em.remove(em.find(Commande.class, key));
	}

	@Override
	public Commande findByKey(Long key) {
		Commande commande = null;
		commande = em.find(Commande.class, key);
		return commande;
	}

	@Override
	public List<Commande> findAll() {
		TypedQuery<Commande> query = em.createQuery("from Commande c", Commande.class);
		List<Commande> commandes = query.getResultList();
		return commandes;
	}

}
