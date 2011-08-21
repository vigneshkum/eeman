package blue.liuk.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import blue.liuk.base.BaseAction;
import blue.liuk.model.Department;
import blue.liuk.model.Employee;
import blue.liuk.model.Train;
import blue.liuk.service.DepartmentService;
import blue.liuk.service.EmployeeService;
import blue.liuk.service.TrainService;
import blue.liuk.util.GetSth;
import blue.liuk.util.Page;

import com.opensymphony.xwork2.ActionSupport;

/**
 * EmployeeAction
 * 
 * @author liuk
 * @version 0.1.1
 */
@Controller
@Scope("prototype")
@ResultPath("/WEB-INF/pages")
@Results(value = { @Result(name = "getall", location = "employee.jsp"), @Result(name = "info", location = "eminfo.jsp"),
		@Result(name = "listall", type = "redirect", location = "/employee/getall"), @Result(name = "edit", location = "employeeinput.jsp"),
		@Result(name = "itrain", location = "employeetrain.jsp"), @Result(name = "input", location = "/error.jsp") })
public class EmployeeAction extends BaseAction {
	Logger logger = Logger.getLogger(EmployeeAction.class);
	private static final long serialVersionUID = 2495033449345977427L;
	private Employee employee;
	private List<Employee> employees;
	private Integer id;
	private List<Department> des;

	private List<Train> trains;

	public List<Train> getTrains() {
		return trains;
	}

	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}

	// 部门
	// peixun
	private Integer deid;
	// s* is for search
	private String sname;
	// 电话
	private String sphone;
	// 删除多个id
	private int[] ids;
	private Page pagelist;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private TrainService trainService;

	// 通过id查找
	@Action(value = "/employee/get")
	public String searchById() throws Exception {
		employee = employeeService.findById(id);
		return "info";
	}

	public String showem() {
		employee = employeeService.findById(id);
		return "info";
	}

	// 通过name查找 已分页
	@Action(value = "/employee/searchbyname")
	public String searchByName() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		employees = employeeService.findByName(pagelist, sname);
		return "getall";
	}

	// 通过电话号码查找
	@Action(value = "/employee/searchbyphone")
	public String searchByPhone() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		employees = employeeService.findByPhone(pagelist, sphone);
		return "getall";
	}

	// 部门
	@Action(value = "/employee/searchbydept")
	public String searchByDept() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		employees = employeeService.findByDept(pagelist, deid);
		return "getall";
	}

	// 增加或者修改
	@Action(value = "/employee/save")
	public String save() {
		Department department = departmentService.findById(deid);
		employee.setDepartment(department);
		if (null == id) {
			employeeService.add(employee);
		} else {
			employeeService.modify(employee);
		}
		return "listall";
	}

	// 删除
	@Action(value = "/employee/delete")
	public String delete() {
		employeeService.delete(id);
		return "listall";
	}

	@Action(value = "/employee/deletemore")
	public String deletese() {
		if (ids != null && ids.length != 0) {
			for (int id : ids) {
				employeeService.delete(id);
			}
		}
		return "listall";
	}

	// 编辑前查找，返回输入页面：
	@Action(value = "/employee/edit")
	public String edit() {
		employee = employeeService.findById(id);
		des = departmentService.findAll(null);
		return "edit";
	}

	public String add() {
		des = departmentService.findAll(null);
		return "eminput";
	}

	// 分页显示所有
	@Action(value = "/employee/getall")
	public String emPageList() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		employees = employeeService.findAll(pagelist);
		return "getall";
	}

	@Action(value = "/employee/add")
	public String goadd() {
		des = departmentService.findAll(null);
		return "edit";
	}

	@Action(value = "/employee/itrain")
	public String itrain() {
		employee = employeeService.findById(id);
		trains = trainService.findAll(null);
		if (employee.getTrains().iterator().hasNext()) {
			deid = employee.getTrains().iterator().next().getId();
			sname = employee.getTrains().iterator().next().getTitle();
		}
		return "itrain";
	}

	@Action(value = "/employee/savetrain")
	public String saveTrain() {
		Train train = trainService.findById(deid);
		if (null != train) {
			employee = employeeService.findById(id);
			if (employee.getTrains().iterator().hasNext()) {
				Train train2 = employee.getTrains().iterator().next();
				if (train.getId() != train2.getId()) {
					train2.getEmployees().remove(employee);
					trainService.modify(train2);
				}

			}
			train.getEmployees().add(employee);
			trainService.modify(train);
		}
		return "listall";
	}

	public Integer getDeid() {
		return deid;
	}

	public List<Department> getDes() {
		return des;
	}

	public Employee getEmployee() {
		return employee;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public Integer getId() {
		return id;
	}

	public int[] getIds() {
		return ids;
	}

	public Page getPagelist() {
		return pagelist;
	}

	public String getSname() {
		return sname;
	}

	public String getSphone() {
		return sphone;
	}

	public void setDeid(Integer deid) {
		this.deid = deid;
	}

	public void setDes(List<Department> des) {
		this.des = des;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public void setPagelist(Page pagelist) {
		this.pagelist = pagelist;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

}
