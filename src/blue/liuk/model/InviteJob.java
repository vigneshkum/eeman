package blue.liuk.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import blue.liuk.util.GetSth;

@Entity
@Table(name="tb_invitejob")
    public class InviteJob {
	private int id;
	private String name;
	private String sex;
	@SuppressWarnings("unused")
	private int age;
	private Date birthday;
	private String position;
	private String profession;
	private String experience;
	private String education;
	private String graduatedsSchool;
	private String telphone;
	private String address;
	private Date registTime;
	private String remark;
	private Integer isEmploied;
	private String verfifyName;
	public String getVerfifyOperateName() {
		return verfifyOperateName;
	}
	public void setVerfifyOperateName(String verfifyOperateName) {
		this.verfifyOperateName = verfifyOperateName;
	}
	private String verfifyOperateName;
	private String verfifyNote;
	public String getVerfifyName() {
		return verfifyName;
	}
	public void setVerfifyName(String verfifyName) {
		this.verfifyName = verfifyName;
	}
	public String getVerfifyNote() {
		return verfifyNote;
	}
	public void setVerfifyNote(String verfifyNote) {
		this.verfifyNote = verfifyNote;
	}
	public String getAddress() {
		return address;
	}
	@Transient
	public int getAge() {
		
        return GetSth.getAge(birthday);
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getEducation() {
		return education;
	}
	public String getExperience() {
		return experience;
	}
	public String getGraduatedsSchool() {
		return graduatedsSchool;
	}

	public String getName() {
		return name;
	}
	public String getPosition() {
		return position;
	}
	public String getProfession() {
		return profession;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public String getRemark() {
		return remark;
	}
	public String getSex() {
		return sex;
	}
	

	public void setAddress(String address) {
		this.address = address;
	}
	public void setAge(int age) {
		if (null!=new Integer(age) ) {
			this.age =age;	
		}
		this.age=0;
		
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setEducation(String education) {
		this.education = education;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	public void setGraduatedsSchool(String graduatedsSchool) {
		this.graduatedsSchool = graduatedsSchool;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public Integer getIsEmploied() {
		return isEmploied;
	}
	public void setIsEmploied(Integer isEmploied) {
		this.isEmploied = isEmploied;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


}
