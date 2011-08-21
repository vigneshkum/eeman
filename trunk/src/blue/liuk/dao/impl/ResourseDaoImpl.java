/**
 * 
 */
package blue.liuk.dao.impl;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import blue.liuk.base.CommDaoImpl;
import blue.liuk.dao.ResourseDao;
import blue.liuk.model.Resourse;

/**
 * @author Administrator
 *
 */
@Component
public class ResourseDaoImpl extends CommDaoImpl<Resourse, Integer> implements ResourseDao {

	@Override
	public List<Resourse> getAll(Integer[] ids) {
	
		
		List<Resourse> list = new ArrayList<Resourse>();
		
		for (Integer id : ids) {
			list.add(super.findById(Resourse.class, id));
		}

		return list;
	}
	
	@Override
	public List<Resourse> getByRole(Integer roleid) {
		final String hql1 = "select u from Role r , Resourse u where r.id=? and u in elements(r.resourses)";
		final Integer id = roleid;
		List<Resourse> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql1);
				query.setParameter(0, id);
				return query.list();
			}
		});

		return list;
		
	}
	
	@Override
	public List<Resourse> getByRoleNot(Integer roleid) {
		final String hql1 = "select u from Resourse u where  u not in(select u from Role r , Resourse u where r.id=? and u in elements(r.resourses))";
		final Integer id = roleid;
		List<Resourse> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql1);
				query.setParameter(0, id);
				return query.list();
			}
		});

		return list;

	}

}
