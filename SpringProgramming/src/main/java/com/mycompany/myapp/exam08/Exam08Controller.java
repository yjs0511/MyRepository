package com.mycompany.myapp.exam08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/exam08")
@Controller
public class Exam08Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam08Controller.class);

	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam08/index";
	}
	
	@RequestMapping("/join")
	public String join(){
		logger.info("join 처리");
		return "redirect:/exam08/index";
	} 
	
	@RequestMapping("/write")
	public String write(){
		logger.info("write 처리");
		return "redirect:/exam08/list";
	}
	
	@RequestMapping("/list")
	public String list(){
		logger.info("list 처리");
		return "exam08/list";
	}
}
