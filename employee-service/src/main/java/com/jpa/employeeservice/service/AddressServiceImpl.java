package com.jpa.employeeservice.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.employeeservice.entity.Address;
import com.jpa.employeeservice.model.AddressDto;
import com.jpa.employeeservice.repository.AddressRepository;
@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepository repo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public AddressDto getAddressById(Long addId) {
		Optional<Address> address = repo.findById(addId);
		if(!address.isPresent()){
			throw new RuntimeException("address not found");
		}	
		return modelMapper.map(address.get(), AddressDto.class);
	}

	@Override
	public AddressDto saveAddress(AddressDto addressDtp) {
		Address address = modelMapper.map(addressDtp, Address.class);
		Address add = repo.save(address);
		return modelMapper.map(add, AddressDto.class);
	}
}
