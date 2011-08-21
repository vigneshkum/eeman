package blue.liuk.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_department")
public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Date buildTime;
	private String remark;
	
	private Set<Employee> employees;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}

	
	


	public String getName() {
		return name;
	}

	
	@OneToMany(mappedBy="department")
	public Set<Employee> getEmployees() {
		return employees;
	}




	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}




	public String getRemark() {
		return remark;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}

	
}
