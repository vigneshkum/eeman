package blue.liuk.base;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 * SpringBaseDao,通过其静态方法返回HibernateCallback
 * 
 * @author liuk
 * 
 */
public class SpringBaseDao {

	// 传入分页信息
	public static HibernateCallback hibernateCallback(String s, int start, int pagesize) {
		final String sql = s;
		final int rs = start;
		final int ps = pagesize;
		return new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(sql);
				if (ps > 0 && rs >= 0) {
					query.setFirstResult(rs);
					query.setMaxResults(ps);
				}

				return query.list();
			}
		};
	}

	// 传入分页信息,shuxingchaxun
	public static HibernateCallback hibernateCallback(String s, Object value, int start, int pagesize) {
		final String sql = s;
		final int rs = start;
		final int ps = pagesize;
		final Object object = value;
		return new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(sql);
				query.setParameter(0, object);
				if (ps > 0 && rs >= 0) {
					query.setFirstResult(rs);
					query.setMaxResults(ps);
				}
				return query.list();
			}
		};
	}

	// 支持参数  map
	public static HibernateCallback hibernateCallback(String s, Map map, int start, int pagesize) {
		final String sql = s;
		final int rs = start;
		final int ps = pagesize;
		final Map paramas=map;
		
		return new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(sql);
				query.setProperties(paramas);
				if (ps > 0 && rs >= 0) {
					query.setFirstResult(rs);
					query.setMaxResults(ps);
				}
				return query.list();
			}
		};
	}
	
	// 支持参数  map
	public static HibernateCallback hibernateCallback(String s, Object[] os, int start, int pagesize) {
		final String sql = s;
		final int rs = start;
		final int ps = pagesize;
		final Object[] objects=os;
		
		return new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(sql);
				for (int i = 0; i < objects.length; i++) {
					query.setParameter(i, objects[i]);
					//query.setString(i, objects[i].toString());
				}
				if (ps > 0 && rs >= 0) {
					query.setFirstResult(rs);
					query.setMaxResults(ps);
				}
				return query.list();
			}
		};
	}
}