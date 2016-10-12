package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C {
	private static final Logger logger = LoggerFactory.getLogger(C.class);

	private D d;	//C는 D를 의존한다
	
	public C(D d){
		this.d = d;
		logger.info("C 객체 생성");
	}
	
	public void method(){
		logger.info("method 실행");
		d.method();
	}
}
