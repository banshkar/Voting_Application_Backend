package com.bridgelabz.controller;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bridgelabz.dto.CondidateRegisterDto;
import com.bridgelabz.dto.LoginDto;
import com.bridgelabz.dto.RegisterDto;
import com.bridgelabz.services.UserService;
import com.bridgelabz.services.UserServiceImp;
import com.bridgelabz.services.UserServicesWithOutToken;
import com.bridgelabz.utility.EmailSender;
import com.bridgelabz.utility.FileManager;

@RestController
public class UserController {
	 
	
 Logger logger =LoggerFactory.getLogger(UserController.class);	
	@Autowired
	private UserService userServiceImp;
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	private UserServicesWithOutToken userServicesWithOutToken;
	
	@Autowired
	private FileManager fileManager;
	
	@GetMapping("/hello")
	public String hello() {
	String l=	 userServiceImp.addd();
		return l;
	}
	
	@PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody RegisterDto registerDto){
		logger.info("checking.. data {}",registerDto.toString());
	  return  this.userServicesWithOutToken.registerUser(registerDto);
    }
	@PostMapping("/logIn")
	public ResponseEntity<Object> logIn(@RequestBody LoginDto loginDto){
		  return  this.userServicesWithOutToken.login(loginDto);
	   }
	@PostMapping("/registerCondidate")
    public ResponseEntity<Object> registerCondidate(@Valid @RequestBody CondidateRegisterDto condidateRegisterDto){
		logger.info("checking.. data {}",condidateRegisterDto.toString());
	  return  this.userServicesWithOutToken.registerCondidate(condidateRegisterDto);
    }
	@GetMapping("/logOut")
	public ResponseEntity<Object> logOut(@RequestParam String token){
		  return  this.userServiceImp.logOut(token);
	   }
	@GetMapping("/condidate")
	public ResponseEntity<Object> getAllCondidate(@RequestParam String token){
		  return  this.userServiceImp.allCondidate(token);
	   }
	@GetMapping("/voting")
	public ResponseEntity<Object> voting(@RequestParam int id,@RequestParam String token){
		  return  this.userServiceImp.voting(token, id);
	   }
	@GetMapping("/winner")
	public ResponseEntity<Object> winner(@RequestParam String token){
		  return  this.userServiceImp.winnerCondidate(token);
	   }
	
	@GetMapping("/upload")
	public ResponseEntity<Object> fileUpload(@RequestParam("file") MultipartFile file){
		
		 logger.info("file Name :{}",file.getOriginalFilename());
		 logger.info("file Size :{}",file.getSize());
		 logger.info("file types :{}",file.getContentType());
		 logger.info("file Name :{}",file.getName());
		boolean l=fileManager.fileUpload(file);
		if(l) {
			 logger.info("file is Upload :{}",file.getName());
			 String url="/images/"+file.getOriginalFilename();
			return new ResponseEntity<Object>(url,HttpStatus.OK);
			
		}
		else {
			 logger.error("file is  not Upload ");
			return new ResponseEntity<Object>("not work",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

		
		
	


}
