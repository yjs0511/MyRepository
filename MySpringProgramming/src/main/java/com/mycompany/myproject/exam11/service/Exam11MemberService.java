package com.mycompany.myproject.exam11.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Exam11MemberService {
	private static final Logger logger = LoggerFactory.getLogger(Exam11MemberService.class);
	
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAIL_MID = 0;
	public static final int LOGIN_FAIL_MPASSWORD = 0;
	
}
