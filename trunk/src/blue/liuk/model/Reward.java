package blue.liuk.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_reward")
public class Reward implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String type;
	private String content;
	private float penalty;
	private Date time;
	private Set<Employee> employees=new HashSet<Employee>();
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	@ManyToMany
	@JoinTable(name="tb_reward_em",
			joinColumns={@JoinColumn(name="reward_id")},
			inverseJoinColumns={@JoinColumn(name="employee_id")}
	)
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public String getType() {
		return type;
	}
	public String getContent() {
		return content;
	}
	public float getPenalty() {
		return penalty;
	}
	public Date getTime() {
		return time;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setPenalty(float penalty) {
		this.penalty = penalty;
	}
	public void setTime(Date time) {
		this.time = time;
	}

}
