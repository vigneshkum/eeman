package blue.liuk.dao;

import java.util.List;

import blue.liuk.base.CommDao;
import blue.liuk.model.Role;

public interface RoleDao extends CommDao<Role, Integer> {

	List<Role> getByUser(Integer userid);

	List<Role> getByUserNot(Integer userid);

}
