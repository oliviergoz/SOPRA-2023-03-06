package questJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import questJpa.entites.Formateur;

@Repository
public class DaoFormateurJpaImpl implements DaoFormateur {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Formateur save(Formateur obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional
	public void delete(Formateur obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Formateur.class, key));
	}

	@Override
	public Formateur findByKey(Long key) {
		Formateur formateur = em.find(Formateur.class, key);
		return formateur;
	}

	@Override
	public List<Formateur> findAll() {
		TypedQuery<Formateur> query = em.createQuery("from Formateur f", Formateur.class);
		List<Formateur> formateurs = query.getResultList();
		return formateurs;
	}

	public Formateur findByIdFetchFormationsEnTantQueReferent(Long id) {
		Formateur formateur = null;
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
		TypedQuery<Formateur> query = em.createQuery("from Formateur f where f.interne=true", Formateur.class);
		List<Formateur> formateurs = query.getResultList();
		return formateurs;
	}

	@Override
	public List<Formateur> findAllExterne() {
		TypedQuery<Formateur> query = em.createQuery("from Formateur f where f.interne=false", Formateur.class);
		List<Formateur> formateurs = query.getResultList();
		return formateurs;
	}
}
