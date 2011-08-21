package blue.liuk.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 基于泛型的通用hibernate dao
 * 主要实现了一些常用的方法。
 * @author liuk
 * @param <T>
 * @param <PK>
 */
@Component
public class CommDaoImpl<T, PK extends Serializable> extends BaseDao implements CommDao<T, PK> {
	
	@Override
	public void delete(T entity) {
		
		getHibernateTemplate().delete(entity);
	}
	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);

	}
	@Override
	public void saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);

	}

	/**
	 * 查询所有
	 * 
	 * @param entityClass
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> entityClass) {

		return (List<T>) getHibernateTemplate().loadAll(entityClass);
	}

	/**
	 * 分页查询所有
	 * 
	 * @param entityClass
	 * @param start
	 * @param limit
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> entityClass, int start, int limit) {
		String hql = "from " + entityClass.getName();
		List<T> list = (List<T>) getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback(hql, start, limit));
		return list;
	}

	/**
	 * 分页带参数查询所有
	 * 
	 * @param hql
	 * @param params
	 * @param start
	 * @param limit
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll(String hql, Object[] params, int start, int limit) {
		List<T> list = (List<T>) getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback(hql, params, start, limit));
		return list;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T entity) {
		return getHibernateTemplate().findByExample(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Class<T> entityClass, PK id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * @param entityClass
	 * @param propertyName
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperty(Class<T> entityClass, String propertyName, Object value,String type) {
		String queryString = "from " + entityClass.getName() + " as model where model." + propertyName +type;
		
		return getHibernateTemplate().find(queryString, value);
	}
	

	/**
	 * @param entityClass
	 * @param propertyName
	 * @param value
	 * @param start
	 * @param limit
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperty(Class<T> entityClass, String propertyName, Object value,String type, int start, int limit) {
		String hql = "from " + entityClass.getName() + " as model where model." + propertyName + type;
		List<T> list = (List<T>) getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback(hql, value, start, limit));
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotalCount(Class<T> entityClass, String propertyName, Object value,String type) {
	
		String hql = "select count(o.id) from " + entityClass.getName() + " o where o." + propertyName + type;
		List<T> list = (List<T>) getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback(hql, value, 0, 0));
		return ((Number) list.get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotalCount(Class<T> entityClass) {

		String hql = "select count(o.id) from " + entityClass.getName() + " o";
		List<T> list = (List<T>) getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback(hql, 0, 0));
		return ((Number) list.get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	public int getTotalCount(String hql, Object[] params) {
		List<T> list = (List<T>) getHibernateTemplate().executeFind(SpringBaseDao.hibernateCallback(hql, params, 0, 0));
		return ((Number) list.get(0)).intValue();
	}

}
