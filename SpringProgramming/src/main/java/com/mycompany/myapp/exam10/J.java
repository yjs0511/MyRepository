package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class J {
	private static final Logger logger = LoggerFactory.getLogger(J.class);
	
	private H h;
	private G g;
	
	@Autowired	// 생성자에도 이걸 붙일 수 있다.
	public J(H h, G g){
		logger.info("J 객체 생성");
		this.h = h;
	}
	
	public void method(){
		logger.info("method 실행");
		h.method();
	}

}
