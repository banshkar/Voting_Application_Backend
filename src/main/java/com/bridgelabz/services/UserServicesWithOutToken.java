package com.bridgelabz.services;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bridgelabz.dto.CondidateRegisterDto;
import com.bridgelabz.dto.LoginDto;
import com.bridgelabz.dto.RegisterDto;
import com.bridgelabz.exeption.ResponseHandle;
import com.bridgelabz.exeption.UserExeption;
import com.bridgelabz.model.Address;
import com.bridgelabz.model.Box;
import com.bridgelabz.model.CondidateModel;
import com.bridgelabz.model.UserModel;
import com.bridgelabz.repo.AddressRepo;
import com.bridgelabz.repo.CondidateRepo;
import com.bridgelabz.repo.UserModelRepo;
import com.bridgelabz.utility.AgeCalculate;
import com.bridgelabz.utility.EmailSender;
import com.bridgelabz.utility.TokenManager;

@Service
public class UserServicesWithOutToken {
	
	@Autowired
	private UserModelRepo userModelRepo;
	
	@Autowired
	private TokenManager tokenManager;
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ResponseHandle responseHandle;
	
	@Autowired
	private AgeCalculate ageCalculate;
	
	@Autowired
	private CondidateRepo condidateRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	Logger logger =LoggerFactory.getLogger(UserServicesWithOutToken.class);
	public ResponseEntity<Object> registerUser(RegisterDto registerDto){
		int age =ageCalculate.checkAge(registerDto.getDateOfBirth());
		if(age>=18) {
			if(userModelRepo.findByUserName(registerDto.getUserName()).isPresent()) {
				logger.error("This UserName Already Resister");
				throw new UserExeption("this UserName Already Resister");
			}
			else {
				if(userModelRepo.findByEmail(registerDto.getEmail()).isPresent()) {
					logger.error("This Email Already Register");
					throw new UserExeption("This Email Already Register");
				}
				UserModel user =mapper.map(registerDto, UserModel.class);
				userModelRepo.save(user);
				String email ="Hy,  \n Mr.  "+registerDto.getUserName()+" \n Your Registration SuccessFully and \n Your UserName: "+registerDto.getUserName()
				+"\n Password: "+registerDto.getPassword();
				emailSender.emailS(registerDto.getEmail(), "registration", email);
				logger.info("Your Registration SuccessFully");
				return responseHandle.getResponse("Your Registration SuccessFully", registerDto);
			}
		}
		throw new UserExeption("you are not eligible beacause your age less then 18...Jao khelo Bache... ");
		
	}
	
	public ResponseEntity<Object> login(LoginDto loginDto){
		if(userModelRepo.findByUserName(loginDto.getUserName()).isPresent()) {
			if(userModelRepo.findByUserName(loginDto.getUserName()).get().getPassword().equals(loginDto.getPassword())) {
				UserModel user =userModelRepo.findByUserName(loginDto.getUserName()).get();
				user.setLogin(true);
				userModelRepo.save(user);
				String token =tokenManager.generateToke(user.getEmail());
				logger.info("Login  SuccessFully");
				return responseHandle.getResponse("Login SuccessFully", token);
			}
			logger.error("please Enter Right Password");
			throw new UserExeption("please Enter Right Password");
		}
		logger.error("Register Account After You Can Login...Byy");
		throw new UserExeption("Register Account After You Can Login...Byy");
	}
	
	public ResponseEntity<Object> registerCondidate(CondidateRegisterDto condidateRegisterDto){
		int age =ageCalculate.checkAge(condidateRegisterDto.getDateOfBirth());
		if(age>=18){
			if( condidateRepo.findByEmail(condidateRegisterDto.getEmail()).isPresent()) {
				logger.error("This UserName Already Resister");
				throw new UserExeption("this UserName Already Resister");
			}
			else {
				CondidateModel condidateModel = mapper.map(condidateRegisterDto, CondidateModel.class);
				 condidateModel.getAddress().setCondidateModel(condidateModel);
				 String userName =ageCalculate.getUserName(condidateRegisterDto.getFirstName());
				  RegisterDto registerDto =new   RegisterDto();
				  registerDto.setUserName(userName);
				  registerDto.setDateOfBirth(condidateModel.getDateOfBirth());
				  registerDto.setEmail(condidateModel.getEmail());
				  registerDto.setPassword(condidateModel.getPassword());
				  registerDto.setPhoneNumber(condidateModel.getPhoneNumber());
				  Box box =new Box();
				  condidateModel.setBox(box);
				  box.setCondidateModel(condidateModel);
				  condidateRepo.save(condidateModel);
				  UserModel user =mapper.map(registerDto, UserModel.class);
				  user.setId(user.getId());
				  user.setRollTypes("condidate");
				  userModelRepo.save(user);
				  String email ="Hy,  \n Mr.  "+userName+" \n Your Registration SuccessFully and \n Your UserName: "+userName
					+"\n Password: "+condidateModel.getPassword();
					emailSender.emailS(condidateModel.getEmail(), "registration", email);
				logger.info("Your Registration SuccessFully");
				return responseHandle.getResponse("Your Registration SuccessFully",condidateRegisterDto);
			}
		}
		throw new UserExeption("you are not eligible beacause your age less then 18...Jao khelo Bache... ");
	}

}
