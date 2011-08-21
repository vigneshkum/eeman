package blue.liuk.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import blue.liuk.base.BaseAction;
import blue.liuk.model.Department;
import blue.liuk.model.Employee;
import blue.liuk.service.DepartmentService;
import blue.liuk.service.EmployeeService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * EmAction
 * 
 * @author liuk
 * @version 0.1.1
 */
@Controller
@Scope("prototype")
public class EmployeeAjaxAction extends BaseAction {
	private static final long serialVersionUID = -4237165724278460859L;
	static Logger logger = Logger.getLogger(EmployeeAjaxAction.class);
	private Integer divid;
	private String emsxml;
	private List<Employee> ems;
	@Autowired
	private  EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	private List<Department> des;

	public List<Department> getDes() {
		return des;
	}

	public void setDes(List<Department> des) {
		this.des = des;
	}
	@Action("getem")
	public void getEm(){
		ems=employeeService.findByDept(null, divid);
	//	Document document = DocumentHelper.createDocument();
	//	Element emsElement = document.addElement("ems");
//		for (int i = 0; i < ems.size(); i++) {
//			logger.info(ems.get(i));
//			Element emElement = emsElement.addElement("em");
//			emElement.addAttribute("id",String.valueOf(ems.get(i).getId()));
//			Element nameElement = emElement.addElement("name");
//			nameElement.setText(ems.get(i).getName());
//			
//		
//			
//			
//			if (i==ems.size()-1) {
//				this.emsxml=document.asXML();
//			}
		StringBuffer emjson=new StringBuffer("{\"data\" : [ ");
			for (int i = 0; i < ems.size(); i++) {
				emjson.append("{\"id\" :");
				emjson.append(ems.get(i).getId());
				emjson.append(",");
				emjson.append("\"name\" :\"");
				emjson.append(ems.get(i).getName());
				if (i==ems.size()-1) {
					emjson.append("\"}]}");
				}else {
					emjson.append("\"},");
				}
				
			}
			try {
				sendMsg(emjson.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
	}
	@Action("/getdiv")
	public void getDiv(){
		des=departmentService.findAll(null);
		StringBuffer divjson=new StringBuffer("{\"divs\" : [ ");
		for (int i = 0; i < des.size(); i++) {
			divjson.append("{\"id\" :");
			divjson.append(des.get(i).getId());
			divjson.append(",");
			divjson.append("\"name\" :\"");
			divjson.append(des.get(i).getName());
			if (i==des.size()-1) {
				divjson.append("\"}]}");
			}else {
				divjson.append("\"},");
			}
			
		}
		try {
			sendMsg(divjson.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	public Integer getDivid() {
		return divid;
	}

	public void setDivid(Integer divid) {
		this.divid = divid;
	}

	public String getEmsxml() {
		return emsxml;
	}

	public void setEmsxml(String emsxml) {
		this.emsxml = emsxml;
	}

	public List<Employee> getEms() {
		return ems;
	}

	public void setEms(List<Employee> ems) {
		this.ems = ems;
	}



}
