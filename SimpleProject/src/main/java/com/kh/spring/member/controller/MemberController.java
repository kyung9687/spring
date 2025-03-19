package com.kh.spring.member.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.dto.MemberDTO;
import com.kh.spring.member.model.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor // 의존성 주입 생성자를 생성해주는 애노테이션
public class MemberController {
	
//	@Autowired
	private final MemberService memberService;
	
//	@Autowired
//	public void MemberService(MemberDTO member) {
//		this.memberService =memberService;
//	}
	
//	@Autowired
//	public MemberController(MemberService memberService) {
//		this.memberService = memberService;
//	}
/*
	@RequestMapping(value="login")
	public void login(HttpServletRequest request) {
//		System.out.println("나는 로그인 요청 오면 출동함");
		String id =request.getParameter("id");
		String pw =request.getParameter("pw");
		log.info("id:{},pw:{}",id,pw);
		
		return "main_page";
	}
	*/
	/*
	@RequestMapping("login")
	public String login(@RequestParam(value = "id") String id,
						@RequestParam(value = "pw") String pw) {
		
	log.info("이렇게 도 넘어오나요? id:{},pw:{}",id,pw);
		return "main_page";
	}
	*/
	/*
	@PostMapping("login")
		log.info("id:{},pw:{}",id,pw);
		MemberDTO member = new MemberDTO();
		member.setMemberId(id);
		member.setMemberPw(Pw);
		
		return "main_page";
	*/
	
//	@PostMapping("login")
//	public String login(MemberDTO member, HttpSession session ,Model model ) {
//		
//		log.info("이런건 안됨{}", member);
//		
//		MemberDTO loginMember = memberService.login(member);
//		if(loginMember != null) {
//			
//			log.info("로그인성공");
//		}else {
//			log.info("로그인 실패");
//		}
		
//		if (loginMember != null) {
//			session.setAttribute("loginMember", loginMember);
//			
//			return "redirect:/";
//		}else {
//			model.addAttribute("message","로그인 실패");
//			
//			return "include/error_page";
//		}
		
//		return "main_page";
//}
	@PostMapping("login")
	public ModelAndView login(MemberDTO member,
							  HttpSession session,
							  ModelAndView mv) {
		MemberDTO loginMember = memberService.login(member);
		
		if (loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			mv.setViewName("redirect:/");
		}else {
			mv.addObject("message", "로그인실패!")
			  .setViewName("include/error_page");
		}
		return mv;
	}
		
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session,
							   ModelAndView mv) {
		session.removeAttribute("loginMember");
		mv.setViewName("redirect:/");
		return mv;
	}
	
	
	public void join(MemberDTO member) {
		
	}
	
}
