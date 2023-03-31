package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.entities.Achat;
import eshop.entities.AchatKey;

@Repository
public class DaoAchatJpaImpl implements DaoAchat {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Achat save(Achat obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional
	public void delete(Achat obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(AchatKey key) {
		em.remove(em.find(Achat.class, key));
	}

	@Override
	public Achat findByKey(AchatKey key) {
		return em.find(Achat.class, key);
	}

	@Override
	public List<Achat> findAll() {
		TypedQuery<Achat> query = em.createQuery("from Achat p", Achat.class);
		List<Achat> achats = query.getResultList();
		return achats;
	}

}
