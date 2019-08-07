package com.jpa.employeeservice.service;

import java.time.LocalDate;
import java.util.List;

import com.jpa.employeeservice.model.EmployeeDto;


public interface EmployeeService {

	public EmployeeDto getEmployeeById(String empId);

	public EmployeeDto saveEmployee(EmployeeDto employee);

	public EmployeeDto updateEmployee(String empId, EmployeeDto employee);

	public void deleteEmployeeById(String empId);

	public List<EmployeeDto> getAllEmployee(Integer age,LocalDate DOB);

}
