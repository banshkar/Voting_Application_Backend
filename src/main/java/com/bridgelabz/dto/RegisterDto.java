package com.bridgelabz.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.bridgelabz.model.Address;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

@Component
public class RegisterDto {
	
	@NotEmpty(message = "UserName can not be Empty ")
	@Size(min = 6,message = "UserName MiniMum 6 Character")
	private String userName;
	@Email(message = "please enter valid Email")
	private String email;
	@Pattern(regexp = "^[A-Z]{1}+[a-z0-9]+$",message = "password first charactrer Upper Case and num,lower,min 6 digit")
	@Size(min = 6,max = 15)
	private String password;
	@NotEmpty(message = "valid Number")
	@Size(max = 10)
	private String phoneNumber;
	@NotEmpty
	private String dateOfBirth;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public String toString() {
		return "RegisterDto [userName=" + userName + ", email=" + email + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", dateOfBirth=" + dateOfBirth + "]";
	}


}
