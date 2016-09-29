package com.mycompany.myapp.exam02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam02Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam02/index";
	}
	
	/*@RequestMapping("/join")
	public String join(String mid, String mname, String mage){
		logger.info("join요청 처리");
		logger.info("mid: "+mid);
		logger.info("mname: "+mname);
		logger.info("mage: "+mage);
		
		return "exam02/index";
	}*/  //이 경우보다
	
	// 변수가 많은 경우 객체로 만드는 것이 낫다
	@RequestMapping("/join")
	public String join(Member member){
		logger.info("join요청 처리");
		logger.info("mid: "+member.getMid());
		logger.info("mname: "+member.getMname());
		logger.info("mage: "+member.getMage());
		
		return "exam02/index";
	}
	
	@RequestMapping("/login")
	public String login(
		@RequestParam("id") String mid,
		@RequestParam("password") String mpassword){
			
		logger.info("login요청 처리");
		logger.info("id: "+mid);
		logger.info("password: "+mpassword);
		
		return "exam02/index";
	}
	
	@RequestMapping("/order")
	public String order(
		@RequestParam("pid") String pid,
		@RequestParam("pname") String pname,
		@RequestParam("pprice") String pprice,
		@RequestParam("pcompany") String pcompany){
			
		logger.info("order요청 처리");
		logger.info("pid: "+pid);
		logger.info("pname: "+pname);
		logger.info("pprice: "+pprice);
		logger.info("pcompany: "+pcompany);
		
		return "exam02/index";
	}
	
	@RequestMapping("/writer")
	public String writer(
			@RequestParam(defaultValue="1")int bno, 
			String title, String content, 
			@RequestParam(defaultValue="0") int hitCount){
		// 원래는 스프링 프레임워크가 자동으로 int로 바꿔주지만 바꿔줄 값 자체가 없을 경우 디폴트 값을 줄 수 있다. 기본값을 1로 지정
		// 요청 파라미터 값이 넘어오지 않았을 때만 디폴트 값이 넘어옴
		logger.info("writer 요청 처리");
		logger.info("bno: "+bno);
		logger.info("title: "+title);
		logger.info("content: "+content);
		logger.info("hitCount: "+hitCount);
		return "exam02/index";
	}
	
	@RequestMapping("/update")
	public String update(
			@RequestParam(defaultValue="1")int bno, 
			String title, String content, 
			@RequestParam(value="count", defaultValue="0") int hitCount){
			//@RequestParam 어노테이션은 원래 변수이름과 요청 파라미터 이름이 다를 경우 매칭 시키는 역할을 한다 value="count" 처럼
			//다만 'value=' 이부분을 생략해서 사용할 수 있다(위의 경우를 제외하고) 요청 파라미터 값이 없을 경우 디폴트 값이 들어간다.(설정했을 경우만)
		// null을 int로 못 바꾸기 때문에 기본값을 1로 지정
		// 요청 파라미터 값이 넘어오지 않았을 때만 디폴트 값이 넘어옴
		logger.info("update 요청 처리");
		logger.info("bno: "+bno);
		logger.info("title: "+title);
		logger.info("content: "+content);
		logger.info("hitCount: "+hitCount);
		return "exam02/index";
	}
	
	@RequestMapping("/send")
	public String send(Board board){
		// Board 객체의 파라미터 값이 들어간다.
		logger.info("send 요청 처리");
		logger.info("bno: "+board.getBno());
		logger.info("title: "+board.getTitle());
		logger.info("content: "+board.getContent());
		logger.info("hitCount: "+board.getHitcount());
		return "exam02/index";
	}
}
