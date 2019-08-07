package com.jpa.employeeservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jpa.employeeservice.CustomDateDeserializer;
import com.jpa.employeeservice.CustomDateSerializer;

public class EmployeeDto {

   private String id;
   private String name;     
   private int age;     
   private String gender;
   @Pattern(regexp="^[A]{1}[R]{1}[0-9]{5}")
   //@JsonDeserialize(using = NameDeserializer.class)
   private String serialId;
   @JsonFormat(pattern = "dd/MM/yyyy")
   @JsonProperty(value="DOB") //chnage the name in json resonse-request
   private LocalDate dateOfBirth;
   
   @JsonDeserialize(using = CustomDateDeserializer.class)
   @JsonSerialize(using = CustomDateSerializer.class)
   //@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
   private LocalDateTime lastUpdated;
   
   private List<AddressDto> address;
	public EmployeeDto() {
		super();
	}

	public EmployeeDto(String id, String name, int age, String gender,
			String serialId,
			LocalDate dateOfBirth, LocalDateTime lastUpdated,
			List<AddressDto> address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.serialId = serialId;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
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

	public List<AddressDto> getAddress() {
		return address;
	}

	public void setAddress(List<AddressDto> Address) {
		this.address = Address;
	}



}
