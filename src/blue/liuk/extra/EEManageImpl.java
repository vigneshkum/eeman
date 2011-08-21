/**
 * 
 */
package blue.liuk.extra;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import blue.liuk.base.BaseDao;
import blue.liuk.model.Resourse;
import blue.liuk.model.Role;
import blue.liuk.model.User;

/**
 * @author liuk
 * @see blue.dao.EEManage
 */
@Component
public class EEManageImpl extends BaseDao implements EEManage {

	@Override
	public void save(User user) {
		getHibernateTemplate().save(user);

	}

	@Override
	public User read(Integer id) {
		return (User) getHibernateTemplate().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		String hql = "from User";
		return getHibernateTemplate().find(hql);
	}

	@Override
	public User login(String username, String password) {
		final String hql = "from User u where u.username=? and u.passwoed=?";
		final String name = username;
		final String pass = password;
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<User> list = getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setParameter(0, name);
				query.setParameter(1, pass);
				return query.list();
			}
		});
		if (list.size() > 0) {
			return list.iterator().next();
		} else {
			return null;
		}

	}

	@Override
	public List<Role> getRoleByUser(String name) {
		final String hql1 = "select r from Role r, User u where u.username=? and r  in elements(u.roles) ";
		final String n = name;
		List<Role> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql1);
				query.setParameter(0, n);
				return query.list();
			}
		});

		return list;

	}

	@Override
	public List<Resourse> getRes(String name) {
		final String hql1 = "select res from Resourse res where res.name=?";
		final String n = name;
		List<Resourse> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql1);
				query.setParameter(0, n);
				return query.list();
			}
		});

		return list;

	}

	@Override
	public List<Role> getRoleByRes(String name) {
		final String hql1 = "select r from Role r , Resourse u where u.name=? and r in elements(u.roles)";
		final String n = name;
		List<Role> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql1);
				query.setParameter(0, n);
				return query.list();
			}
		});

		return list;

	}

}
