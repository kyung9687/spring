package com.kh.spring.member.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.spring.member.model.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	
	@Select("	select"
			+ "		 member_id 		memberId"
			+ "		,member_pw 		memberPw"
			+ "		,member_name 	memberName"
			+ "		,email			"
			+ "		,enroll_date	enrollDate"
			+ "	from"
			+ "		KH_MEMBER"
			+ "	where"
			+ "		member_id = #{memberId}"
			)
	MemberDTO login(MemberDTO member);
	
	@Insert("insert into"
			+ "	KH_MEMBER"
			+ "	values"
			+ "	("
			+ "	  #{memberId}"
			+ "	, #{memberPw}"
			+ "	, #{memberName}"
			+ "	, #{email}"
			+ "	, SYSDATE"
			+ "	)")
	int signUp(MemberDTO member);
	
	
	int update(MemberDTO member);
	int delete(MemberDTO member);
}
