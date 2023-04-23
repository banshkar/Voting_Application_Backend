package com.bridgelabz.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.model.CondidateModel;



public interface CondidateRepo extends JpaRepository<CondidateModel, Integer>{
	
	public Optional<CondidateModel> findByEmail(String email);
//	public Optional<List<String>> findAllByFirstName();

}
