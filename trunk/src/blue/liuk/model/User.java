package blue.liuk.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_user")
public class User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5675686663193160142L;
	private String username;
	private Integer id;
	private String password;
	private String description;
	private Integer enable;
	private Set<Role> roles=new HashSet<Role>();
	private Employee employee;
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the passwoed
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param passwoed the passwoed to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the enable
	 */
	public Integer getEnable() {
		return enable;
	}
	/**
	 * @param enable the enable to set
	 */
	public void setEnable( Integer enable) {
		this.enable = enable;
	}
	

	@ManyToOne
	@JoinColumn
	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	/**
	 * @return the roles
	 */
	@ManyToMany
	@JoinTable(name = "tb_user_role", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = { @JoinColumn(name = "roleid") })
	public Set<Role> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}



	

}
