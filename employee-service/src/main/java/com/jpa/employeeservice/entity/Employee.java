package com.jpa.employeeservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {
	@Id
    @GenericGenerator(
            name = "assigned-sequence",
            strategy = "com.jpa.employeeservice.entity.EmpIdGenerator"
        )
	@GeneratedValue(generator="assigned-sequence")
	private String id;
	private String name;     
	private int age;
	@Column(name="serial_Id")
	private String serialId;
	private String gender;
	@Column(name="date_of_birth")
    private LocalDate dateOfBirth;
	@Column(name="last_updated")
    private LocalDateTime lastUpdated;
	
	@OneToMany(mappedBy="employee")
	private List<Address> address;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String id, String name, int age, String serialId,
			String gender, LocalDate dateOfBirth, LocalDateTime lastUpdated,
			List<Address> address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.serialId = serialId;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.lastUpdated = lastUpdated;
		this.address = address;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
}
