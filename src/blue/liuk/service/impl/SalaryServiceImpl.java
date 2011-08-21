package blue.liuk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blue.liuk.base.BaseDao;
import blue.liuk.dao.SalaryDao;
import blue.liuk.exception.ErrorMsg;
import blue.liuk.exception.ExceptionMsg;
import blue.liuk.exception.HrException;
import blue.liuk.model.Employee;
import blue.liuk.model.Pay;
import blue.liuk.service.EmployeeService;
import blue.liuk.service.SalaryService;
import blue.liuk.util.Page;

@Service
@Transactional
public class SalaryServiceImpl implements SalaryService {
	@Autowired
	private SalaryDao salaryDao;
	@Autowired
	private EmployeeService employeeService;
	

	@Override
	public List<Pay> findAll(Page p) {
		int count =salaryDao.getTotalCount(Pay.class);
		p.setRowTotalCount(count);
		return salaryDao.findAll(Pay.class, p.getRowStartCount(), Page.pagesize);

	}

	@Override
	public void delete(int id) {
		Pay pay=salaryDao.findById(id);
		if (null==pay) {
			throw new HrException(ErrorMsg.ID_FIND_NO);
		}
		try {
			salaryDao.delete(pay);
		} catch (Exception e) {
			throw new HrException(ErrorMsg.DELETE_ERROR);
		}
		
		

	}

	@Override
	public void add(Pay sa) {
		 salaryDao.save(sa);
	}

	@Override
	public void modify(Pay sa) {
		salaryDao.update(sa);

	}
	@Override
	public void add(Pay sa,Integer emid) {
		Employee employee=	employeeService.findById(emid);
		sa.setEmployee(employee);
		 salaryDao.save(sa);
	}

	@Override
	public void modify(Pay sa,Integer emid) {
		Employee employee=	employeeService.findById(emid);
		sa.setEmployee(employee);
		salaryDao.update(sa);

	}

	@Override
	public Pay findById(int id) {
		Pay pay= salaryDao.findById(id);
		
		if (null==pay) {
			throw new HrException(ErrorMsg.ID_FIND_NO);
		}
		return pay;
	}

	@Override
	public List<Pay> search(Page p, Map<String, String> sw) {
		return salaryDao.search(p, sw);

	}
	@Override
	public List<Pay> searchByEmId(Page p,int id){
		p.setRowTotalCount(1);
		List<Pay> pays=salaryDao.findByProperty(Pay.class, "employee.id", id, BaseDao.EQUAL_SQL, p.getRowStartCount(), Page.pagesize);
		return pays;
		
	}
	@Override
	public List<Pay> searchByEmname(Page p,String name){
		int count =salaryDao.getTotalCount(Pay.class, "employee.name", "%"+name+"%", BaseDao.LIKE_SQL);
		p.setRowTotalCount(count);
		List<Pay> pays=salaryDao.findByProperty(Pay.class, "employee.name", "%"+name+"%", BaseDao.LIKE_SQL, p.getRowStartCount(), Page.pagesize);
		return pays;
	
		
	}

}
