package ch07.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch07.dto.Member;

public class MemberDao {

	public Member selectByMid(String mid) {
		Member member = null;
		String sql = "select * from member where mid=?"; 
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
			}
			
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	public List<Member> selectAll() {
		String sql = "select * from member"; 
		Connection conn = null;
		
		List<Member> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				conn.close();
			}catch(Exception e2){}
		}

		return list;
	}
}
