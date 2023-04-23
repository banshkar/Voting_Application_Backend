package com.bridgelabz.services;


import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.Comparators;

import com.bridgelabz.dto.VoteDto;
import com.bridgelabz.exeption.ResponseHandle;
import com.bridgelabz.exeption.UserExeption;
import com.bridgelabz.model.Box;
import com.bridgelabz.model.CondidateModel;
import com.bridgelabz.model.UserModel;
import com.bridgelabz.model.Vote;
import com.bridgelabz.repo.AddressRepo;
import com.bridgelabz.repo.CondidateRepo;
import com.bridgelabz.repo.UserModelRepo;
import com.bridgelabz.utility.AgeCalculate;
import com.bridgelabz.utility.EmailSender;
import com.bridgelabz.utility.TokenManager;

@Service
@EnableAsync
public class UserServiceImp implements  UserService{
	
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
	private CondidateRepo condidateRepo;
	
	
	
	
	 
	Logger logger =LoggerFactory.getLogger(UserServiceImp.class);

	@Override
	public ResponseEntity<Object> allCondidate(String token) {
		String email =tokenManager.decodeToken(token);
		if(userModelRepo.findByEmail(email).get().isLogin()) {
			List<CondidateModel>list =condidateRepo.findAll();
			List<String> listCondidate = new LinkedList<>();
			list.forEach((e)->{
				listCondidate.add(e.getFirstName());
			});
			return responseHandle.getResponse("Condidate List", listCondidate);
		}
		
	  throw new UserExeption("Please Login Account");
		
	}

	@Override
	public ResponseEntity<Object> logOut(String token) {
		String email =tokenManager.decodeToken(token);
		if(userModelRepo.findByEmail(email).get().isLogin()) {
			UserModel us =userModelRepo.findByEmail(email).get();
			us.setId(us.getId());
			 us.setLogin(false);
			 userModelRepo.save(us);
			 return new  ResponseEntity<Object>("LogOut",HttpStatus.OK);
		}
		UserModel us =userModelRepo.findByEmail(email).get();
		us.setId(us.getId());
		 us.setLogin(false);
		 userModelRepo.save(us);
		 return new  ResponseEntity<Object>("LogOut",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> voting(String token,int id) {
		
		String email =tokenManager.decodeToken(token);
		if(userModelRepo.findByEmail(email).get().isLogin()) {
		 if(userModelRepo.findByEmail(email).get().isStatus()) {
			 throw new UserExeption("You Have Voted....have Nice day Byy");
		 }
			UserModel us =userModelRepo.findByEmail(email).get();
			CondidateModel condidateModel =condidateRepo.findById(id).get();
			System.out.println("working..............");
			int ids =condidateModel.getBox().getId();
			System.out.println(ids);
			
		    logger.info("get id :{}",ids);
			VoteDto voteDto =new VoteDto();

			voteDto.setUserName(us.getUserName());
			Vote vote =mapper.map(voteDto, Vote.class);
			vote.setBox(condidateModel.getBox());
			 condidateModel.getBox().getVotes().add(vote);
			us.setStatus(true);
			condidateRepo.save(condidateModel);
			 userModelRepo.save(us);
			 return new  ResponseEntity<Object>("your vote send Successfully",HttpStatus.OK);
		}
		throw new UserExeption("please Login Account ");
	
		
	}
	
	public  Map<String,Integer> getListResult(){
		  Map<String ,Integer>map =new HashMap<>();
		List<CondidateModel> list =condidateRepo.findAll();
		list.forEach((e)->{
		  int voteCount = e.getBox().getVotes().size();
		  String useName=e.getFirstName()+ " "+e.getLastName();
		  map.put(useName, voteCount);

		});
		return map;
		
	}

	@Override
	public ResponseEntity<Object> winnerCondidate(String token) {
		
		 List<Map.Entry<String, Integer> > list
         = new LinkedList<Map.Entry<String, Integer> >(
             getListResult().entrySet());
		 Collections.sort(list,(e1,e2)->e1.getValue().compareTo(e2.getValue()));
		 HashMap<String, Integer>temp =new LinkedHashMap<>();
		  for(Map.Entry<String, Integer> as:list) {
			  temp.put(as.getKey(), as.getValue());
		  }
		  Stream<Map.Entry<String, Integer>> stream =temp.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		return new ResponseEntity<Object>(stream,HttpStatus.OK);
	}

//	@Scheduled(fixedRate  = 5000)
//	public void checking() throws InterruptedException {
//		logger.info("working.....");
//		Thread.sleep(6000);
//	}

	@Override
    public String  addd() {
	  userModelRepo.findByEmail("anubhai41@gmail.com").ifPresentOrElse((user)->{
		  
	  }, ()->{
		  throw new UserExeption("jhjds");
	  });
	  return "jitendra";
 }


}
