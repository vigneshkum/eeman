package blue.liuk.extra;

import java.util.List;

import blue.liuk.model.Resourse;
import blue.liuk.model.Role;
import blue.liuk.model.User;

public interface EEManage {
	public void save(User user);
	public User  read(Integer id);
	public List<User> getAll();
	User login(String username, String password);
	List<Role> getRoleByRes(String name);
	List<Role> getRoleByUser(String name);
	List<Resourse> getRes(String name);
}
