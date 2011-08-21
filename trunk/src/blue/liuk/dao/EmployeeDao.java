package blue.liuk.dao;

import java.util.List;
import java.util.Map;

import blue.liuk.base.CommDao;
import blue.liuk.model.Employee;
import blue.liuk.util.Page;


/**
 * @author liuk
 * @version 0.0.1
 * EmployeeDao interface 
 *
 */
public interface EmployeeDao extends CommDao<Employee, Integer> {
	public List<Employee> findAll();
	public List<Employee> findAll(int divid);
	public List<Employee> findAll(Page aPage);
	public void delete(Employee em);
	public void save(Employee em);
	public void update(Employee em);
	public Employee findById(int id);
	public List<Employee> findByName(Page p, String name) ;
	public List<Employee> findByPhone(Page p,String phone);
	public List<Employee> search(Page p,Map<String, String> sw);
	
}
