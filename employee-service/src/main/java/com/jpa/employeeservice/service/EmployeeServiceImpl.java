package com.jpa.employeeservice.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.jpa.employeeservice.entity.Address;
import com.jpa.employeeservice.entity.Employee;
import com.jpa.employeeservice.model.AddressDto;
import com.jpa.employeeservice.model.ConfigFile;
import com.jpa.employeeservice.model.EmployeeDto;
import com.jpa.employeeservice.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EmployeeDto getEmployeeById(String empId) {
		
		Employee employee = repository.findById(empId).get();	
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		return employeeDto;
	}
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		employeeDto.setLastUpdated(LocalDateTime.now());
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		repository.save(employee);
		EmployeeDto result = modelMapper.map(employee, EmployeeDto.class);
		return result;
	}
	@Override
	public EmployeeDto updateEmployee(String empId, EmployeeDto employeeDtoReq) {
		Employee employee = repository.findById(empId).get();
		EmployeeDto employeeDtoRes = modelMapper.map(employee, EmployeeDto.class);
		
		BeanUtils.copyProperties(employeeDtoReq, employeeDtoRes);	
		
		Employee employeeRes = modelMapper.map(employeeDtoRes, Employee.class);
		employeeRes.setLastUpdated(LocalDateTime.now());
		Employee result = repository.save(employeeRes);
		
		return modelMapper.map(result, EmployeeDto.class);
	}
	@Override
	public void deleteEmployeeById(String empId) {
		repository.deleteById(empId);
	}
	@Override
	public List<EmployeeDto> getAllEmployee(Integer age,LocalDate DOB) {
		List<EmployeeDto> empListRes=null;
		if(age!=null){
			empListRes = getAllEmployeeAgeAbove(age);
		}else if(DOB!=null){
			//to be implemented
		}else{	
			List<Employee> empList = repository.findAll();
			empListRes = empList.stream().map(e -> modelMapper.map(e, EmployeeDto.class)).collect(Collectors.toList());
		}
		return empListRes;
	}

	private List<EmployeeDto> getAllEmployeeAgeAbove(int age) {
		List<Employee> empList = repository.findByAgeAbove(age);
		List<EmployeeDto> empListRes = empList.stream().map(e -> modelMapper.map(e, EmployeeDto.class)).collect(Collectors.toList());
		return empListRes;
	}
}
