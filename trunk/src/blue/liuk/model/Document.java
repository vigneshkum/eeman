package blue.liuk.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="tb_document")
public class Document {
	private int id;
	private String  filename;
	private String  filetype;
	private Date  uploadTime;
	private String size;
	private String filepath;
	private String description;
	private int type;
	private Employee employee;
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
	public String getDescription() {
		return description;
	}
	public String getFilename() {
		return filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public String getFiletype() {
		return filetype;
	}
	public String getSize() {
		return size;
	}
	public int getType() {
		return type;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	
	
}
