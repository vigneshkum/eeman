package blue.liuk.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blue.liuk.base.BaseDao;
import blue.liuk.dao.RoleDao;
import blue.liuk.exception.ErrorMsg;
import blue.liuk.exception.HrException;
import blue.liuk.model.Resourse;
import blue.liuk.model.Role;
import blue.liuk.service.ResourseService;
import blue.liuk.service.RoleService;
import blue.liuk.util.Page;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private ResourseService resourseService;

	@Override
	public void delete(Integer id) {
		Role role = this.getById(id);
		if (role.getUsers().size() > 0) {
			throw new HrException(ErrorMsg.ROLE_HAVE_USERS);

		}
		role.setResourses(null);
		roleDao.delete(role);

	}

	@Override
	public void saveOrUpdate(Role role) {
	
			if (null==role.getId()&&this.getByName(role.getName()).size()>0) {
				throw new HrException(ErrorMsg.ROLe_NAME_DUPLICATE);
				
			}
			try {
			roleDao.saveOrUpdate(role);
		}
		catch (Exception e) {
			throw new HrException(ErrorMsg.SAVE_ERROR);
		}
		
	}

	@Override
	public void saveper(Integer id, Integer[] res) {
		Role role = this.getById(id);
		role.setResourses(null);
		this.saveOrUpdate(role);
		List<Resourse> tmpList = resourseService.getAll(res);
		Set<Resourse> sets = new HashSet<Resourse>();
		sets.addAll(tmpList);
		role.setResourses(sets);
	//	this.saveOrUpdate(role);
		roleDao.saveOrUpdate(role);
	}

	@Override
	public Role getById(Integer id) {
		Role role = roleDao.findById(Role.class, id);
		return role;
	}

	@Override
	public List<Role> getAll(Page p) {
		int total = roleDao.getTotalCount(Role.class);
		p.setRowTotalCount(total);
		List<Role> roles = roleDao.findAll(Role.class, p.getRowStartCount(), Page.pagesize);
		return roles;
	}

	@Override
	public List<Role> getByName(String name) {
		List<Role> roles = roleDao.findByProperty(Role.class, "name", name, BaseDao.EQUAL_SQL);
		return roles;
	}

	@Override
	public List<Role> getByUser(Integer userid) {
		return roleDao.getByUser(userid);
	}

	@Override
	public List<Role> getByUserNot(Integer userid) {
		return roleDao.getByUserNot(userid);

	}
	
	@Override
	public List<Role> getAll(Integer[] roleids) {

		List<Role> list = new ArrayList<Role>();
		
		for (Integer id : roleids) {
			list.add(getById(id));
		}

		return list;
	}

}
