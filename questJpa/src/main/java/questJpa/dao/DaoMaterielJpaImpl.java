package questJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import questJpa.entites.Materiel;
import questJpa.entites.Ordinateur;
import questJpa.entites.VideoProjecteur;

public class DaoMaterielJpaImpl implements DaoMateriel {

	@Override
	public Materiel save(Materiel obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Materiel obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(String key) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Materiel.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Materiel findByKey(String key) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		Materiel materiel = em.find(Materiel.class, key);
		em.close();
		return materiel;
	}

	@Override
	public List<Materiel> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Materiel> query = em.createQuery("from Materiel f", Materiel.class);
		List<Materiel> materiels = query.getResultList();
		em.close();
		return materiels;
	}

	@Override
	public List<Ordinateur> findAllOrdinateur() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Ordinateur> query = em.createQuery("from Ordinateur f", Ordinateur.class);
		List<Ordinateur> materiels = query.getResultList();
		em.close();
		return materiels;
	}

	@Override
	public List<VideoProjecteur> findAllVideoProjecteur() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<VideoProjecteur> query = em.createQuery("from VideoProjecteur f", VideoProjecteur.class);
		List<VideoProjecteur> materiels = query.getResultList();
		em.close();
		return materiels;
	}

}
