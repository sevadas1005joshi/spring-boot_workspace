package com.jpa.employeeservice.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.employeeservice.entity.Address;
import com.jpa.employeeservice.exeptionHandler.EmployeeNotFoundException;
import com.jpa.employeeservice.model.AddressDto;
import com.jpa.employeeservice.model.EmployeeDto;
import com.jpa.employeeservice.service.AddressService;
import com.jpa.employeeservice.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	
	@Autowired
	private AddressService addService;
	
	@RequestMapping("/{empId}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable String empId){	
		EmployeeDto emp = service.getEmployeeById(empId);
		if(emp!=null){
			return new ResponseEntity<EmployeeDto>(emp, HttpStatus.OK);
		}else{
			throw new EmployeeNotFoundException("Employee not found with id :"+empId);
		}
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employeeDto){	
		EmployeeDto emp = service.saveEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(emp, HttpStatus.OK);
	}

	@PutMapping("/{empId}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable String empId,@Valid @RequestBody EmployeeDto employeeDto){	
		EmployeeDto emp = service.updateEmployee(empId,employeeDto);
		return new ResponseEntity<EmployeeDto>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable String empId){	
		service.deleteEmployeeById(empId);
	return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployee(@RequestParam(name="age", required=false) Integer age,@RequestParam(name="DOB", required=false) LocalDate DOB){	
		List<EmployeeDto> empList = service.getAllEmployee(age, DOB);
		return new ResponseEntity<List<EmployeeDto>>(empList, HttpStatus.OK);
	}
	
	@RequestMapping("/{empId}/addresses")
	public List<AddressDto> getEmployeeAllAddress(@PathVariable String empId){	
	EmployeeDto emp = service.getEmployeeById(empId);
		return emp.getAddress();
		
	}
}
