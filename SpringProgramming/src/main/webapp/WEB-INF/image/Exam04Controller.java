package com.mycompany.myapp.exam04;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/exam04")
@Controller
public class Exam04Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam04Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam04/index";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)	//아래와 같은 URL 요청이지만 전송 방식을 달리하면 실행해 주겠다
	public String joinForm(){
		logger.info("joinForm 요청 처리");
		return "exam04/joinform";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Member member){
		logger.info("join 요청 처리");
		logger.info("mid: "+member.getMid());
		
		String name = member.getMname();
		try {
			name = new String(name.getBytes(), "UTF-8");
		} catch (UnsupportedEncodingException e) {}
		
		logger.info("mname: "+name);
		logger.info("mpassword: "+member.getMpassword());
		logger.info("email: "+member.getEmail());
		logger.info("mtel: "+member.getMtel());
		logger.info("mjob: "+member.getMjob());
		logger.info("mskill: "+Arrays.toString(member.getMskill()));
		logger.info("maddress1: "+member.getMaddress1());
		logger.info("maddress2: "+member.getMaddress2());
		logger.info("mbirth: "+member.getMbirth());
		return "exam04/index";
	}
	
	@RequestMapping("/board")
	public String board(){
		logger.info("board 요청 처리");
		return "exam04/board";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm(){
		logger.info("writeform 요청 처리");
		return "exam04/writeform";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String board(Board btitle, String bcontent){
		logger.info("write 요청 처리");
		logger.info("btitle: "+ btitle);
		logger.info("bcontet: "+bcontent);

		return "exam04/index";
	}
}
