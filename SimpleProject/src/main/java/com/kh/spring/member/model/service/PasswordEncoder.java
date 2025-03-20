package com.kh.spring.member.model.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PasswordEncoder {
	
	private final BCryptPasswordEncoder passwordEnconder;
	
	public String encode(String rawPassword) {
		return passwordEnconder.encode(rawPassword);
	}
	
	public boolean matches(String rawPassword,String encodePassword) {
		return passwordEnconder.matches(rawPassword, encodePassword);
	}
	
	

}
