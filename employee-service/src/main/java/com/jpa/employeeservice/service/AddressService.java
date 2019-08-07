package com.jpa.employeeservice.service;

import java.util.List;

import com.jpa.employeeservice.entity.Address;
import com.jpa.employeeservice.model.AddressDto;

public interface AddressService {
	public AddressDto getAddressById(Long empId);
	
	public AddressDto saveAddress(AddressDto address);

}
