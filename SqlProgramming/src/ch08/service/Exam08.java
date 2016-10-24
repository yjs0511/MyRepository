package ch08.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dao.AccountDao;
import ch08.dto.Account;

public class Exam08 {
	public static void main(String[] args){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			
			// 트랜잭션 작업을 시작
			conn.setAutoCommit(false);
			
			AccountDao accountDao = new AccountDao();
			accountDao.setConn(conn);
			
			// 작업1
			Account account1 = new Account();
			account1.setAno("111-111");
			account1.setAbalance(500000);
			int rowNum1 = accountDao.update(account1);
			
			// 작업2
			Account account2 = new Account();
			account2.setAno("111-113");
			account2.setAbalance(200000);
			int rowNum2 = accountDao.update(account2);
			
			// 작업 확인
			if(rowNum1 == 1 && rowNum2 == 1){
				conn.commit();
				System.out.println("계좌이체 성공함");
			}else{
				conn.rollback();
				System.out.println("계좌가 존재하지 않아서 계좌이체 실패함");
			}

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("예외가 발생하여 계좌이체 실패함");
			}
		} finally{
			try {
				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {}
		}
	}
}
