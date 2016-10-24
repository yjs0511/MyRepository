package ch08.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exam07 {
	public static void main(String[] args){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			
			// 트랜잭션 작업을 시작
			conn.setAutoCommit(false);
			
			// 출금 작업
			//String sql1 = "update account set abalance=abalance-? where ano=?";	// 연산식에는 ?를 사용할 수 없다. 잘못된 식
			String sql1 = "update account set abalance=abalance-10000 where ano='111-111'";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			int rowNum1 = pstmt1.executeUpdate();
			pstmt1.close();
			
			// 입금 작업
			String sql2 = "update account set abalance=abalance+10000 where ano='111-113'";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			int rowNum2 = pstmt2.executeUpdate();
			pstmt2.close();
			
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
