package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.entities.Client;

@Repository
public class DaoClientJpaImpl implements DaoClient {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Client save(Client obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional
	public void delete(Client obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Client.class, key));
	}

	@Override
	public Client findByKey(Long key) {
		Client client = null;
		client = em.find(Client.class, key);
		return client;
	}

	@Override
	public List<Client> findAll() {
		TypedQuery<Client> query = em.createQuery("from Client p", Client.class);
		List<Client> clients = query.getResultList();
		return clients;
	}

	// pas propre
	public Client findByIdfetchCommandefetchAchats(Long id) {
		TypedQuery<Client> query = em.createQuery(
				"select distinct c from Client c left join fetch c.commandes cmd left join fetch cmd.achats where c.id=:id",
				Client.class);
		query.setParameter("id", id);
		Client client = null;
		try {
			client = query.getSingleResult();
		} catch (NoResultException ex) {

		}
		return client;
	}

}
