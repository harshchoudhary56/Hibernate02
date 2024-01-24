package in.ineuron.model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "STDTAB")
@DynamicUpdate(value=true)
public class Student {
	
	@Id
	@Column(name="stdId")
	private Integer sid;
	
	@Column(name = "stdName", length = 20)
	private String sname;
	
	@Column(name = "stdAddr", length = 20)
	private String saddress;
	
	@Column(name = "stdAge")
	private Integer sage;
	
	public Student() {
		System.out.println("Hibernate uses zero argument constructor internally");
	}
	
	@Override
	public String toString() {
		return sid + " " + sname + " " + saddress + " " + sage;
	}
	public Integer getSid() {
		return sid;
	}
	
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	public String getSname() {
		return sname;
	}
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public Integer getSage() {
		return sage;
	}
	
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	
	public String getSaddress() {
		return saddress;
	}
	
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
}
