package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.heritage.uneTable.ClientUneTable;
import formationJpa.entities.heritage.uneTable.FournisseurUneTable;
import formationJpa.entities.heritage.uneTable.PersonneUneTable;

public class DaoPersonneUneTableJpaImpl implements DaoPersonneUneTable {

	@Override
	public PersonneUneTable save(PersonneUneTable obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(PersonneUneTable obj) {
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
		em.remove(em.find(PersonneUneTable.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public PersonneUneTable findByKey(Long key) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		PersonneUneTable personne = em.find(PersonneUneTable.class, key);
		em.close();
		return personne;
	}

	@Override
	public List<PersonneUneTable> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<PersonneUneTable> query = em.createQuery("from PersonneUneTable p", PersonneUneTable.class);
		List<PersonneUneTable> personnes = query.getResultList();
		em.close();
		return personnes;
	}

	@Override
	public List<ClientUneTable> findAllClient() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<ClientUneTable> query = em.createQuery("from ClientUneTable p", ClientUneTable.class);
		List<ClientUneTable> clients = query.getResultList();
		em.close();
		return clients;
	}

	@Override
	public List<FournisseurUneTable> findAllFournisseur() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<FournisseurUneTable> query = em.createQuery("from FournisseurUneTable p", FournisseurUneTable.class);
		List<FournisseurUneTable> frs = query.getResultList();
		em.close();
		return frs;
	}

}
