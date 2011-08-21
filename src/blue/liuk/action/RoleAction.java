/**
 * 
 */
package blue.liuk.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import blue.liuk.base.BaseAction;
import blue.liuk.model.Pay;
import blue.liuk.model.Resourse;
import blue.liuk.model.Role;
import blue.liuk.service.ResourseService;
import blue.liuk.service.RoleService;
import blue.liuk.service.SalaryService;
import blue.liuk.util.Page;

/**
 * @author liuk
 * 
 */
@Controller
@Scope("prototype")
@ResultPath("/WEB-INF/pages")
@Results(value = { @Result(name = "getall", location = "role.jsp"), @Result(name = "listall", type = "redirect", location = "/permission/getall"),
		@Result(name = "input", location = "roleinput.jsp"), @Result(name = "roleres", location = "roleres.jsp"),
		@Result(name = "add", location = "roleadd.jsp") })
public class RoleAction extends BaseAction {

	private static final long serialVersionUID = 1951922951645824132L;

	private Integer id;
	private Role role;
	private List<Role> roles;
	private List<Resourse> resourses;
	private Integer[] ids;

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	private Integer[] resids;
	private Integer[] residspre;

	public Integer[] getResids() {
		return resids;
	}

	public void setResids(Integer[] resids) {
		this.resids = resids;
	}

	public Integer[] getResidspre() {
		return residspre;
	}

	public void setResidspre(Integer[] residspre) {
		this.residspre = residspre;
	}

	public List<Resourse> getResourses() {
		return resourses;
	}

	public void setResourses(List<Resourse> resourses) {
		this.resourses = resourses;
	}

	private List<Resourse> resoursesinrole;

	public List<Resourse> getResoursesinrole() {
		return resoursesinrole;
	}

	public void setResoursesinrole(List<Resourse> resoursesinrole) {
		this.resoursesinrole = resoursesinrole;
	}

	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourseService resourseService;
	private Page pagelist;

	@Action(value = "/permission/get")
	public String get() {
		role = roleService.getById(id);
		return "input";
	}

	@Action(value = "/permission/delete")
	public String delete() {
		roleService.delete(id);
		return "listall";
	}

	@Action(value = "/permission/deletemore")
	public String deleteMore() {
		if (null != ids && ids.length > 0) {
			for (Integer id : ids) {
				roleService.delete(id);
			}
		}

		return "listall";
	}

	@Action(value = "/permission/save")
	public String save() {
		roleService.saveOrUpdate(role);
		return "listall";
	}

	@Action(value = "/permission/getall")
	public String getAll() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		roles = roleService.getAll(pagelist);
		return "getall";
	}

	@Action(value = "/permission/add")
	public String add() {
		return "input";
	}

	@Action(value = "/permission/getresrole")
	public String getResByRole() {

		resourses = resourseService.getAll();

		return null;
	}

	@Action(value = "/permission/getallres")
	public String getAllRes() {
		role = roleService.getById(id);
		resoursesinrole = resourseService.getByRole(id);
		resourses = resourseService.getByRoleNot(id);
		return "roleres";
	}

	@Action(value = "/permission/saveper")
	public String savePermission() {
		roleService.saveper(id, resids);
		return "listall";
	}

	@Action(value = "/permission/getallresjson")
	public String getAllResJson() {

		resourses = resourseService.getAll();
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter() {
			@Override
			public boolean apply(Object arg0, String arg1, Object arg2) {
				if (arg1.equals("roles")) {
					return true;
				} else {
					return false;
				}
			}
		});
		String reString = JSONSerializer.toJSON(resourses, config).toString();
		try {
			sendMsg(reString);
		}
		catch (IOException e) {
		}
		return null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public Page getPagelist() {
		return pagelist;
	}

	public void setPagelist(Page pagelist) {
		this.pagelist = pagelist;
	}

}
