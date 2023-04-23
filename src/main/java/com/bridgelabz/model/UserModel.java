package com.bridgelabz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
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
	private boolean isLogin=false;
	private boolean status=false;
	private String rollTypes="user";
	@NotEmpty
	private String dateOfBirth;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getRollTypes() {
		return rollTypes;
	}
	public void setRollTypes(String rollTypes) {
		this.rollTypes = rollTypes;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", isLogin=" + isLogin + ", status=" + status + ", rollTypes="
				+ rollTypes + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
