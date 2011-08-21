package blue.liuk.extra;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import blue.liuk.base.BaseDao;
import blue.liuk.model.User;

/**
 * @author liuk
 * 
 */
@Component
public class CheckUserImpl extends BaseDao implements CheckUser {
	/**
	 * 用户名表单name
	 * 
	 * @author liuk
	 * 
	 */
	public static String USER_NAME = "username";
	/**
	 * 密码表当name
	 * 
	 * @author liuk
	 * 
	 */
	public static String USER_PASSWORD = "password";

	/**
	 * 登陆判断
	 * 
	 * @author liuk
	 * @return user
	 * 
	 */
	@Override
	public User doCheck(HttpServletRequest request) {
		String username = request.getParameter(USER_NAME);
		String password = request.getParameter(USER_PASSWORD);

		username = username.trim();

		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}

		return getUserByNamePassword(username, password);

	}
	/**
	 * 查询用户
	 * @param
	 * @author liuk
	 * @return user
	 * 
	 */
	
	public User getUserByNamePassword(String name, String pass) {

		final String hql = "from User u where u.username=? and u.password=?";
		final String username = name;
		final String password = pass;
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<User> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setParameter(0, username);
						query.setParameter(1, password);
						return query.list();
					}
				});
		if (list.size() > 0) {
			return list.iterator().next();
		} else {
			return null;
		}
	}
}
