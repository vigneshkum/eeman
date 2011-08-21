package blue.liuk.service;

import java.util.List;
import java.util.Map;

import blue.liuk.model.Employee;
import blue.liuk.util.Page;

/**
 * @author liuk
 * @version 0.0.1
 *  EmployeeService interface
 *
 */
public interface EmployeeService {

	public  List<Employee>  findAll(Page p);
	public List<Employee> findAll(int divid);
	public void delete(int id);
	public void deleteMore(int[] ids);
	public void add(Employee em);

	public void modify(Employee em);

	public Employee findById(int id) ;
	public List<Employee> findByName(Page p,String s);
	public List<Employee> findByPhone(Page p,String phone);
	public List<Employee> search(Page p,Map<String, String> sw);
	List<Employee> findByDept(Page p,int deptid);
}
