package com.jpa.employeeservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.employeeservice.entity.Employee;

public class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Employee> searchEmployeeByNameAndAge(String name, int age) {
		// TODO Auto-generated method stub
		return null;
	}

}
