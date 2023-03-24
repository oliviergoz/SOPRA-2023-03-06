package questJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import questJpa.entites.Module;

public class DaoModuleJpaImpl implements DaoModule {

	@Override
	public Module save(Module obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Module obj) {
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
		em.remove(em.find(Module.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Module findByKey(Long key) {
		Module module = null;
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		module = em.find(Module.class, key);
		em.close();
		return module;
	}

	@Override
	public List<Module> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Module> query = em.createQuery("from Module p", Module.class);
		List<Module> modules = query.getResultList();
		em.close();
		return modules;
	}

}
