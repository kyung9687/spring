package com.kh.spring.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

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
	
//	@Autowired
//	public MemberServiceImpl(MemberDAO memberDaom, SqlSessionTemplate sqlSession) {
//		this.memberDao = memberDao;
//		this.sqlSession = sqlSession;
//	}
//	
	
	@Override
	public MemberDTO login(MemberDTO member) {
		
		if(member.getMemberId().length()>10) {
			return null;
		}
		if(member == null ||
		   member.getMemberId() == null||
		   member.getMemberId().trim().isEmpty() ||
		   member.getMemberPw() == null||
		   member.getMemberPw().trim().isEmpty()) {
			return null;
		}
		
		MemberDTO loginMember = memberDao.login(sqlSession,member);
		
		
		return loginMember;
	}
	
	@Override
	public MemberDTO signUp(MemberDTO member) {
		return null;
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
