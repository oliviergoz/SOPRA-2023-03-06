package questJpa.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import questJpa.entites.Stagiaire;

public class DaoStagiaireJpaImpl implements DaoStagiaire {

	@Override
	public Stagiaire save(Stagiaire obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Stagiaire obj) {
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
		em.remove(em.find(Stagiaire.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Stagiaire findByKey(Long key) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		Stagiaire stagiaire = em.find(Stagiaire.class, key);
		em.close();
		return stagiaire;
	}

	@Override
	public List<Stagiaire> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Stagiaire> query = em.createQuery("from Stagiaire f", Stagiaire.class);
		List<Stagiaire> stagiaires = query.getResultList();
		em.close();
		return stagiaires;
	}
	
	@Override
	public List<Stagiaire> findLessThan25year() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Stagiaire> query = em.createQuery("from Stagiaire s where year(CURRENT_DATE)-year(s.dateNaissance)<25", Stagiaire.class);
		List<Stagiaire> stagiaires = query.getResultList();
		
		em.close();
		return stagiaires;
	}

}
