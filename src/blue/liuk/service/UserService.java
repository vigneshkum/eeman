package blue.liuk.service;

import java.util.List;

import blue.liuk.base.CommDao;
import blue.liuk.model.User;
import blue.liuk.util.Page;

public interface UserService  {

	void delete(Integer id);

	void saveOrUpdate(User user);

	List<User> getAll(Page p);

	User getById(Integer id);

	void save(User user,Integer id);

	void add(User user,Integer id);

	List<User> getByName(String name);

	void saveRole(Integer id, Integer[] roleids);

}
