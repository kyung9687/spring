package com.kh.spring.member.model.service;

import java.security.InvalidParameterException;

import org.springframework.stereotype.Component;

import com.kh.spring.exception.controller.DuplicateIdException;
import com.kh.spring.exception.controller.MemberNotFoundException;
import com.kh.spring.exception.controller.TooLargeValueException;
import com.kh.spring.member.model.dao.MemberMapper;
import com.kh.spring.member.model.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MemberValidator {
	
	
	private final MemberMapper mapper;
	
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
	
	private void validateDuplicateId(MemberDTO member) {
		MemberDTO existingMember = mapper.login(member);
		if(existingMember != null && member.getMemberId().equals(existingMember.getMemberId())) {
			throw new DuplicateIdException("이미 존재하는 회원의 아이디");
		}
	}
	
	
	public void validatedJoinMember(MemberDTO member) {
		validatedLoginMember(member);
		validateDuplicateId(member);
	}
	
	public void validatedLoginMember(MemberDTO member) {
		validatedLength(member);
		validatedValue(member);
	}
	
	public MemberDTO validateMemberExists(MemberDTO member) {
		System.out.println(member);
		MemberDTO loginMember = mapper.login(member);
		System.out.println(loginMember);
		if (loginMember != null) {
			return loginMember;
		}
		throw new MemberNotFoundException("존재하지 않는 아이디");
	}
	
}
