package com.kh.spring.member.model.service;

import java.security.InvalidParameterException;

import org.springframework.stereotype.Component;

import com.kh.spring.exception.controller.TooLargeValueException;
import com.kh.spring.member.model.dto.MemberDTO;

@Component
public class MemberValidator {
	private void validatedLength(MemberDTO member) {
		if(member.getMemberId().length()>10) {
			throw new TooLargeValueException("아이디가 너무 길어 10자이내로 작성하도록");
		}
	}
	private void validatedValue(MemberDTO member) {
		if(member == null ||
				   member.getMemberId() == null||
				   member.getMemberId().trim().isEmpty() ||
				   member.getMemberPw() == null||
				   member.getMemberPw().trim().isEmpty()) {
					throw new InvalidParameterException("유효하지않은 입력값");
		}
				
	}
	
	void validatedLoginMember(MemberDTO member) {
		validatedLength(member);
		validatedValue(member);
	}
}
