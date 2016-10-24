package com.mycompany.myapp.exam12.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam12.dao.MemberDao;
import com.mycompany.myapp.exam12.dto.Member;

@Component
public class Exam12Service {
	private static final Logger logger = LoggerFactory.getLogger(Exam12Service.class);
	@Autowired
	private DataSource dataSource;	// Connection 사용 방법 (인터페이스)
	
	@Autowired
	private MemberDao dao; //서비스나 dao는 주입 받는게 좋다 (여러 곳에서 쓰일 때)
	
	public void join(Member member) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();	// Connection 대여
			dao.setConn(conn);
						
			int rowNo = dao.insert(member);
			logger.info(rowNo + "행이 저장됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();	// Connection 반납 (DataSource로부터 받아왔을 때는 연결을 끊는다는 의미가 아니다)
			} catch (SQLException e) {}
		}
	}
}
