package com.bridgelabz.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.model.UserModel;

public interface UserModelRepo extends JpaRepository<UserModel, Integer> {
	
	public Optional<UserModel> findByUserName(String userName);
	public Optional<UserModel> findByEmail(String email);

}
