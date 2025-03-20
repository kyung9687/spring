package com.kh.spring.member.model.service;

import javax.servlet.http.HttpSession;

import com.kh.spring.member.model.dto.MemberDTO;

public interface MemberService {

	//로그인
	MemberDTO login(MemberDTO member);
	
	//회원가입
	void signUp(MemberDTO member);
	
	//회원정보수정
	MemberDTO update(MemberDTO member ,HttpSession session);
	
	// 회원탈퇴
	int delete(MemberDTO member);

	
	
}
