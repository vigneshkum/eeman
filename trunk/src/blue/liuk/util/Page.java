package blue.liuk.util;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.ActionContext;

/**
 * 分页类
 * @author liuk
 */
public class Page {
	static Log logger = LogFactory.getLog(GetSth.class);
	public static  int pagesize = 15;
	private int pageNum;
	private int pagePreNum;
	private int pageNextNum;
	private int pageTotalCount;
	private int rowStartCount;
	private String actionname;
	private int[] pageNums;
	private int rowTotalCount;
	private List list;
	private String url;
	private String para;

	public String getUrl() {
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		String ur = (String) (request.get("javax.servlet.forward.servlet_path"));
		ur = ur.substring(ur.indexOf("/") + 1);
	//	logger.info(ur);
		return ur;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPara() {
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		String pa = (String) request.get("javax.servlet.forward.query_string");
	//	logger.info(pa);
		if (null == pa) {
			pa = "?";
		} else {
			int k = pa.indexOf("pagelist");
			if (k != -1) {
				if (k == 0) {
					pa = "?";
				} else {
					pa = pa.substring(0, k - 1);
					pa = "?" + pa + "&";
				}

			} else {
				pa = "?" + pa + "&";
			}
		}
	//	logger.info(pa);
		return pa;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public int getPageNum() {
		return pageNum > 1 ? (pageNum < this.getPageTotalCount() ? pageNum
				: this.getPageTotalCount()) : 1;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageTotalCount() {
		return (rowTotalCount % pagesize == 0) ? rowTotalCount / pagesize
				: rowTotalCount / pagesize + 1;
	}

	public int getPagePreNum() {
		return this.getPageNum() > 1 ? this.getPageNum() - 1 : 1;
	}

	public void setPagePreNum(int pagePreNum) {
		this.pagePreNum = pagePreNum;
	}

	public int getPageNextNum() {
		return this.getPageNum() < this.getPageTotalCount() ? this.getPageNum() + 1
				: this.getPageTotalCount();
	}

	public void setPageNextNum(int pageNextNum) {
		this.pageNextNum = pageNextNum;
	}

	public Page() {
	}

	public Page(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getRowStartCount() {
		return (this.getPageNum() - 1 > 0) ? (this.getPageNum() - 1) * pagesize
				: 0;
	}

	public void setRowStartCount(int rowStartCount) {
		this.rowStartCount = rowStartCount;
	}

	public int getRowTotalCount() {
		return rowTotalCount;
	}

	public void setRowTotalCount(int rowTotalCount) {
		this.rowTotalCount = rowTotalCount;
	}

	// public Page(int pNum, int rowTotalCount) {
	// int pc= (rowTotalCount % pagesize == 0) ? rowTotalCount
	// / pagesize : rowTotalCount / pagesize + 1;
	// this.pageTotalCount =pc;
	// this.pageNum = pNum>1?(pNum<pc?pNum:pc):1;
	// this.rowTotalCount = rowTotalCount;
	// this.rowStartCount = (this.pageNum - 1 >0) ? (this.pageNum - 1) *
	// pagesize : 0;
	//
	// }

	public void setPageNums(int[] pageNums) {
		this.pageNums = pageNums;
	}

	public int[] getPageNums() {
		int pnums[] = new int[this.getPageTotalCount()];
		for (int i = 1; i <= this.getPageTotalCount(); i++) {
			pnums[i - 1] = i;
		}
		return pnums;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

	public String getActionname() {
		return actionname;
	}

}