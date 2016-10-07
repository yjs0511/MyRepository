package com.mycompany.myproject.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceCImpl implements ServiceC{
	private static final Logger logger = LoggerFactory.getLogger(ServiceCImpl.class);

	
	public ServiceCImpl(){
		logger.info("ServiceCImpl 객체 생성");
	}

	@Override
	public void method() {
		logger.info("method 실행");
	}

}
