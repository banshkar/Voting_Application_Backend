package com.bridgelabz.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class CondidateModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty(message = "please Enter right name")
	private String firstName;
	@NotEmpty(message = "please Enter right name")
	private String  lastName;
	@Email(message = "please Enter valid Email")
	private String email;
	@Pattern(regexp = "^[A-Z]{1}+[a-z0-9]+$",message = "password first charactrer Upper Case and num,lower,min 6 digit")
	@Size(min = 6,max = 15)
	private String password;
	@Size(max = 10)
	private String phoneNumber;
	@NotEmpty
	private String dateOfBirth;
	private boolean isLogin=false;
	private boolean status=false;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="condidateModel")
	private Address address;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "condidateModel")
    private Box box;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Box getBox() {
		return box;
	}
	public void setBox(Box box) {
		this.box = box;
	}
	@Override
	public String toString() {
		return "CondidateModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth
				+ ", isLogin=" + isLogin + ", status=" + status + ", address=" + address + ", box=" + box + "]";
	}
	
}
