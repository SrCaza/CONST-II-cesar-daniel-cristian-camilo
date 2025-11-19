package app.infrastructure.percistence.entities;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "patients")
public class PatientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private long id;
 
	@Column(nullable = false, length = 100)
	private String name;
 
	@Column(unique = true)
	private long document;
 
	@Column(nullable = false)
	private int age;
 
	@Column(nullable = false, length = 20)
	private String gender;
 
	@Column(length = 200)
	private String address;
 
	@Column(length = 20)
	private String phone;
 
	@Column(length = 100)
	private String email;
 
	public long getId() {
		return id;
	}
 
	public void setId(long id) {
		this.id = id;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public long getDocument() {
		return document;
	}
 
	public void setDocument(long document) {
		this.document = document;
	}
 
	public int getAge() {
		return age;
	}
 
	public void setAge(int age) {
		this.age = age;
	}
 
	public String getGender() {
		return gender;
	}
 
	public void setGender(String gender) {
		this.gender = gender;
	}
 
	public String getAddress() {
		return address;
	}
 
	public void setAddress(String address) {
		this.address = address;
	}
 
	public String getPhone() {
		return phone;
	}
 
	public void setPhone(String phone) {
		this.phone = phone;
	}
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
}
