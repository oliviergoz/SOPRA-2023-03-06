package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.heritage.deuxTables.Client;

public class DaoClientJpaImpl implements DaoClient {

	@Override
	public Client save(Client obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Client obj) {
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
		em.remove(em.find(Client.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Client findByKey(Long key) {
		Client client = null;
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		client = em.find(Client.class, key);
		em.close();
		return client;
	}

	@Override
	public List<Client> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		// requete JPQL
		// select instance from Entity instance where ...
		// TypedQuery<Client> query = em.createQuery("select p from Client p",
		// Client.class);
		TypedQuery<Client> query = em.createQuery("from Client p", Client.class);
		List<Client> clients = query.getResultList();
		em.close();
		return clients;
	}

}
