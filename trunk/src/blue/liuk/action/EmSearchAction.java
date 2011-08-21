package blue.liuk.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import blue.liuk.service.DepartmentService;
import blue.liuk.service.EmployeeService;
import blue.liuk.util.GetSth;
import blue.liuk.util.Page;

/**
 * employee search
 * 
 * @author liuk
 * @version 0.0.1
 * 
 * 
 */
@Controller
@Scope("prototype")
@ResultPath("/WEB-INF/pages")
@Results(value = { @Result(name = "go", location = "employeesearch.jsp"),
		@Result(name = "search", location = "employee.jsp") })
public class EmSearchAction extends BaseAction {
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6388346650529612052L;
	static Log logger = LogFactory.getLog(EmSearchAction.class);
	private Page pagelist;
	private Integer minid;
	private Integer maxid;
	// s* is for search
	// 姓名
	private String sname;
	// 年龄
	private String sminage;
	// 年龄
	private String smaxage;
	// 工种
	private String sworkty;
	// 部门
	private String sdiv;
	// 学历
	private String sedu;
	// 工龄
	private String sworkys;
	
	private List<Department> des;
	
	@Autowired
	private DepartmentService departmentService;
	
	public List<Department> getDes() {
		return des;
	}
	public void setDes(List<Department> des) {
		this.des = des;
	}

	List<Employee> employees;
	@Autowired
	private EmployeeService employeeService;

	@Action(value = "/employee/search")
	public String search() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		pagelist.setActionname("search");

		Map<String, String> sw = new HashMap<String, String>();

		if (null != minid) {
			sw.put("minid", String.valueOf(minid));
		}
		if (null != maxid) {
			sw.put("maxid", String.valueOf(maxid));
		}

		sw.put("sname", GetSth.change(sname));

		sw.put("sminage", sminage);

		sw.put("smaxage", smaxage);

		sw.put("sdiv", sdiv);

		sw.put("sedu", GetSth.change(sedu));

		sw.put("sworkty", GetSth.change(sworkty));

		sw.put("sworkys", GetSth.change(sworkys));
		logger.info(sw);

		employees=employeeService.search(pagelist, sw);
		
		return "search";
	}
	@Action(value = "/employee/gosearch")
	public String goSearch() {
		des = departmentService.findAll(null);
		return "go";

	}

	public Page getPagelist() {
		return pagelist;
	}

	public void setPagelist(Page pagelist) {
		this.pagelist = pagelist;
	}

	public Integer getMinid() {
		return minid;
	}

	public void setMinid(Integer minid) {
		this.minid = minid;
	}

	public Integer getMaxid() {
		return maxid;
	}

	public void setMaxid(Integer maxid) {
		this.maxid = maxid;
	}

	public String getSminage() {
		return sminage;
	}

	public void setSminage(String sminage) {
		this.sminage = sminage;
	}

	public String getSmaxage() {
		return smaxage;
	}

	public void setSmaxage(String smaxage) {
		this.smaxage = smaxage;
	}

	public String getSworkty() {
		return sworkty;
	}

	public void setSworkty(String sworkty) {
		this.sworkty = sworkty;
	}

	public String getSdiv() {
		return sdiv;
	}

	public void setSdiv(String sdiv) {
		this.sdiv = sdiv;
	}

	public String getSedu() {
		return sedu;
	}

	public void setSedu(String sedu) {
		this.sedu = sedu;
	}

	public String getSworkys() {
		return sworkys;
	}

	public void setSworkys(String sworkys) {
		this.sworkys = sworkys;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}
