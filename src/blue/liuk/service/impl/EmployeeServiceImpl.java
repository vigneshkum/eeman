package blue.liuk.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blue.liuk.base.BaseDao;
import blue.liuk.dao.EmployeeDao;
import blue.liuk.exception.ErrorMsg;
import blue.liuk.exception.HrException;
import blue.liuk.model.Employee;
import blue.liuk.model.Train;
import blue.liuk.model.User;
import blue.liuk.service.EmployeeService;
import blue.liuk.service.TrainService;
import blue.liuk.service.UserService;
import blue.liuk.util.Page;

/**
 * @author liuk
 * @version 0.0.1
 * @see EmployeeService impl of EmployeeService
 * 
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private UserService userService;
	
	@Override
	public List<Employee> findAll(Page p) {
		return employeeDao.findAll(p);
	}
	@Autowired
private TrainService trainService;
	@Override
	public void delete(int id) {
		if(null==new Integer(id) ){
		throw new HrException(ErrorMsg.ID_IS_NULL);
		}
		Employee em = employeeDao.findById(id);
		if (null == em) {
			throw new HrException(ErrorMsg.ID_FIND_NO);
		}
		try {
			if (em.getTrains().iterator().hasNext()) {
				Train train=em.getTrains().iterator().next();
				train.getEmployees().remove(em);
				
				trainService.modify(train);
				
			}
			while (em.getUsers().iterator().hasNext()) {
				User user=em.getUsers().iterator().next();
				user.setEmployee(em);
				userService.saveOrUpdate(user);
				
			}
			employeeDao.delete(em);
		} catch (Exception e) {
			throw new HrException(ErrorMsg.ID_FIND_NO);
		}
	}

	@Override
	public void deleteMore(int[] ids) {
		for (int id : ids) {
			this.delete(id);
		}

	}

	@Override
	public void add(Employee em) {
		try {
			employeeDao.save(em);
		} catch (Exception e) {
			throw new HrException((ErrorMsg.SAVE_ERROR) );
		}

	}

	@Override
	public void modify(Employee em) {
		try {
			employeeDao.update(em);
		} catch (Exception e) {
			e.printStackTrace();
			throw new HrException(ErrorMsg.SAVE_ERROR);
		}
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		Employee em = employeeDao.findById(id);
		if (null == em) {
			throw new HrException(ErrorMsg.ID_FIND_NO);
		}
		return em;
	}

	@Override
	public List<Employee> findByName(Page p, String name) {
		List<Employee> list=employeeDao.findByName(p, name);
		if (list.size() == 0) {
			throw new HrException(ErrorMsg.NO_RESULT);
		}
		return list;
	}

	@Override
	public List<Employee> findByPhone(Page p, String phone) {
		List<Employee> list= employeeDao.findByPhone(p, phone);
		if (list.size() == 0) {
			throw new HrException(ErrorMsg.NO_RESULT);
		}
		return list;
	}

	@Override
	public List<Employee> search(Page p, Map<String, String> sw) {
		List<Employee> list=employeeDao.search(p, sw);
		if (list.size() == 0) {
			throw new HrException(ErrorMsg.NO_RESULT);
		}
		return list;
	}


	@Override
	public List<Employee> findAll(int divid) {
		List<Employee> list = (List<Employee>) employeeDao.findAll(divid);
		if (list.size() == 0) {
		//	throw new HrException(ErrorMsg.NO_RESULT);
			return list;
		}
		return list;
	}
	@Override
	public List<Employee> findByDept(Page p,int deptid) {
		if (null==p) {
			return employeeDao.findByProperty(Employee.class, "department.id", deptid, BaseDao.EQUAL_SQL);
		}
		int count =employeeDao.getTotalCount(Employee.class, "department.id", deptid,BaseDao.EQUAL_SQL);
		p.setRowTotalCount(count);
		return employeeDao.findByProperty(Employee.class, "department.id", deptid, BaseDao.EQUAL_SQL, p.getRowStartCount(), Page.pagesize);
	}

}
