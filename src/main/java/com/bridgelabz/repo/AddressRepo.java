package com.bridgelabz.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
