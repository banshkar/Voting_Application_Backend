package com.bridgelabz.exeption;


public class UserExeption extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public UserExeption() {
		super();
		
	}
	public UserExeption(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "UserExeption [message=" + message + "]";
	}
	

}
