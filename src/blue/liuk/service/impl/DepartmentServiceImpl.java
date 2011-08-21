package blue.liuk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blue.liuk.base.BaseDao;
import blue.liuk.dao.DepartmentDao;
import blue.liuk.exception.ErrorMsg;
import blue.liuk.exception.ExceptionMsg;
import blue.liuk.exception.HrException;
import blue.liuk.model.Department;
import blue.liuk.service.DepartmentService;
import blue.liuk.util.Page;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public void delete(int id) {
		Department de = departmentDao.findById(Department.class, id);
		if (null == de) {
			throw new HrException(ErrorMsg.ID_IS_NULL);
		}
		if (de.getEmployees().size()>0) {
			throw new HrException(ErrorMsg.DELETE_ERROR_HAVE_EMS);
		}
		
		try {
			departmentDao.delete(de);
		}
		catch (Exception e) {
			throw new HrException(ErrorMsg.DELETE_ERROR);
		}

	}

	@Override
	public void add(Department de) {
		List<Department> des=this.findByName(de.getName());
		if (des.size()>0) {
			throw new HrException(ErrorMsg.DEPT_NAME_REPEAT_ERROE);
		}
		try {
			departmentDao.save(de);
		}
		catch (Exception e) {
			throw new HrException(ErrorMsg.SAVE_ERROR);
		}

	}

	@Override
	public void modify(Department de) {
		try {
			Department de2=this.findById(de.getId());
			de2.setBuildTime(de.getBuildTime());
			de2.setName(de.getName());
			de2.setRemark(de.getRemark());
			departmentDao.saveOrUpdate(de2);
		}
		catch (Exception e) {
			throw new HrException(ErrorMsg.SAVE_ERROR);
		}
	}

	@Override
	public Department findById(Integer id) {
		if (null == id) {
			throw new HrException(ErrorMsg.ID_IS_NULL);
		}
		Department department = departmentDao.findById(Department.class, id);
		if (null == department) {
			throw new HrException(ErrorMsg.ID_FIND_NO);
		}
		return department;
	}
	@Override
	public List<Department> findByName(String name) {
		
		return departmentDao.findByProperty(Department.class, "name", name,BaseDao.EQUAL_SQL);
	}

	@Override
	public List<Department> findByName(Page p,String name) {
		int count=departmentDao.getTotalCount(Department.class, "name", "%"+name+"%", BaseDao.LIKE_SQL);
		p.setRowTotalCount(count);
		return departmentDao.findByProperty(Department.class, "name", "%"+name+"%",BaseDao.LIKE_SQL,p.getRowStartCount(),Page.pagesize);
	}
	@Override
	public List<Department> findAll(Page p) {
		if (null==p) {
			return departmentDao.findAll(Department.class);
		}
		int count = departmentDao.getTotalCount(Department.class);
		p.setRowTotalCount(count);
		List<Department> des = departmentDao.findAll(Department.class, p.getRowStartCount(), Page.pagesize);
		if (0 == des.size()) {
			throw new HrException(ErrorMsg.NO_RESULT);
		}
		return des;
	}

}
