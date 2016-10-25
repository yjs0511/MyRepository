package com.mycompany.myapp.exam13.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.exam13.dto.Member;
import com.mycompany.myapp.exam13.service.Exam13MemberService;

@Controller
@RequestMapping("/exam13")
public class Exam13Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam13Controller.class);
	
	@Autowired
	private Exam13MemberService exam13memberService;
	
	@RequestMapping("index")
	public String index(){
		logger.info("index 처리");
		return "exam13/index";
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.GET)
	public String joinForm(){
		logger.info("memberJoinForm 처리");	
		return "exam13/memberJoinForm";
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST)
	public String join(Member member){
		logger.info("memberJoin 처리");
		exam13memberService.join(member);
		return "redirect:/exam13/index";
	}
	
	@RequestMapping("/memberInfo")
	public String memberInfo(String mid, Model model){
		logger.info("memberInfo 처리");
		Member member = exam13memberService.info(mid);
		model.addAttribute("member", member);	// jsp에 member를 전달하기 위해 Model 객체 사용
		return "exam13/memberInfo";
	}
}
