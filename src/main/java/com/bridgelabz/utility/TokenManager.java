package com.bridgelabz.utility;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
  private String sceketKey="dfdiufiuijkcknhfife";
	
	public String generateToke(String email) {
		 Map<String, Object>map =new HashMap<>();
		 map.put("email", email);
		String token =Jwts.builder().setClaims(map).setSubject(email).signWith(SignatureAlgorithm.HS256, sceketKey).compact();
		return token;
	}
	public String decodeToken(String token) {
		final Claims claims =Jwts.parser().setSigningKey(sceketKey).parseClaimsJws(token).getBody();
		String email =(String) claims.get("email");
		return email;
	}

}
