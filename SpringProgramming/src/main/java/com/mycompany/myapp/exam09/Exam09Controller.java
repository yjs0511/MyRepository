package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam09")
public class Exam09Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam09Controller.class);
	
	private A a;
	public void setA(A a){
		this.a = a;
		logger.info("setA() 실행");
	}
	
	private B b;
	
	public void setB(B b) {
		this.b = b;
		logger.info("setB() 실행");
	}
	
	private ServiceA serviceA;
	
	public void setServiceA(ServiceA serviceA) {
		this.serviceA = serviceA;
		logger.info("setServiceA() 실행");
	}
	
	private ServiceB serviceB;
	
	public void setServiceB(ServiceB serviceB) {
		this.serviceB = serviceB;
		logger.info("setServiceB() 실행");
	}
	
	private ServiceC serviceC;
	
	public void setServiceC(ServiceC serviceC) {
		logger.info("setServiceC() 실행");
		this.serviceC = serviceC;
	}
	
	private ServiceD serviceD;
	
	public void setServiceD(ServiceD serviceD) {
		logger.info("setServiceD() 실행");
		this.serviceD = serviceD;
	}
	
	private C c;
	public void setC(C c){
		logger.info("setC() 실행");
		this.c = c;
	}

	/*public Exam09Controller(C c){	// 스프링에선 기본 생성자만 가지고 객체를 만든다.	-> 생성자가 매개변수를 받게되면 예외가 발생한다
	 * 									컨트롤러에선 기본 생성자를 만들지 못한다. 세터 주입만 가능
		logger.info("Exam09Controller 객체 생성");
		this.c = c;	
	}*/
	
	private E e;
	public void setE(E e) {
		this.e = e;
		logger.info("setE() 실행");
	}
	
	private F f;
	public void setF(F f){
		this.f = f;
		logger.info("setF() 실행");
	}

	public Exam09Controller(){	
		logger.info("Exam09Controller 객체 생성");
	}
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam09/index";
	}
	
	@RequestMapping("/method1")
	public String method1(){
		logger.info("method1 처리");
		a.method();
		b.method();
		serviceA.method();
		serviceB.method();
		serviceC.method();
		serviceD.method();
		return "redirect:/exam09/index";
	}
	
	@RequestMapping("/method2")
	public String method2(){
		logger.info("method2 처리");

		c.method();
		e.method();
		f.method();
		return "redirect:/exam09/index";
	}
}
