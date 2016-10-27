package com.mycompany.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.Member;
import com.mycompany.myweb.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "member/loginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String mid, String mpassword, HttpSession session, Model model) {
		int result = memberService.login(mid, mpassword);
		if (result == MemberService.LOGIN_FAIL_MPASSWORD) {
			model.addAttribute("error", "LOGIN_FAIL_MPASSWORD");
			return "member/loginForm";
		} else if (result == MemberService.LOGIN_FAIL_MID) {
			model.addAttribute("error", "LOGIN_FAIL_MID");
			return "member/loginForm";
		} else {
			session.setAttribute("login", mid);
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/findMid", method = RequestMethod.GET)
	public String findMidForm() {
		return "member/findMidForm";
	}

	@RequestMapping(value = "/findMid", method = RequestMethod.POST)
	public String findMid(String memail, Model model, HttpSession session) {
		String mid = memberService.findMid(memail);
		if (mid == null) {
			model.addAttribute("error", "이메일이 존재하지 않음");
			return "member/findMidForm";
		}
		session.setAttribute("findMid", mid);
		return "redirect:/member/login";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm() {
		return "member/joinForm";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Member member) {		// 스프링은 기본적으로 매개변수 타입의 첫자를 소문자로 바꿔서 request에 저장한다. (Member -> member)  
		try {								// 따라서 Model model을 매개변수로 받아와 setAttriubute("member", member) 이렇게 할 필요가 없다.	
			int result = memberService.join(member);
			return "redirect:/member/login";
				
		} catch (Exception e) {
			return "member/joinForm";
		}

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		String mid = (String) session.getAttribute("login");
		int result = memberService.logout(mid);
		if (result == MemberService.LOGOUT_SUCCESS) {
			session.removeAttribute("login");
		}
		return "redirect:/";
	}

	@RequestMapping("info")
	public String info(String mpassword, HttpSession session, Model model) {
		String mid = (String) session.getAttribute("login");
		Member member = memberService.info(mid, mpassword);
		model.addAttribute("member", member); // request에 저장
		return "member/info";
	}
}
