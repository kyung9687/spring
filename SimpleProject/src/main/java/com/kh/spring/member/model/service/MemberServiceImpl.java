package com.kh.spring.member.model.service;


import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.spring.exception.controller.MemberNotFoundException;
import com.kh.spring.exception.controller.PasswordMissMatchException;
import com.kh.spring.member.model.dao.MemberMapper;
import com.kh.spring.member.model.dto.MemberDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl  implements MemberService{
	
//	private final MemberDAO memberDao;
//	
//	
//	private final SqlSessionTemplate sqlSession;
	
	private final BCryptPasswordEncoder passwordEncoder;
	
	private final MemberValidator validator;
	private final MemberMapper memberMapper;
	
	
//	@Autowired
//	public MemberServiceImpl(MemberDAO memberDaom, SqlSessionTemplate sqlSession) {
//		this.memberDao = memberDao;
//		this.sqlSession = sqlSession;
//	}
//	
	
	@Override
	public MemberDTO login(MemberDTO member) {
		//System.out.println(member);
		
		validator.validatedLoginMember(member);
		MemberDTO loginMember = validator.validateMemberExists(member);
		if (passwordEncoder.matches(member.getMemberPw(), loginMember.getMemberPw())) {
			return loginMember;
		}else {
			throw new PasswordMissMatchException("비밀번호 불일치");
		}
		
		
//		아이디만 일치핟라도 행의 정보를 필드에 담아옴
//		1.loginMember가 null값과 동일하다면 아이디가 존재하지 않는다
		
//		2.아이디만 가지고 조회를 하기 때문에
//		비밀번호를 검증 해야함
		
	}
	
	@Override
	public void signUp(MemberDTO member) {
//		if(member == null ||
//		   member.getMemberId() == null||
//		   member.getMemberId().trim().isEmpty() ||
//		   member.getMemberPw() == null||
//		   member.getMemberPw().trim().isEmpty()) {
//	
//		}
//		
//		validator.validatedLoginMember(member);
		
		/*
		 * int result = memberDao.checkId(sqlSession, member.getMemberId());
		 * if(result>0) {return;}
		 */
	
//		memberMapper.login(member);
		
//		log.info("사용자가 입력한 비밀번호 평문 :{}",member.getMemberPw());
//		log.info("사용자가 암호문으로 바꾼것 :{}", passwordEncoder.encode(member.getMemberPw()));
		
//		memberDao.signup
//		String encPwd = passwordEncoder.encode(member.getMemberPw());
		validator.validatedJoinMember(member);
		member.setMemberPw(passwordEncoder.encode(member.getMemberPw()));
		memberMapper.signUp(member);
		
//		if(consequence>0) {
//			
//			return;
//		}else {
//			return;
//		}
		
		
	}

	
	@Override
	public MemberDTO update(MemberDTO member ,HttpSession session) {
		
		if (member.getMemberId().equals(((MemberDTO)session.getAttribute("loginMeMber")).getMemberId())) {
			
		}
		
		
		
		return null;
	}

	@Override
	public int delete(MemberDTO member) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
