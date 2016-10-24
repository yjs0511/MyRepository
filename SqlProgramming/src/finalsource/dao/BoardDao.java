package finalsource.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import finalsource.dto.Board;

public class BoardDao {
	
	private Connection conn;
	
	public void setConn(Connection conn){
		this.conn = conn;
	}
	
	public int insert(Board board) throws SQLException{
		String sql = "insert into board(bno, btitle, bcontent, bhitcount, bdate, bwriter) values(seq_board_bno.nextval, ?, ?, 0, sysdate, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getBtitle());
		pstmt.setString(2, board.getBcontent());
		pstmt.setString(3, board.getBwriter());
		
		int rowNo = pstmt.executeUpdate();
		
		pstmt.close();
		return rowNo;
	}
	
	public Board selectByBno(int bno) throws SQLException{
		String sql = "select bno, btitle, bcontent, bhitcount, bdate, bwriter from board where bno=?";
		Board board = null;
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBhitcount(rs.getInt("bhitcount"));
			board.setBdate(rs.getDate("bdate"));
			board.setBwriter(rs.getString("bwriter"));

		}
		pstmt.close();
		return board;
	}
	
	public List<Board> selectByBtitle(String btitle) throws SQLException{
		String sql = "select bno, btitle, bcontent, bhitcount, bdate, bwriter from board where btitle like ?";
		List<Board> list = new ArrayList<>();;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+btitle+"%");
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			Board board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBhitcount(rs.getInt("bhitcount"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBdate(rs.getDate("bdate"));
			list.add(board);
		}
		pstmt.close();
		return list;
	}
	
	public int update(Board board) throws SQLException{
		String sql = "update board set btitle=?, bcontent=?, bhitcount=?, bdate=? where bno=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getBtitle());
		pstmt.setString(2, board.getBcontent());
		pstmt.setInt(3, board.getBhitcount());
		pstmt.setDate(4, new Date(board.getBdate().getTime()));
		//pstmt.setString(5, board.getBwriter());
		pstmt.setInt(5, board.getBno());
		
		int rowNo = pstmt.executeUpdate();
				
		pstmt.close();
		return rowNo;
	}
	
	public int deleteByBno(int bno) throws SQLException{
		String sql = "delete board where bno=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		
		return rowNo;
	}
	
	public List<Board> selectByPage(int pageNo, int rowsPerPage) throws SQLException{
		String sql = "select rn, bno, btitle, bcontent, bhitcount, bwriter, bdate "; 
				sql+="from ( ";
				sql += "select rownum as rn, bno, btitle, bcontent, bhitcount, bwriter, bdate ";
				sql+=" from (select bno, btitle, bcontent, bhitcount, bwriter, bdate from board order by bno desc) ";
				sql+= "where rownum<=? ";
				sql += ") ";
				sql += "where rn>=? ";
				
		List<Board> list = new ArrayList<>();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pageNo*rowsPerPage);
		pstmt.setInt(2, (pageNo-1)*rowsPerPage+1);
		ResultSet rs = pstmt.executeQuery();
		

		
		while(rs.next()){
			Board board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBhitcount(rs.getInt("bhitcount"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBdate(rs.getDate("bdate"));
			list.add(board);
		}
		
		rs.close();
		pstmt.close();
		return list;
	}
	
}
