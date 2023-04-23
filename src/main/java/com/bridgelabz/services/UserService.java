package com.bridgelabz.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface UserService {
	public ResponseEntity<Object> allCondidate(String token);
	public ResponseEntity<Object> logOut(String token);
	public ResponseEntity<Object> voting(String token,int id);
	public ResponseEntity<Object> winnerCondidate(String token);
	 public String  addd();

}
