package blue.liuk.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import blue.liuk.util.GetSth;

@Entity
@Table(name = "tb_employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 595818364751017410L;
	private int id;
	private String name;
	private String sex;
	@SuppressWarnings("unused")
	private int age;
	private String identifycation;
	private Date birthday;
	private String nationality;
	private int isMarried;
	private String politics;
	private String birthplace;
	private String telphone;
	private String address;
	private String graduatedSchool;
	private String specialize;
	private String education;
	private Date firstWorkTime;
	private String workType;
	private Date regedisTtime;
	private String regedistName;
	private String remark;
	private Set<Pay> pay;
	private Set<Document> documents;
	private Department department;
	private  Set<Score> scores;
	private Set<Reward> rewards = new HashSet<Reward>();
	private Set<Train> trains = new HashSet<Train>();
	private Set<User> users = new HashSet<User>();
	private String bankacc;
	public String getBankacc() {
		return bankacc;
	}

	public void setBankacc(String bankacc) {
		this.bankacc = bankacc;
	}

	public Employee() {
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	


	
	@OneToMany(mappedBy="employee")
	public Set<Score> getScores() {
		return scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

	@OneToMany(mappedBy="employee")
	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Transient
	public int getAge() {
		return GetSth.getAge(this.getBirthday());
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIdentifycation() {
		return identifycation;
	}

	public void setIdentifycation(String identifycation) {
		this.identifycation = identifycation;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getIsMarried() {
		return isMarried;
	}

	public void setIsMarried(int isMarried) {
		this.isMarried = isMarried;
	}

	public String getPolitics() {
		return politics;
	}

	public void setPolitics(String politics) {
		this.politics = politics;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGraduatedSchool() {
		return graduatedSchool;
	}

	public void setGraduatedSchool(String graduatedSchool) {
		this.graduatedSchool = graduatedSchool;
	}

	public String getSpecialize() {
		return specialize;
	}

	public void setSpecialize(String specialize) {
		this.specialize = specialize;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Date getFirstWorkTime() {
		return firstWorkTime;
	}

	public void setFirstWorkTime(Date firstWorkTime) {
		this.firstWorkTime = firstWorkTime;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public Date getRegedisTtime() {
		return regedisTtime;
	}

	public void setRegedisTtime(Date regedisTtime) {
		this.regedisTtime = regedisTtime;
	}

	public String getRegedistName() {
		return regedistName;
	}

	public void setRegedistName(String regedistName) {
		this.regedistName = regedistName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(mappedBy = "employee",cascade=CascadeType.ALL)
	public Set<Pay> getPay() {
		return pay;
	}

	public void setPay(Set<Pay> pay) {
		this.pay = pay;
	}

	@ManyToOne
	@JoinColumn
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToMany(mappedBy = "employees",cascade=CascadeType.ALL)
	public Set<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(Set<Reward> rewards) {
		this.rewards = rewards;
	}

	@ManyToMany(mappedBy = "employees")
	public Set<Train> getTrains() {
		return trains;
	}

	public void setTrains(Set<Train> trains) {
		this.trains = trains;
	}

	@OneToMany(mappedBy = "employee")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
