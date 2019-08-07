package com.jpa.employeeservice.repository;

import java.util.List;

import com.jpa.employeeservice.entity.Employee;

public interface CustomEmployeeRepository {
	public List<Employee> searchEmployeeByNameAndAge(String name,int age);
}
