package blue.liuk.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import blue.liuk.base.BaseAction;
import blue.liuk.model.Employee;
import blue.liuk.model.Reward;
import blue.liuk.service.EmployeeService;
import blue.liuk.service.RewardService;
import blue.liuk.util.GetSth;
import blue.liuk.util.Page;

import com.opensymphony.xwork2.ActionSupport;

/**
 * RewardAction
 * 
 * @author liuk
 * @version 0.0.1
 * 
 */
@Controller
@Scope("prototype")
@ResultPath("/WEB-INF/pages")
public class RewardAction extends BaseAction {

	private static final long serialVersionUID = 3175010800705466506L;
	private Reward reward;
	private List<Reward> rewards;
	private Integer id;
	
	private Integer emid;
	private int[] ids;
	public Integer getEmid() {
		return emid;
	}

	public void setEmid(Integer emid) {
		this.emid = emid;
	}
	
	private String emname;
	

	public String getEmname() {
		return emname;
	}

	public void setEmname(String emname) {
		this.emname = emname;
	}

	private Page pagelist;
	// 标题搜索
	private String stitle;
	// 种类
	private String stype;
	// 内容
	private String scontent;
	// 金额
	private String smaxpenalty;
	// 金额
	private String sminpenalty;
	// 时间
	private String smaxtime;
	// 时间
	private String smintime;
	// id
	private Integer minid;
	// id
	private Integer maxid;

	@Autowired
	private RewardService rewardService;
	
	@Autowired
	private EmployeeService employeeService;

	@Action(value = "/reward/getall", results = { @Result(name = "success", location = "rewardmain.jsp") })
	public String findAll() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		rewards = rewardService.findAll(pagelist);
		return SUCCESS;
	}

	@Action(value = "/reward/getone", results = { @Result(name = "success", location = "rewardmain.jsp") })
	public String searchById() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		reward = rewardService.findById(id);
		rewards = new ArrayList<Reward>();
		rewards.add(reward);
		pagelist.setRowTotalCount(1);

		return SUCCESS;
	}

	@Action(value = "/reward/delete", results = { @Result(name = "success", type = "redirect", location = "/reward/getall") })
	public String delete() {
		rewardService.delete(id);
		return SUCCESS;
	}

	@Action(value = "/reward/searchbytitle", results = { @Result(name = "success", location = "rewardmain.jsp") })
	public String searchByTitle() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		rewards = rewardService.findByTitle(pagelist,GetSth.change(stitle));
		return SUCCESS;
	}

	@Action(value = "/reward/gosearch", results = { @Result(name = "success", location = "rewardsearch.jsp") })
	public String gosearch() {

		return SUCCESS;
	}

	@Action(value = "/reward/search", results = { @Result(name = "success", location = "rewardmain.jsp") })
	public String search() {
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
		if (null != stype && !stype.isEmpty()) {
			sw.put("stype", GetSth.change(stype));

		}
		if (null != scontent && !scontent.isEmpty()) {
			sw.put("scontent", GetSth.change(scontent));

		}
		if (null != sminpenalty && !sminpenalty.isEmpty()) {
			sw.put("sminpenalty", sminpenalty);

		}
		if (null != smaxpenalty && !smaxpenalty.isEmpty()) {
			sw.put("smaxpenalty", smaxpenalty);
		}

		if (null != smintime && !smintime.isEmpty()) {
			sw.put("smintime", smintime);
		}
		if (null != smaxtime && !smaxtime.isEmpty()) {
			sw.put("smaxtime", smaxtime);
		}
		rewards = rewardService.search(pagelist, sw);
		return SUCCESS;
	}

	@Action(value = "/reward/deletemore", results = { @Result(name = "success", type = "redirect", location = "/reward/getall") })
	public String deletese() {
		rewardService.delete(ids);
		return SUCCESS;
	}

	// 通过id获取记录，返回修改
	@Action(value = "/reward/get", results = { @Result(name = "success", location = "rewardadd.jsp") })
	public String find() {
		reward = rewardService.findById(id);
		if (reward.getEmployees().iterator().hasNext()) {
			emid=reward.getEmployees().iterator().next().getId();
			emname=reward.getEmployees().iterator().next().getName();
		}
		
		return SUCCESS;
	}

	// 跳转到增加
	@Action(value = "/reward/add", results = { @Result(name = "success", location = "rewardadd.jsp") })
	public String add() {
		
		return SUCCESS;
	}

	// 增加或者修改
	@Action(value = "/reward/save", results = { @Result(name = "success", type = "redirect", location = "/reward/getall") })
	public String save() {
		if (null!=emid) {
		Employee employee=employeeService.findById(emid);
		reward.getEmployees().add(employee);
		}
	
		if (null == id) {
			rewardService.save(reward);
		} else {
			rewardService.update(reward);
		}
		return SUCCESS;
	}

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public List<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPagelist(Page pagelist) {
		this.pagelist = pagelist;
	}

	public Page getPagelist() {
		return pagelist;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public String getStitle() {
		return stitle;
	}

	public void setStitle(String stitle) {
		this.stitle = stitle;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getScontent() {
		return scontent;
	}

	public void setScontent(String scontent) {
		this.scontent = scontent;
	}

	public String getSmaxpenalty() {
		return smaxpenalty;
	}

	public void setSmaxpenalty(String smaxpenalty) {
		this.smaxpenalty = smaxpenalty;
	}

	public String getSminpenalty() {
		return sminpenalty;
	}

	public void setSminpenalty(String sminpenalty) {
		this.sminpenalty = sminpenalty;
	}

	public String getSmaxtime() {
		return smaxtime;
	}

	public void setSmaxtime(String smaxtime) {
		this.smaxtime = smaxtime;
	}

	public String getSmintime() {
		return smintime;
	}

	public void setSmintime(String smintime) {
		this.smintime = smintime;
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

}