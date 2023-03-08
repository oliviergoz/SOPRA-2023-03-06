package hospital.dao;
	import java.util.List;

	public interface DaoGeneric<T, K> {

		void insert(T obj);

		void update(T obj);

		void delete(T obj);

		void deleteByKey(K key);

		T findByKey(K key);

		List<T> findAll();
}
