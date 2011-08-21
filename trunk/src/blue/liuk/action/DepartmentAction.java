package blue.liuk.action;

import java.util.List;

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
import blue.liuk.service.DepartmentService;
import blue.liuk.util.Page;

@Controller
@Scope("prototype")
@ResultPath("/WEB-INF/pages")
@Results(value = { @Result(name = "getall", location = "dept.jsp"), 
		@Result(name = "listall", type = "redirect", location = "/dept/getall"),
		@Result(name = "edit", location = "deptinput.jsp") })
public class DepartmentAction extends BaseAction {
	/**
	 * 部门 
	 * 
	 * 
	 * @author liuk
	 */
	private static final long serialVersionUID = -7009516180636288803L;
	Log logger = LogFactory.getLog(DepartmentAction.class);
	private Department dp;
	private String name;
	private Integer[] ids;
	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Autowired
	private DepartmentService departmentService;

	private List<Department> deps;

	public List<Department> getDeps() {
		return deps;
	}

	public void setDeps(List<Department> deps) {
		this.deps = deps;
	}

	private Integer id;
	private Page pagelist;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Department getDp() {
		return dp;
	}

	public void setDp(Department dp) {
		this.dp = dp;
	}

	@Action("/dept/get")
	public String get() {
		dp = departmentService.findById(id);
		return "edit";

	}

	@Action("/dept/add")
	public String add() {
		return "edit";
	}

	@Action("/dept/save")
	public String save() {
		if (null == id) {
			departmentService.add(dp);

		} else {
			departmentService.modify(dp);
		}
		return "listall";
	}

	@Action("/dept/delete")
	public String delete() {// 删除部门
		if (null != id) {
			departmentService.delete(id);
		}
		return "listall";
	}
	@Action("/dept/deletemore")
	public String deleteMore() {// 删除部门
		if (null != ids) {
			for (Integer id :ids) {
				departmentService.delete(id);
			}
		}
		return "listall";
	}

	@Action("/dept/getall")
	public String findAll() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		deps=departmentService.findAll(pagelist);
		return "getall";
	}

	@Action("/dept/getbyname")
	public String findByName() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		deps=departmentService.findByName(pagelist, name);
		return "getall";
	}
	
	public void setPagelist(Page pagelist) {
		this.pagelist = pagelist;
	}

	public Page getPagelist() {
		return pagelist;
	}

}
