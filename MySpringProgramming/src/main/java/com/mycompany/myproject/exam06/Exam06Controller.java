package com.mycompany.myproject.exam06;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam06")
public class Exam06Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam06Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam06/index";
	}
	
	@RequestMapping("/method1")
	public String method1(HttpServletRequest request){
		logger.info("method1 요청 처리");
		
		//클라이언트의 아이피 얻기
		logger.info("WebClient IP : "+ request.getRemoteAddr());
		
		//클아이언트의 브라우저 종류
		logger.info("브라우저 종류 : "+ request.getHeader("User-Agent"));
		
		return "exam06/index";
	}
}
