/**
 * 
 */
package blue.liuk.base;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface CommDao<T,PK> {

	void delete(T entity);

	void save(T entity);

	void saveOrUpdate(T entity);

	List<T> findAll(Class<T> entityClass);

	List<T> findAll(Class<T> entityClass, int start, int limit);

	List<T> findByExample(T entity);

	T findById(Class<T> entityClass, PK id);

	List<T> findByProperty(Class<T> entityClass, String propertyName, Object value, String type);


	int getTotalCount(Class<T> entityClass, String propertyName, Object value, String type);

	int getTotalCount(Class<T> entityClass);

	List<T> findByProperty(Class<T> entityClass, String propertyName, Object value, String type, int start, int limit);

}
