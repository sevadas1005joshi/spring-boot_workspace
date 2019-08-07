package com.jpa.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.employeeservice.entity.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
