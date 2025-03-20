package com.kh.spring.member.model.service;

import java.security.InvalidParameterException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.spring.exception.controller.MemberNotFoundException;
import com.kh.spring.exception.controller.PasswordMissMatchException;
import com.kh.spring.exception.controller.TooLargeValueException;
import com.kh.spring.member.model.dao.MemberDAO;
import com.kh.spring.member.model.dto.MemberDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl  implements MemberService{
	
	private final MemberDAO memberDao;
	
	
	private final SqlSessionTemplate sqlSession;
	
	private final BCryptPasswordEncoder passwordEncoder;
	
	private final MemberValidator validator;
	
	
	
//	@Autowired
//	public MemberServiceImpl(MemberDAO memberDaom, SqlSessionTemplate sqlSession) {
//		this.memberDao = memberDao;
//		this.sqlSession = sqlSession;
//	}
//	
	
	@Override
	public MemberDTO login(MemberDTO member) {
		
		validator.validatedLoginMember(member);
		
		MemberDTO loginMember = memberDao.login(sqlSession,member);
//		아이디만 일치핟라도 행의 정보를 필드에 담아옴
//		1.loginMember가 null값과 동일하다면 아이디가 존재하지 않는다
		if (loginMember == null) {
			throw new MemberNotFoundException("존재하지 않는 아이디");
		}
//		2.아이디만 가지고 조회를 하기 때문에
//		비밀번호를 검증 해야함
		if (passwordEncoder.matches(member.getMemberPw(), loginMember.getMemberPw())) {
			return loginMember;
		}else {
			throw new PasswordMissMatchException("비밀번호 불일치");
		}
		
		
	}
	
	@Override
	public void signUp(MemberDTO member) {
		if(member == null ||
		   member.getMemberId() == null||
		   member.getMemberId().trim().isEmpty() ||
		   member.getMemberPw() == null||
		   member.getMemberPw().trim().isEmpty()) {
	
		}
		int result = memberDao.checkId(sqlSession, member.getMemberId());
		
		log.info("사용자가 입력한 비밀번호 평문 :{}",member.getMemberPw());
		log.info("사용자가 암호문으로 바꾼것 :{}", passwordEncoder.encode(member.getMemberPw()));
		if(result>0) {return;}
		
//		memberDao.signup
		
		String encPwd = passwordEncoder.encode(member.getMemberPw());
		member.setMemberPw(encPwd);
		int consequence =memberDao.signUp(sqlSession, member);
		
		if(consequence>0) {
			
			return;
		}else {
			return;
		}
		
		
	}

	
	@Override
	public MemberDTO update(MemberDTO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(MemberDTO member) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
