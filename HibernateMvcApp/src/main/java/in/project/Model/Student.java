package in.project.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentData")
public class Student{
	
		@Id
		@Column(name="sid")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer sid;
		
		@Column(name="name")
		private String name;
		
		@Column(name="email")
		private String email;
		
		@Column(name="city")
		private String city;
		
		@Column(name="country")
		private String country;
		
		
		public Student() {
			System.out.println("Student Object is Created");
		}
		static {
			System.out.println("student.class is loading...");
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public Integer getSid() {
			return sid;
		}
		public void setSid(Integer sid) {
			this.sid = sid;
		}
		@Override
		public String toString() {
			return "Student [name=" + name + ", email=" + email + ", city=" + city + ", country=" + country + ", sid="
					+ sid + "]";
		}
		
		
}
