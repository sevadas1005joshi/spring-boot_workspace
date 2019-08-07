package com.jpa.employeeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AddressDto {

	private Long id;
	private String city;
	private String state;
	private Integer pin;
	@JsonIgnore
	private EmployeeDto employeeDto;
	public AddressDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddressDto(Long id, String city, String state, Integer pin,
			EmployeeDto employeeDto) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.employeeDto = employeeDto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}
	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}
	
}
