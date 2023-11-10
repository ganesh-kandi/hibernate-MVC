package in.project.Model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="empTab")
public class Employee {
//	@Id
//	@Column(name="eid")
	//@GenericGenerator(name="gen1", strategy = "increment")
	//@GeneratedValue(generator="gen1")
	@Id
	@Column(name="eid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eId;
	
	@Column(name="ename")
	private String ename;
	
	@Column(name="esal")
	private double esal;
	
	static {
		System.out.println("employee class is loading");
	}
	
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getEsal() {
		return esal;
	}
	public void setEsal(double esal) {
		this.esal = esal;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", ename=" + ename + ", esal=" + esal + "]";
	}
	
}
