package com.mycompany.myapp.exam06;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/exam06")
@Controller
public class Exam06Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam06Controller.class);

	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam06/index";
	}
	
	@RequestMapping("/method1")
	public String method1(HttpServletRequest request){	// 요청 HTTP에 대한 모든 내용이 담겨 있
		logger.info("method1 요청 처리");
		//클라이언트의 IP 얻기
		logger.info("WebClient IP : "+ request.getRemoteAddr());
		//클라이언트의 브라우저 종류
		logger.info("WebClient 종류 : "+ request.getHeader("User-Agent"));
		if(request.getHeader("User-Agent").contains("Chrome")){
			System.out.println("브라우저 종류 : 크롬");
		}else if(request.getHeader("User-Agent").contains("Trident/7.0")){
			System.out.println("브라우저 종류 : 인터넷 익스플로러 11");
		}else if(request.getHeader("User-Agent").contains("MSIE")){
			System.out.println("브라우저 종류 : 인터넷 익스플로러 10 이하");

		}
		//요청 파라미터 값 얻기
		logger.info("mid: "+request.getParameter("mid"));
		logger.info("mname: "+request.getParameter("mname"));
		logger.info("쿼리 문자열: "+request.getQueryString());
		logger.info("요청 URI: "+request.getRequestURI());
		logger.info("요청 URL: "+request.getRequestURL());
		logger.info("요청 방식: "+request.getMethod());
		logger.info("시스템 파일 경로: "+request.getServletContext().getRealPath("WEB-INF/image/photo1.jpg"));
		return "exam06/index";
	}
}
