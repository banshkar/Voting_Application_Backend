package com.bridgelabz.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.bridgelabz.exeption.UserExeption;

@Component
public class EmailSender {
	
	@Autowired
	private JavaMailSender javaMailSender;
  	
	Logger logger = LoggerFactory.getLogger(EmailSender.class); 
	public void emailS(String toEmail,String subject ,String boby) {
	     
	  try {

			SimpleMailMessage message =new SimpleMailMessage();
			  message.setFrom("jitendrabanshkar07@gmail.com");
			  message.setTo(toEmail);
			  message.setSubject(subject);
			  message.setText(boby);
			  javaMailSender.send(message);
			  logger.info("Email Send SuccessFully.......");
		
	} catch (UserExeption e) {
		// TODO: handle exception
	 throw new UserExeption("Failed Email");
	}
	
		
	}

}
