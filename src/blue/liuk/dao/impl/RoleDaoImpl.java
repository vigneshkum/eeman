/**
 * 
 */
package blue.liuk.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import blue.liuk.base.CommDaoImpl;
import blue.liuk.dao.RoleDao;
import blue.liuk.model.Role;

/**
 * @author Administrator
 *
 */
@Component
public class RoleDaoImpl extends CommDaoImpl<Role, Integer> implements RoleDao {

	@Override
	public List<Role> getByUser(Integer userid) {
		String hql = "select r from User u , Role r where u.id=? and r in elements(u.roles)";
		
		Object[] id=new Object[1];
		id[0]=userid;
		
		return findAll(hql, id, 0, 0);
		
	}
	
	@Override
	public List<Role> getByUserNot(Integer userid) {
		final String hql = "select r from Role r where  r not in(select r from User u , Role r where u.id=? and r in elements(u.roles))";
		Object[] id=new Object[1];
		id[0]=userid;
		return findAll(hql, id, 0, 0);
		
	}
	

}
