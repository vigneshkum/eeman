package blue.liuk.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_pay")
public class Pay implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Employee employee;
	
	private int account;
	private Date time;
	private long basePay;
	private long extraPay;
	private int   workAge;
	private long  attendPay;

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public long getBasePay() {
		return basePay;
	}

	public void setBasePay(long basePay) {
		this.basePay = basePay;
	}

	public long getExtraPay() {
		return extraPay;
	}

	public void setExtraPay(long extraPay) {
		this.extraPay = extraPay;
	}


	public int getWorkAge() {
		return workAge;
	}

	public void setWorkAge(int workAge) {
		this.workAge = workAge;
	}

	public long getAttendPay() {
		return attendPay;
	}

	public void setAttendPay(long attendPay) {
		this.attendPay = attendPay;
	}

	public long getAbsentPay() {
		return absentPay;
	}

	public void setAbsentPay(long absentPay) {
		this.absentPay = absentPay;
	}

	public long getInsurancePay() {
		return insurancePay;
	}

	public void setInsurancePay(long insurancePay) {
		this.insurancePay = insurancePay;
	}

	private long absentPay;
	private long insurancePay;
	


	
	 @ManyToOne
	 @JoinColumn
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
