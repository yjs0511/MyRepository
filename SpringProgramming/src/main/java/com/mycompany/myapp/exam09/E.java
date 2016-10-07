package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class E {
	private static final Logger logger = LoggerFactory.getLogger(E.class);
	
	private B b;
	
	private D d;
	
	public E(B b, D d){		//E는 B와 D에 의존한다.	(B, D는 E의 의존 객체)
		logger.info("E 객체 생성");
		this.b = b;
		this.d = d;
	}
	
	public void method(){
		logger.info("method 실행");
		b.method();
		d.method();
	}

}
