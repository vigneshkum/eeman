package blue.liuk.service;

import java.util.List;

import blue.liuk.model.Resourse;
import blue.liuk.util.Page;

public interface ResourseService  {

	void delete(Integer id);

	void saveOrUpdate(Resourse resourse);

	List<Resourse> getAll(Page p);

	Resourse getById(Integer id);


	List<Resourse> getByName(String name);

	List<Resourse> getAll();

	List<Resourse> getByRoleNot(Integer roleid);

	List<Resourse> getByRole(Integer roleid);

	List<Resourse> getAll(Integer[] ids);

}
