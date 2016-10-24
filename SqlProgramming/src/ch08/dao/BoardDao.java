package ch08.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Board;
import ch08.service.ConnectionHelper;

public class BoardDao {

	public void insert(Board board) {
		Connection conn = null;
		
		try {
			String sql = "insert into board(bno, btitle, bcontent, bwriter, bhitcount, bdate) values(?, ?, ?, ?, ?, ?)";
			
			conn = ConnectionHelper.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontent());
			pstmt.setString(4, board.getBwriter());
			pstmt.setInt(5, board.getBhitcount());
			pstmt.setDate(6, new Date(board.getBdate().getTime()));
			int rowNo = pstmt.executeUpdate();
			
			if(rowNo == 1){
				System.out.println("행 입력 성공");
			}
			
		} catch (Exception e) {
			System.out.println("행 입력 실패");
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}

	public void update(Board board) {
		String sql = "update board set BTITLE=?, BCONTENT=?, BWRITER=?, BDATE=? where BNO=?";
		  
		Connection conn = null;
		try{
			conn = ConnectionHelper.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			pstmt.setDate(4, new Date(board.getBdate().getTime()));
			pstmt.setInt(5, board.getBno());
			
			int rowNo = pstmt.executeUpdate();
			
			if(rowNo >= 1){
				System.out.println(rowNo+"개 행 수정");
			}else if(rowNo == 0){
				System.out.println("수정할 행 없음");
			}
			pstmt.close();
		}catch(Exception e){
			System.out.println("수정 실패");
		} finally{
			try {
				conn.close();
				
			} catch (SQLException e) {}
		}
	}
	
}
