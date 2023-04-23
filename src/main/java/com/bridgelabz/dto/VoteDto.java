package com.bridgelabz.dto;

import org.springframework.stereotype.Component;

@Component
public class VoteDto {
	private String userName;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}