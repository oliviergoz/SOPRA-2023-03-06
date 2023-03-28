package questJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
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

	public Formateur findByIdFetchFormationsEnTantQueReferent(Long id) {
		Formateur formateur = null;
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Formateur> query = em.createQuery(
				"select distinct f from Formateur f left join fetch f.formationsEnTantQueReferent where f.id=:id",
				Formateur.class);
		query.setParameter("id", id);
		try {
			formateur = query.getSingleResult();
		} catch (NoResultException e) {
		}
		return formateur;
	}

	public Formateur findByIdFetchModulesAnimes(Long id) {
		Formateur formateur = null;
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Formateur> query = em.createQuery(
				"select distinct f from Formateur f left join fetch f.modulesAnimes where f.id=:id", Formateur.class);
		query.setParameter("id", id);
		try {
			formateur = query.getSingleResult();
		} catch (NoResultException e) {
		}
		return formateur;
	}

	public Formateur findByIdFetchFormationsEnTantQueReferentAndModulesAnimes(Long id) {
		Formateur formateur = null;
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Formateur> query = em.createQuery(
				"select distinct f from Formateur f left join fetch f.formationsEnTantQueReferent left join fetch f.modulesAnimes where f.id=:id",
				Formateur.class);
		query.setParameter("id", id);
		try {
			formateur = query.getSingleResult();
		} catch (NoResultException e) {
		}
		return formateur;
	}

	@Override
	public List<Formateur> findAllInterne() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Formateur> query = em.createQuery("from Formateur f where f.interne=true", Formateur.class);
		List<Formateur> formateurs = query.getResultList();
		em.close();
		return formateurs;
	}

	@Override
	public List<Formateur> findAllExterne() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Formateur> query = em.createQuery("from Formateur f where f.interne=false", Formateur.class);
		List<Formateur> formateurs = query.getResultList();
		em.close();
		return formateurs;
	}
}
