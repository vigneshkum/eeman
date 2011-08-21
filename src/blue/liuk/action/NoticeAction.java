package blue.liuk.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import blue.liuk.base.BaseAction;
import blue.liuk.model.Notice;
import blue.liuk.service.NoticeService;
import blue.liuk.util.Page;

@Controller
@Scope("prototype")
@ResultPath("/WEB-INF/pages")
@Results(value = { @Result(name = "getall", location = "notice.jsp"),
		@Result(name = "gosearch", location = "noticesearch.jsp"),
		@Result(name = "view", location = "noticeview.jsp"),
		@Result(name = "listall", type = "redirect", location = "/notice/getall"),
		@Result(name = "input", location = "noticeinput.jsp") })
public class NoticeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1154250724748970944L;
	private Integer id;
	private Notice notice;
	private List<Notice> notices;
	private  Integer[] ids;
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	@Autowired
	private NoticeService noticeService;
	private Page pagelist;
	
	@Action(value = "/notice/get")
	public String get() {

		notice = noticeService.getById(id);

		return "input";
	}
	@Action(value = "/notice/save")
	public String save() {
		noticeService.saveOrUpdate(notice);
		return "listall";
	}
	@Action(value = "/notice/delete")
	public String delete() {
		noticeService.delete(id);
		return "listall";
	}
	@Action(value = "/notice/deletemore")
	public String deleteMore() {
		if (null!=ids&&ids.length>0) {
			for (Integer id : ids) {
				noticeService.delete(id);
			}
		}
		
		return "listall";
	}
	@Action(value = "/notice/getall")
	public String getAll() {
		if (null == pagelist) {
			pagelist = new Page(1);
		}
		notices=noticeService.getAll(pagelist);
		return "getall";
	}
	@Action(value = "/notice/add")
	public String add() {
		return "input";
	}

	@Action(value = "/notice/view")
	public String view() {
		notice = noticeService.getById(id);
		return "view";
	}
	public String search() {
		return "listall";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}
	public Page getPagelist() {
		return pagelist;
	}
	public void setPagelist(Page pagelist) {
		this.pagelist = pagelist;
	}
}
