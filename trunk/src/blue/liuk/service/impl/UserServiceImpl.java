package blue.liuk.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blue.liuk.base.BaseDao;
import blue.liuk.dao.UserDao;
import blue.liuk.exception.ErrorMsg;
import blue.liuk.exception.HrException;
import blue.liuk.model.Employee;
import blue.liuk.model.Role;
import blue.liuk.model.User;
import blue.liuk.service.EmployeeService;
import blue.liuk.service.RoleService;
import blue.liuk.service.UserService;
import blue.liuk.util.Page;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RoleService roleService;

	@Override
	public void delete(Integer id) {
		if (null == id) {
			throw new HrException(ErrorMsg.ID_IS_NULL);
		}
		if (id == 1) {
			throw new HrException(ErrorMsg.ADMIN_SYSTEM_DELETE);
		}
		User user = this.getById(id);
		userDao.delete(user);

	}

	@Override
	public void saveOrUpdate(User user) {
		
		userDao.saveOrUpdate(user);
	}

	@Override
	public void save(User user, Integer id) {
		User usertmp = this.getById(user.getId());
		usertmp.setDescription(user.getDescription());
		usertmp.setEnable(user.getEnable());
		// 获取员工
		if (null != id) {
			Employee employee = employeeService.findById(id);
			if (null == employee) {
				throw new HrException(ErrorMsg.ID_FIND_NO);
			}
			usertmp.setEmployee(employee);
		}

		userDao.saveOrUpdate(usertmp);
	}

	@Override
	public void add(User user, Integer id) {
		List<User> users = this.getByName(user.getUsername());
		if (users.size() > 0) {
			throw new HrException(ErrorMsg.USER_NAME_DUPLICATE);
		}
		if (null != id) {
			Employee employee = employeeService.findById(id);
			if (null == employee) {
				throw new HrException(ErrorMsg.ID_USER_FIND_NO);
			}
			user.setEmployee(employee);
		}
		userDao.saveOrUpdate(user);
	}

	@Override
	public User getById(Integer id) {
		User user = userDao.findById(User.class, id);
		return user;
	}

	@Override
	public List<User> getAll(Page p) {
		int total = userDao.getTotalCount(User.class);
		p.setRowTotalCount(total);
		List<User> users = userDao.findAll(User.class, p.getRowStartCount(), Page.pagesize);
		return users;
	}

	@Override
	public List<User> getByName(String name) {
		List<User> users = userDao.findByProperty(User.class, "username", name, BaseDao.EQUAL_SQL);
		return users;
	}

	@Override
	public void saveRole(Integer id, Integer[] roleids) {
		User user = this.getById(id);
		if (null == user.getEnable() || user.getEnable().intValue() < 1) {
			throw new HrException(ErrorMsg.USER_IS_DISABLE);
		}
		if (user.getId()== 1) {
			throw new HrException(ErrorMsg.ADMIN_SYSTEM_EDIT);
		}
		user.setRoles(null);
		userDao.saveOrUpdate(user);
		if (null != roleids) {
			List<Role> tmpList = roleService.getAll(roleids);
			Set<Role> sets = new HashSet<Role>();
			sets.addAll(tmpList);
			user.setRoles(sets);
			userDao.saveOrUpdate(user);
		}

	}

}
