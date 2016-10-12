package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component		// 같은 인터페이스를 구현한 객체가 두개가 있다면 무엇을 주입할지 판단할 수 없다
public class ServiceImpl2 implements Service{

	private static final Logger logger = LoggerFactory.getLogger(ServiceImpl2.class);

	public ServiceImpl2(){
		logger.info("ServiceImpl2 객체 생성");
	}
	
	@Override
	public void method() {
		logger.info("method 실행");
	}

}
