package com.mycompany.myapp.exam10;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam10")
public class Exam10Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam10Controller.class);
	
	private G g;
	
	@Autowired	// 자동으로 연결시키겠다. 스프링(DI 컨테이너)의 관리 객체 중에서 G가 있으면 자동으로 대입하겠다
	public void setG(G g){
		logger.info("setG() 실행");
		this.g = g;
	}
	
	private H h;
	
	@Autowired
	public void setH(H h){
		logger.info("setH() 실행");
		this.h = h;
	}
	
	private Service service;
	
	/*@Autowired*/		// 이 어노테이션의 특징은 단 하나의 인터페이스 구현 객체만 주입할 수 있다. 두 개 이상인 경우 예외 발생 => Type으로 주입
	//@Resource --> 등록 이름으로 주입
	@Resource(name="serviceImpl2")
	public void setService(Service service){
		logger.info("setService() 실행");
		this.service = service;
	}
	
	private I i;
	@Autowired
	public void setI(I i){
		logger.info("setI() 실행");
		this.i = i;
	}
	
	private J j;
	@Autowired
	public void setJ(J j){
		logger.info("setJ() 실행");
		this.j = j;
	}
	
	@Autowired		// setter 뿐 아니라 필드에만 붙여도 주입할 수 있다.
	private K k;
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam10/index";
	}
	
	@RequestMapping("/method1")
	public String method1(){
		logger.info("method1 처리");
		g.method();
		h.method();
		service.method();
		return "redirect:/exam10/index";
	}
	
	@RequestMapping("/method2")
	public String method2(){
		logger.info("method2 처리");
		i.method();
		j.method();
		return "redirect:/exam10/index";
	}
	
	@RequestMapping("/method3")
	public String method3(){
		logger.info("method3 처리");
		k.method();
		return "redirect:/exam10/index";
	}
}
