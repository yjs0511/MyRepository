package com.mycompany.myproject.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceDImpl implements ServiceD{
	private static final Logger logger = LoggerFactory.getLogger(ServiceDImpl.class);

	
	public ServiceDImpl(){
		logger.info("ServiceDImpl 객체 생성");
	}

	@Override
	public void method() {
		logger.info("method 실행");
	}

}
