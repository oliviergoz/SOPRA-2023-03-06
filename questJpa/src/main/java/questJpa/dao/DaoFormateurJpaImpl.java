package questJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import questJpa.entites.Formateur;

public class DaoFormateurJpaImpl implements DaoFormateur {

	@Override
	public Formateur save(Formateur obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Formateur obj) {
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
		em.remove(em.find(Formateur.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Formateur findByKey(Long key) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		Formateur formateur = em.find(Formateur.class, key);
		em.close();
		return formateur;
	}

	@Override
	public List<Formateur> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Formateur> query = em.createQuery("from Formateur f", Formateur.class);
		List<Formateur> formateurs = query.getResultList();
		em.close();
		return formateurs;
	}

}
