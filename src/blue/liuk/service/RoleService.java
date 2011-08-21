package blue.liuk.service;

import java.util.List;


import blue.liuk.model.Role;
import blue.liuk.util.Page;

public interface RoleService  {

	void delete(Integer id);

	void saveOrUpdate(Role role);

	List<Role> getAll(Page p);

	Role getById(Integer id);


	List<Role> getByName(String name);



	void saveper(Integer id, Integer[] res);

	List<Role> getByUser(Integer userid);

	List<Role> getByUserNot(Integer userid);

	List<Role> getAll(Integer[] roleids);

}
