package com.mycompany.myapp.exam06;

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
		logger.info("요청 URI: "+request.getRequestURI());	//포트를 제외한 주소
		logger.info("요청 URL: "+request.getRequestURL());	//포트를 포함한 전체 주소
		logger.info("요청 방식: "+request.getMethod());
		logger.info("시스템 파일 경로: "+request.getRealPath("WEB-INF/image/photo1.jpg"));	// 결과 값은 같지만 이렇게 쓰지 말아달라
		logger.info("시스템 파일 경로: "+request.getServletContext().getRealPath("WEB-INF/image/photo1.jpg"));
		return "exam06/index";
	}
	
	@RequestMapping("/method2")
	public void method2(HttpServletResponse response, HttpServletRequest request) throws IOException{	// JSP로 결과 출력하지 않고 직접 데이터를 보낼 경우 void 사용
		/*response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("{mid:'fall', mname:'한가을'}");
		pw.flush();	// response 객체는 1회성 객체이기 때문에 flush나 close를 하지 않아도 자동으로 같은 효과가 생긴다.
		pw.close();*/
		
		
		response.setContentType("image/jpeg");
		String fileName = "사진2.jpg";
		fileName = URLEncoder.encode(fileName, "UTF-8");	// 한글에 대한 유니코드로 받아서 16진수로 변환
		response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName +"\"");	//파일 첨부(다운로드) 기능 및 이름 지정
																								// \" \" 파일 이름이 어디 까지다 라는 걸 지정
																								// 사진 이름을 한글로 정하려면 윗 라인의 utf-8로 변환하는 과정이 필요
		
		OutputStream os = response.getOutputStream();
		
		String filePath = request.getServletContext().getRealPath("/WEB-INF/image/사진2.jpg"); // Context 위치를 기준으로 그 아래 경로를 지정
		InputStream is = new FileInputStream(filePath);
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		while((byteNum = is.read(values))!= -1){
			os.write(values, 0, byteNum);
		}
		os.flush();
		is.close();
		os.close();
	}
	
	@RequestMapping("/method3")
	public String method3(@RequestHeader("User-Agent") String userAgent){	//요청 http의 User-Header 값을 지정
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
		//쿠키 생성
		Cookie cookie1 = new Cookie("mid", "fall");
		
		String name = "홍길동";
		name = URLEncoder.encode(name, "UTF-8");
		
		Cookie cookie2 = new Cookie("mname", name);
		cookie2.setMaxAge(60); // 단위는 초 단위
		
		//쿠키 보내기
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		return "exam06/index";
	}
	
	@RequestMapping("/method4ReceiveCookieHow1")
	public String method4ReceiveCookieHow1(HttpServletRequest request) throws UnsupportedEncodingException{
		//원래 방법 - JSP 만 쓸 때
		//쿠키 받기 - 요청 헤더의 쿠키 정보를 읽기 작업
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
				System.out.println(name + ":" + value ); // 두 개의 쿠키를 저장했다면 최소한 두 개 이상의 쿠키가 날아올거다(이전에 만든 쿠키가 있을지도 모르니까)
			}
		}
		
		return "exam06/index";
	}
	
	@RequestMapping("/method4ReceiveCookieHow2")
	public String method4ReceiveCookieHow2(@CookieValue(value="mid", defaultValue="") String mid, @CookieValue(defaultValue="") String mname){ // 저런 이름으로 클라이언트에서 넘어오면 매핑 시켜 주겠다
											// default 값을 지정하지 않으면 쿠키가 넘어오지 않을 시 에러가 발생하므로 디폴트 값을 지정한다.
		System.out.println("mid : " + mid);
		System.out.println("mname : " + mname);
		
		return "exam06/index";
	}
	
	@RequestMapping("/method4DeleteCookie")
	public String method4DeleteCookie(HttpServletResponse response){ // 저런 이름으로 클라이언트에서 넘어오면 매핑 시켜 주겠다
		Cookie cookie1 = new Cookie("mid", "");
		cookie1.setMaxAge(0);	//삭제와 같은 효과가 일어난다.
		
		Cookie cookie2 = new Cookie("mname", "");
		cookie2.setMaxAge(0);	
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		return "exam06/index";
	}
	
	@RequestMapping("/method5SetObject")
	public String method05SetObject(HttpSession session){
		// 객체 생성
		Member member = new Member("fall" , "한가을");
		
		// HttpSession에 객체 저장
		session.setAttribute("member", member); //키(left)와 객체(right)를 줌
		
		return "exam06/index";
	}
	
	@RequestMapping("/method5GetObject")
	public String method05GetObject(HttpSession session){
		// HttpSession에서 객체 얻기
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
