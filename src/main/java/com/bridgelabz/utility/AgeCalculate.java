package com.bridgelabz.utility;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class AgeCalculate {
	
	
	public int checkAge(String d) {
		   String[]arr =d.split("/");
	       String newDate = arr[2]+"-"+arr[1]+"-"+arr[0];
	  	   LocalDate dob =LocalDate.parse(newDate);
	        LocalDate currentDate =LocalDate.now();
	        System.out.println(currentDate);
	        if(dob!=null && currentDate!=null){
	            return Period.between(dob,currentDate).getYears();
	        }
	        else{
	         return 0;
	        }
	}
	public String getUserName(String name) {
		String number ="1234506789";
		String oTP =name+"";
		for(int index=0; index<5; index++) {
			Random randam =new Random();
			int num =randam.nextInt(10);
			oTP=oTP+number.charAt(num);
		}
		System.out.println(oTP);
		return oTP;
	}

}
