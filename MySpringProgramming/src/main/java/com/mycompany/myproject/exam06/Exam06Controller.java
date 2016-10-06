package com.mycompany.myproject.exam06;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	@RequestMapping("/method2")
	public void method2(HttpServletResponse response, HttpServletRequest request) throws IOException{
		response.setContentType("image/jpeg");
		String fileName = "사진2.jpg";
		fileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"" +fileName + "\"");
		
		OutputStream os = response.getOutputStream();
		String filePath = request.getServletContext().getRealPath("/WEB-INF/image/사진2.jpg");
		InputStream is = new FileInputStream(filePath);
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		while((byteNum = is.read(values)) != -1){
			os.write(values, 0, byteNum);
		}
		os.flush();
		is.close();
		os.close();
	}
	
	@RequestMapping("/method3")
	public String method3(@RequestHeader("User-Agent") String userAgent){
		if(userAgent.contains("Chrome")){
			logger.info("브라우저 종류 : 크롬");
		}else if(userAgent.contains("Trident/7.0")){
			logger.info("브라우저 종류 : 인터넷 익스플로러 11");
		}else if(userAgent.contains("MSIE")){
			logger.info("브라우저 종류 : 인터넷 익스플로러 10 이하");
		}
		return "exam06/index";
	}
	
	@RequestMapping("/method4CreateCookie")
	public String method4CreateCookie(HttpServletResponse response) throws UnsupportedEncodingException{
		Cookie cookie1 = new Cookie("mid", "fall");
		
		String name = "홍길동";
		name = URLEncoder.encode(name, "UTF-8");
		
		Cookie cookie2 = new Cookie("mname", name);
		cookie2.setMaxAge(60);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		return "exam06/index";
	}
	
	@RequestMapping("/method4ReceiveCookieHow1")
	public String method4ReceiveCookieHow1(HttpServletRequest request) throws UnsupportedEncodingException{
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				String name = cookie.getName();
				String value = null;
				if(name.equals("mname")){
					value = URLDecoder.decode(cookie.getValue(), "UTF-8");
				}else{
					value = cookie.getValue();
				}
			}
		}
		return "exam06/index";
	}
	
	@RequestMapping("/method4ReceiveCookieHow2")
	public String method4ReceiveCookieHow2(@CookieValue(value="mid", defaultValue="") String mid, @CookieValue(defaultValue="") String mname){
		
		System.out.println("mid : " + mid);
		System.out.println("mname : " + mname);
		
		return "exam06/index";
	}
	
	@RequestMapping("/method4DeleteCookie")
	public String method4DeleteCookie(HttpServletResponse response){
		Cookie cookie1 = new Cookie("mid", "");
		cookie1.setMaxAge(0);
		return "exam06/index";
	}
	
	@RequestMapping("/method5GetObject")
	public String method5GetObject(HttpSession session){
		Member member = (Member) session.getAttribute("member");
		if(member != null){
			System.out.println("mid : "+ member.getMid());
			System.out.println("mname : " + member.getMname());
		}
		return "exam06/index";
	}
	
	@RequestMapping("/method5RemoveObject")
	public String method5RemoveObject(HttpSession session){
		session.removeAttribute("member");
		return "exam06/index";
	}
	
	
	
	
	
	
	
	
	
	
}
