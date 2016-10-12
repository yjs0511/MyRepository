package com.mycompany.myapp.exam11.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam11.dao.Exam11MemberDao;
import com.mycompany.myapp.exam11.dto.Member;

@Component
public class Exam11MemberService {	// 똑같은 이름의 관리객체가 하나 더 있으면 등록이 안된다.
	private static final Logger logger = LoggerFactory.getLogger(Exam11MemberService.class);
	
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_MPASSWORD = 2;
	
	@Autowired
	private Exam11MemberDao memberDao;
	
	public void join(Member member){
		logger.info("join 처리");
		memberDao.insert(member);
	}
	
	public int login(String mid, String mpassword){
		logger.info("login 처리");
		Member member = memberDao.select(mid);
		if(member == null){		// mid 가 데이터베이스에 없다(id가 존재하지 않는다)
			return LOGIN_FAIL_MID;
		}else{
			if(member.getMpassword().equals(mpassword)){
				return LOGIN_SUCCESS;
			}else{
				return LOGIN_FAIL_MPASSWORD;
			}
		}
	}
	
	
}
