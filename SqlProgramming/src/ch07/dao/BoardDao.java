package ch07.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch07.dto.Board;

public class BoardDao {

	public Board selectByBno(int bno){
		Board board = null;
		Connection conn = null;
		String sql = "select * from board where bno=?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		return board;
	}

	public List<Board> selectAll() {
		List<Board> list = new ArrayList<>();
		Connection conn = null;
		
		String sql = "select * from board";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		
		return list;
	}

}
