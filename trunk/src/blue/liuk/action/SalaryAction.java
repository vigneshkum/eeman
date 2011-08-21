package blue.liuk.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import blue.liuk.base.BaseAction;
import blue.liuk.model.Employee;
import blue.liuk.model.Pay;
import blue.liuk.model.Reward;
import blue.liuk.service.SalaryService;
import blue.liuk.util.GetSth;
import blue.liuk.util.Page;

/**
 *  SalaryAction
 * 
 * @author liuk
 * @version 0.1.1
 */
@Controller
@Scope("prototype")
@ResultPath("/WEB-INF/pages")
@Results(value = { @Result(name = "getall", location = "paymain.jsp"),
		@Result(name = "gosearch", location = "paysearch.jsp"),
		@Result(name = "getsalary", location = "salary.jsp"),
		@Result(name = "listall", type = "redirect", location = "/salary/getall"),
		@Result(name = "add", location = "payadd.jsp") })
public class SalaryAction extends BaseAction {

	private static final long serialVersionUID = 2495033449345977427L;
	static Logger logger = Logger.getLogger(SalaryAction.class);
	private Pay pay;
	private List<Pay> pays;
	private Integer id;
	private Integer employeeid;
	
	private float salarynum;

	public float getSalarynum() {
		return salarynum;
	}
	public void setSalarynum(float salarynum) {
		this.salarynum = salarynum;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	// 删除多个id
	private int[] ids;

	// s* is for search

	private Integer minid;

	private Integer maxid;

	// 姓名
	private String sname;
	// 工龄
	private String sminage;
	// 工龄
	private String smaxage;
	// 发工资时间
	private String sminpt;
	// 发工资时间
	private String smaxpt;

	// 基本工资
	private String sminbase;
	private String smaxbase;

	private Page pagelist;
	@Autowired
	private SalaryService salaryService;

	// 删除
	@Action("/salary/delete")
	public String delete() {
		salaryService.delete(id);
		return "listall";
	}
	@Action("/salary/deletemore")
	public String deletese() {
		if (ids != null && ids.length != 0) {
			for (int id : ids) {
				salaryService.delete(id);
			}
		}
		return "listall";
	}

	// 分页显示所有
	@Action("/salary/getall")
	public String findAll() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		pays=salaryService.findAll(pagelist);
		return "getall";
	}

	// 修改前通过id获取记录
	@Action("/salary/get")
	public String findById() {
		pay = salaryService.findById(id);
		return "add";
	}

	public Integer getId() {
		return id;
	}

	public int[] getIds() {
		return ids;
	}

	public Integer getMaxid() {
		return maxid;
	}

	public Integer getMinid() {
		return minid;
	}

	public Page getPagelist() {
		return pagelist;
	}

	public Pay getPay() {
		return pay;
	}

	public List<Pay> getPays() {
		return pays;
	}

	public String getSmaxage() {
		return smaxage;
	}

	public String getSmaxbase() {
		return smaxbase;
	}

	public String getSmaxpt() {
		return smaxpt;
	}

	public String getSminage() {
		return sminage;
	}

	public String getSminbase() {
		return sminbase;
	}

	public String getSminpt() {
		return sminpt;
	}

	public String getSname() {
		return sname;
	}

	// 增加或者修改
	@Action("/salary/save")
	public String save() {
		if (null == id) {
			salaryService.add(pay,employeeid);
		} else {
			salaryService.modify(pay,employeeid);
		}
		return "listall";
	}
	
	@Action("/salary/add")
	public String add() {
		
		return "add";
	}
	@Action("/salary/gosearch")
	public String goSearch() {
		
		return "gosearch";
	}
	@Action("/salary/search")
	public String search() throws Exception {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		Map<String, String> sw = new HashMap<String, String>();
		if (null != minid) {
			sw.put("minid", String.valueOf(minid));
		}
		if (null != maxid) {
			sw.put("maxid", String.valueOf(maxid));
		}
		if (null != sname && !sname.isEmpty()) {
			sw.put("sname", GetSth.change(sname));
			// sw.put("sname", sname);
		}
		if (null != sminbase && !sminbase.isEmpty()) {
			sw.put("sminbase", sminbase);
			// throw new Exception("asdfasdf");
		}
		if (null != smaxbase && !smaxbase.isEmpty()) {
			sw.put("smaxbase", smaxbase);
		}
		if (null != sminage && !sminage.isEmpty()) {
			sw.put("sminage", sminage);
		}
		if (null != smaxage && !smaxage.isEmpty()) {
			sw.put("smaxage", smaxage);
		}
		if (null != sminpt && !sminpt.isEmpty()) {
			sw.put("sminpt", sminpt);
		}
		if (null != smaxpt && !smaxpt.isEmpty()) {
			sw.put("smaxpt", smaxpt);
		}
		pays=	salaryService.search(pagelist, sw);
		return "getall";
	}

	// 通过员工id查找
	@Action("/salary/getbyemid")
	public String searchByEmId() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		pays=salaryService.searchByEmId(pagelist, id);
		return "getall";
	}

	// 通过员工姓名查找
	@Action("/salary/getbyemname")
	public String searchByEmName() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
	pays=	salaryService.searchByEmname(pagelist, GetSth.change(sname));
		return "getall";
	}

	// 通过id查找
	public String searchById() {
		pay = salaryService.findById(id);
		pagelist = new Page(1);
		pagelist.setPageTotalCount(1);
		List<Pay> list = new ArrayList<Pay>();
		list.add(pay);
		pays=list;

		return "getall";
	}

	//计算工资
	@Action("/salary/getsalary")
	public String getSalary(){
		pay=salaryService.findById(id);
		Employee employee=pay.getEmployee();
		Set<Reward> rewards=employee.getRewards();
		//基本工资	加班费	工龄	考勤费	旷工费	保险费
		salarynum=pay.getBasePay()+pay.getExtraPay()-pay.getAttendPay()-pay.getAbsentPay()-pay.getInsurancePay();
		
		for (Reward reward : rewards) {
			//奖惩
		
			if ("奖励".equals(reward.getType())) {
				salarynum=salarynum+reward.getPenalty();
			}else {
				salarynum=salarynum-reward.getPenalty();
			}
		}
		
		
		return "getsalary";
		
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public void setMaxid(Integer maxid) {
		this.maxid = maxid;
	}

	public void setMinid(Integer minid) {
		this.minid = minid;
	}

	public void setPagelist(Page pagelist) {
		this.pagelist = pagelist;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public void setPays(List<Pay> pays) {
		this.pays = pays;
	}

	public void setSmaxage(String smaxage) {
		this.smaxage = smaxage;
	}

	public void setSmaxbase(String smaxbase) {
		this.smaxbase = smaxbase;
	}

	public void setSmaxpt(String smaxpt) {
		this.smaxpt = smaxpt;
	}

	public void setSminage(String sminage) {
		this.sminage = sminage;
	}

	public void setSminbase(String sminbase) {
		this.sminbase = sminbase;
	}

	public void setSminpt(String sminpt) {
		this.sminpt = sminpt;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}
