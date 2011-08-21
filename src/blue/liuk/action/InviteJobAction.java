package blue.liuk.action;

import java.util.Date;
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
import blue.liuk.model.Employee;
import blue.liuk.model.InviteJob;
import blue.liuk.service.EmployeeService;
import blue.liuk.service.InviteJobService;
import blue.liuk.util.GetSth;
import blue.liuk.util.Page;

/**
 * @author liuk
 * 
 */
@Controller
@Scope("prototype")
@ResultPath("/WEB-INF/pages")
@Results(value = { @Result(name = "getall", location = "invite.jsp"), 
		@Result(name = "gosearch", location = "invitesearch.jsp"), 
		@Result(name = "verfify", location = "inviteverfify.jsp"),
		@Result(name = "change", location = "invitetoemy.jsp"), 
		@Result(name = "listall", type = "redirect", location = "/invite/getall"),
		@Result(name = "input", location = "inviteinput.jsp")})
public class InviteJobAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	static Log logger = LogFactory.getLog(InviteJobAction.class);

	private Page pagelist;
	private String name;
	private Integer age;
	private Integer id;
	private String education;
	private String experience;
	private InviteJob inviteJob;
	private List<InviteJob> inviteJobs;
	
	private  Integer[] ids;
	
	private Integer ver;
	
	public Integer getVer() {
		return ver;
	}
	public void setVer(Integer ver) {
		this.ver = ver;
	}
	@Autowired
	private InviteJobService inviteJobService;
	@Autowired
	private EmployeeService employeeService;
	
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Action("/invite/delete")
	public String delete() {
		inviteJobService.delete(id);
		return "listall";
	}
	@Action("/invite/get")
	public String findById()  {
		inviteJob = inviteJobService.findById(id);
		return "input";
	}
	
	@Action("/invite/getbyname")
	public String findByName()  {
		if (pagelist == null) {
			pagelist = new Page(1);
		}
		inviteJobs = inviteJobService.findByName(pagelist,GetSth.change(name));
		return "getall";
	}
	
	@Action("/invite/deletemore")
	public String deletese() {
		if (ids != null && ids.length != 0) {
			for (int id : ids) {
				inviteJobService.delete(id);
			}
		}
		return "listall";
	}

	
	@Action("/invite/getall")
	public String getAll() throws Exception {
		if (pagelist == null) {
			pagelist = new Page(1);
		}

		inviteJobs=	inviteJobService.getAll(pagelist);

		return "getall";

	}
	@Action("/invite/add")
	public String add()  {
		return "input";
		
	}
	@Action("/invite/save")
	public String save()  {
		if (null == id) {
			inviteJob.setRegistTime(new Date());
			inviteJobService.add(inviteJob);

		} else {
			inviteJobService.modify(inviteJob);
		}
		return "listall";
	}
	
	@Action("/invite/gosearch")
	public String gosearch()  {
		return "gosearch";
		
	}
	
	@Action("/invite/search")
	public String search() throws Exception {
		Map<String, String> sw = new HashMap<String, String>();
		if (pagelist == null) {
			pagelist = new Page(1);
		}
		

		sw.put("name", GetSth.change(name));
		sw.put("education", GetSth.change(education));

		inviteJobs=inviteJobService.search(pagelist, sw);
		return "getall";
	}
	
	/**
	 * 审核
	 * @return
	 */
	@Action("/invite/vefify")
	public String vefify()  {
		inviteJob = inviteJobService.findById(id);
		return "verfify";
		
	}

	/**
	 * do审核
	 * @return
	 */
	@Action("/invite/dovefify")
	public String doVefify()  {
		InviteJob inviteJobtmp = inviteJobService.findById(id);
		inviteJobtmp.setIsEmploied(inviteJob.getIsEmploied());
		inviteJobtmp.setVerfifyName(inviteJob.getVerfifyName());
		inviteJobtmp.setVerfifyNote(inviteJob.getVerfifyNote());
		inviteJobtmp.setVerfifyOperateName(getUser().getUsername());
		inviteJobtmp.setRemark(inviteJob.getRemark());
		inviteJobService.modify(inviteJobtmp);
		return "listall";
		
	}
	@Action("/invite/getbyver")
	public String getByVer() throws Exception {
		if (pagelist == null) {
			pagelist = new Page(1);
		}

		inviteJobs=	inviteJobService.getByVer(pagelist,ver);

		return "getall";

	}
	
	/**
	 * 录入
	 * @return
	 */
	@Action("/invite/change")
	public String change()  {
//		inviteJob = inviteJobService.findById(id);
//		Employee employee=new Employee();
//		employee.setName(inviteJob.getName());
//		employee.setBirthday(inviteJob.getBirthday());
//		employee.setSex(inviteJob.getSex());
//		employeeService.add(employee);
//		this.employee=employee;
//		inviteJobService.delete(id);
		this.employee=	inviteJobService.change(id);
		return "change";	
	}
	
	
	public Page getPagelist() {
		return pagelist;
	}
	public void setPagelist(Page pagelist) {
		this.pagelist = pagelist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public InviteJob getInviteJob() {
		return inviteJob;
	}
	public void setInviteJob(InviteJob inviteJob) {
		this.inviteJob = inviteJob;
	}
	public List<InviteJob> getInviteJobs() {
		return inviteJobs;
	}
	public void setInviteJobs(List<InviteJob> inviteJobs) {
		this.inviteJobs = inviteJobs;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

}
