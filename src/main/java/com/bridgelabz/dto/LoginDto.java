package com.bridgelabz.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
public class LoginDto {
	
	@NotEmpty(message = "UserName can not be Empty ")
	@Size(min = 6,message = "UserName MiniMum 6 Character")
	private String userName;
	@Pattern(regexp = "^[A-Z]{1}+[a-z0-9]+$",message = "password first charactrer Upper Case and num,lower,min 6 digit")
	@Size(min = 6,max = 15)
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDto [userName=" + userName + ", password=" + password + "]";
	}
	

}
