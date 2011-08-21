package blue.liuk.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import blue.liuk.model.Train;
import blue.liuk.service.EmployeeService;
import blue.liuk.service.TrainService;
import blue.liuk.util.GetSth;
import blue.liuk.util.Page;

@Controller
@Scope("prototype")
@ResultPath("/WEB-INF/pages")
@Results(value = { @Result(name = "getall", location = "trainselect.jsp"), @Result(name = "search", location = "fusszy.jsp"),
		@Result(name = "trainem", location = "trainem.jsp"), @Result(name = "listall", type = "redirect", location = "/train/getall"),
		@Result(name = "add", location = "trainadd.jsp") })
public class TrainAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1195148507449072773L;
	static Log logger = LogFactory.getLog(GetSth.class);
	private Train train;
	private Integer id;
	private String title;
	private int[] ids;
	private String content;
	private Date time;
	private String name;
	private String address;
	private List<Employee> employees;
	private List<Train> trains;

	private Integer id1;
	private Integer id2;
	private int pagenum;
	private Page pagelist;

	private Integer[] emids;

	public Integer[] getEmids() {
		return emids;
	}

	public void setEmids(Integer[] emids) {
		this.emids = emids;
	}

	@Autowired
	private TrainService trainService;
	@Autowired
	private EmployeeService employeeService;

	@Action(value = "/train/gosearch")
	public String goseatch() {
		return "search";
	}

	@Action(value = "/train/search")
	public String search() {
		if (pagelist == null) {
			pagelist = new Page(1);
		}

		Map<String, String> sw = new HashMap<String, String>();

		if (null != id1) {
			sw.put("id1", GetSth.change(String.valueOf(id1)));
		}
		if (null != id2) {
			sw.put("id2", GetSth.change(String.valueOf(id2)));
		}
		if (null != content) {
			sw.put("content", GetSth.change(content));
		}
		if (null != title) {
			sw.put("title", GetSth.change(title));
		}
		if (null != address) {
			sw.put("address", GetSth.change(address));
		}
		trains = trainService.search(sw, pagelist);
		return "getall";
	}

	@Action(value = "/train/delete")
	public String delete() {
		trainService.delete(id);
		return "listall";

	}

	@Action(value = "/train/getbytitle")
	public String getByTitle() {
		if (pagelist == null) {
			pagelist = new Page(1);
		}
		trains = trainService.findByTitle(GetSth.change(title), pagelist);
		return "getall";

	}
	@Action(value = "/train/deletemore")
	public String deleteMore() {
		if (ids != null && ids.length != 0) {
			for (int id : ids) {
				trainService.delete(id);
			}
		}
		return "listall";
	}

	//
	@Action(value = "/train/get")
	public String get() {
		train = trainService.findById(id);
		return "add";
	}

	@Action(value = "/train/getall")
	public String findAll() {
		if (pagelist == null) {
			pagelist = new Page(1);
		}
		trains = trainService.findAll(pagelist);
		return "getall";

	}

	// 增加和更新
	@Action(value = "/train/save")
	public String save() {
		if (null != id) {
			trainService.modify(train);
		} else {
			trainService.add(train);
		}
		return "listall";
	}

	// 打开增加页面
	@Action(value = "/train/add")
	public String add() {

		return "add";
	}

	@Action(value = "/train/getems")
	public String getEms() {
		train = trainService.findById(id);
		return "trainem";
	}

	// 打开增加页面
	@Action(value = "/train/saveem")
	public String saveEm() {
		train = trainService.findById(id);
		train.getEmployees().clear();
		if (null != emids) {
			for (Integer i : emids) {
				Employee employee = employeeService.findById(i);
				train.getEmployees().add(employee);
			}
		}

		trainService.modify(train);

		return "listall";
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Train> getTrains() {
		return trains;
	}

	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}

	public Integer getId1() {
		return id1;
	}

	public void setId1(Integer id1) {
		this.id1 = id1;
	}

	public Integer getId2() {
		return id2;
	}

	public void setId2(Integer id2) {
		this.id2 = id2;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public Page getPagelist() {
		return pagelist;
	}

	public void setPagelist(Page pagelist) {
		this.pagelist = pagelist;
	}

	public TrainService getTrainService() {
		return trainService;
	}

	public void setTrainService(TrainService trainService) {
		this.trainService = trainService;
	}

}
