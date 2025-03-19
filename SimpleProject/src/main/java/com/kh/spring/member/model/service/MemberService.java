package com.kh.spring.member.model.service;

import com.kh.spring.member.model.dto.MemberDTO;

public interface MemberService {

	//로그인
	MemberDTO login(MemberDTO member);
	
	//회원가입
	MemberDTO signUp(MemberDTO member);
	
	//회원정보수정
	MemberDTO update(MemberDTO member);
	
	// 회원탈퇴
		int delete(MemberDTO member);

	
	
}
