package formationJpa.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Commande;
import formationJpa.entities.classId.AchatAvecClassId;

public class DaoCommandeJpaImpl implements DaoCommande {

	@Override
	public Commande save(Commande obj) {
		boolean create = false;
		Set<AchatAvecClassId> achats = obj.getAchats();
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (obj.getNumero() != null) {
			obj = em.merge(obj);
		} else {
			em.persist(obj);
			create = true;
		}
		tx.commit();
		if (create) {
			achats.forEach(achat -> {
				ContextJpa.getDaoAchatIdClass().save(achat);
			});
		}
		em.close();
		return obj;
	}

	@Override
	public void delete(Commande obj) {
		deleteByKey(obj.getNumero());
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Commande commande=em.find(Commande.class, key);
		commande.getAchats().forEach(achat->{
			em.remove(em.merge(achat));
		});
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
