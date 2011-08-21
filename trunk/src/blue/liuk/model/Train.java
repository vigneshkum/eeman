package blue.liuk.model;

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
@Table(name="tb_train")
public class Train {

private int id;
private Set<Employee> employees =new HashSet<Employee>();

private String name	;
private String 	title	;
private String	content	;
private Date time	;
private String	address;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Id
@GeneratedValue
public int getId() {
	return id;
}
@ManyToMany
@JoinTable(name="tb_train_employee",
		joinColumns={@JoinColumn(name="train_id")},
		inverseJoinColumns={@JoinColumn(name="employee_id")}
)
public Set<Employee> getEmployees() {
	return employees;
}
public void setId(int id) {
	this.id = id;
}
public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
}
}
