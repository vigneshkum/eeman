/**
 * 
 */
package blue.liuk.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import blue.liuk.base.BaseAction;
import blue.liuk.model.Employee;
import blue.liuk.model.Role;
import blue.liuk.model.User;
import blue.liuk.service.EmployeeService;
import blue.liuk.service.RoleService;
import blue.liuk.service.UserService;
import blue.liuk.util.Page;

/**
 * @author liuk
 * 
 */
@Controller
@Scope("prototype")
@ResultPath("/WEB-INF/pages")
@Namespace("/user")
@Results(value = { @Result(name = "getall", location = "user.jsp"), 
		@Result(name = "listall", type = "redirect", location = "/user/getall"),
		@Result(name = "input", location = "userinput.jsp"),
		@Result(name = "changepw", location = "userps.jsp"),
		@Result(name = "changepw2", location = "userps.jsp"),
		@Result(name = "rolelist", location = "userrole.jsp"),
		@Result(name = "add", location = "useradd.jsp")})
public class UserAction extends BaseAction {

	private static final long serialVersionUID = 1951922951645824132L;

	private Integer id;
	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	private Integer[] ids;
	private User user;
	private List<User> users;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	private Integer[] roleids;
	public Integer[] getRoleids() {
		return roleids;
	}

	public void setRoleids(Integer[] roleids) {
		this.roleids = roleids;
	}

	private List<Role>rolesin;
	public List<Role> getRolesin() {
		return rolesin;
	}

	public void setRolesin(List<Role> rolesin) {
		this.rolesin = rolesin;
	}

	public List<Role> getRolesout() {
		return rolesout;
	}

	public void setRolesout(List<Role> rolesout) {
		this.rolesout = rolesout;
	}

	private List<Role>rolesout;
	private Integer employeeid;
	
	private String password;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Page pagelist;

	@Action(value = "/user/get")
	public String get() {

		user = userService.getById(id);

		return "input";
	}

	@Action(value = "/user/save")
	//修改用户
	//将关联员工
	public String save() {
		
		userService.save(user, employeeid);
		return "listall";
	}
	
	@Action(value = "/user/insert")
	//增加用户
	//将关联员工
	public String addsave() {
		userService.add(user, employeeid);
		return "listall";
	}

	@Action(value = "delete")
	public String delete() {
		userService.delete(id);
		return "listall";
	}

	@Action(value = "deletemore")
	public String deleteMore() {
		for (Integer id:ids) {
			userService.delete(id);
		}
		return "listall";
	}
	@Action(value = "getall")
	public String getAll() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		users = userService.getAll(pagelist);
		return "getall";
	}

	@Action(value = "/user/add")
	public String add() {
		return "add";
	}
	//修改密码页面跳转
	@Action(value = "changepw")
	public String changepw() {
		user = userService.getById(id);
		return "changepw";
	}
	//修改密码保存
	@Action(value = "savepw")
	public String savepw() {
	User	usertmp=userService.getById(id);
	if (null!=password&&password.equals(usertmp.getPassword())) {
		usertmp.setPassword(user.getPassword());
		userService.saveOrUpdate(usertmp);
	}else {
		return "changepw2";
	}

		return "listall";
	}
	
	@Action(value = "view")
	public String view() {
		user = userService.getById(id);
		return "view";
	}

	//修改禁用状态
	@Action(value = "/user/changesu")
	public String changesu() {
		user = userService.getById(id);
		if (null!=id&&id==1) {
			return "listall";
		}
		if (null==user.getEnable()) {
			user.setEnable(new Integer(2));
		}else {
			Integer integer=user.getEnable();
			if (integer.intValue()>0) {
				user.setEnable(new Integer(0));
			}else {
				user.setEnable(new Integer(1));
			}
		}
		
		userService.saveOrUpdate(user);
		return "listall";
	}
	//获取角色信息
	@Action("getrole")
	public String  getRole() {
		user=userService.getById(id);
		rolesin=roleService.getByUser(id);
		rolesout=roleService.getByUserNot(id);
		return "rolelist";
	}
	//保存角色修改
	@Action("setrole")
	public String  setRole() {
		userService.saveRole(id, roleids);
		
		return "listall";
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Page getPagelist() {
		return pagelist;
	}

	public void setPagelist(Page pagelist) {
		this.pagelist = pagelist;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

}
