package com.bridgelabz.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.bridgelabz.model.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
public class CondidateRegisterDto {
	
	@NotEmpty(message = "please Enter right name")
	private String firstName;
	@NotEmpty(message = "please Enter right name")
	private String  lastName;
	@Email(message = "please Enter valid Email")
	private String email;
	@Pattern(regexp = "^[A-Z]{1}+[a-z0-9]+$",message = "password first charactrer Upper Case and num,lower,min 6 digit")
	@Size(min = 6,max = 15)
	private String password;
	@NotEmpty
	@Size(max = 10)
	private String phoneNumber;
	@NotEmpty
	private String dateOfBirth;
    private AddressDto addressDto;
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
	public AddressDto getAddressDto() {
		return addressDto;
	}
	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}
	@Override
	public String toString() {
		return "CondidateRegisterDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth
				+ ", addressDto=" + addressDto + "]";
	}
	
}
