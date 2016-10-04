package com.mycompany.myapp.exam07;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam07")
public class Exam07Controller {
	@RequestMapping("/index")
	public String index(){
		
		return "/exam07/index";
	}
	
	@RequestMapping("/method1")
	public String method1(HttpServletRequest request){
		request.setAttribute("data1", "value1");	// 두번째 자리는 문자열 뿐만 아니라 멤버 객체, 다른 것 다 된다.
		request.setAttribute("data2", "value2");
		return "/exam07/usedata";
	}
	
	@RequestMapping("/method2")
	public String method2(HttpSession session){
		session.setAttribute("data1", "value1");
		session.setAttribute("data2", "value2");
		return "exam07/usedata";
	}
	
	@RequestMapping("/method3")		
	public String method3(Model model){		// 스프링에서 가장 많이 사용하는 형태(얘도 실제로는 HttpServletRequest 여기에 저장한다.)
		model.addAttribute("data1", "value1");
		model.addAttribute("data2", "value2");
		return "exam07/usedata";
	}
}
