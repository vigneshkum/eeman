package blue.liuk.dao;

import java.util.List;

import blue.liuk.base.CommDao;
import blue.liuk.model.Resourse;
import blue.liuk.model.Role;

public interface ResourseDao extends CommDao<Resourse, Integer> {

	List<Resourse> getByRoleNot(Integer roleid);

	List<Resourse> getByRole(Integer roleid);

	List<Resourse> getAll(Integer[] ids);

}
