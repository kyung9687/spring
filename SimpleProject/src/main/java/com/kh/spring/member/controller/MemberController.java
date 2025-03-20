package com.kh.spring.member.controller;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
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
	
	@GetMapping("signup-form")
	public String signupForm() {
		
		
		return "member/signup-form";
	}
	
	@PostMapping("signup")
	public String join(MemberDTO member, HttpServletRequest request) {
		
	
		log.info("맴버 필드 찍어보기{}", member);
		memberService.signUp(member);
		return "main-page";
	}
	
	
	@GetMapping("my-page")
	public String myPage() {
		return "member/my-page";
	}
	
	@PostMapping("update-member")
	public void update(MemberDTO member ,HttpSession session) {
		
		
		/*
		 * 1)404 mapping값잘못적음
		 * 
		 * 2)405 앞단에서 post/get 으로 요청을 보내놓고 메서드와 맞지 않은 애노테이션을 사용했을때
		 * 
		 * 3) 필드에 값이 들어오지 않는 경우
		 * 
		 */
		log.info("사용자가 입력한 값: {}", member);
		/*
		 * 이번에 실행할 sql문을 생각
		 * updateans
		 * id,pw,name,email,date
		 * 2-1)매개변수 memberDTO타입의 memberId 필드값
		 * 2-2)sessionscopㄷ에 loginMember 키값에 meberId필드값 넘겨주어야 함
		 * 
		 * 수행성공시
		 * mypage로 이동 +갱신된 회원의 정보 출력
		 * 
		 * id를 가지고 다시 조회 => login 매서드 재활용
		 * 
		 * 수행실패시
		 * message에 담아서 error_page로 포워딩
		 * 예외발생 =>예외처리기로 위임
		 * 
		 */
		
		memberService.update(member, session);
	}
}
