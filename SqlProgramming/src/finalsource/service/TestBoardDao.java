package finalsource.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import finalsource.dao.BoardDao;
import finalsource.dto.Board;

public class TestBoardDao {
	public static void main(String[] args){
		//testInsert();
		//testSelectByBno();
		//testSelectByBtitle();
		//testUpdate();
		//testDeleteByBno();
		testSelectByPage(2, 10);
	}
	
	private static void testSelectByPage(int pageNo, int rowsPerPage) {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			
			BoardDao dao = new BoardDao();
			dao.setConn(conn);
			List<Board> list = dao.selectByPage(pageNo, rowsPerPage);
			
			for(Board board : list){
				System.out.print(board.getBno() +" : ");
				System.out.print(board.getBtitle()+" : ");
				System.out.print(board.getBcontent()+" : ");
				System.out.print(board.getBhitcount()+" : ");
				System.out.print(board.getBwriter()+" : ");
				System.out.println(board.getBdate());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}

	public static void testDeleteByBno() {
		// TODO Auto-generated method stub
		
	}

	public static void testUpdate() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			
			BoardDao dao = new BoardDao();
			dao.setConn(conn);
			
			Board board = new Board();
			board.setBno(1);
			board.setBtitle("우리집");
			board.setBcontent("난방 안들어와 살려줘");
			board.setBhitcount(1);
			//board.setBwriter("아이언맨");
			board.setBdate(new Date());
			
			int rowNo = dao.update(board);
			System.out.println(rowNo+"개의 행 수정됨");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}

	public static void testSelectByBtitle() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			
			BoardDao dao = new BoardDao();
			dao.setConn(conn);
			List<Board> list = dao.selectByBtitle("오늘");
			
			for(Board board : list){
				System.out.println(board.getBno());
				System.out.println(board.getBtitle());
				System.out.println(board.getBcontent());
				System.out.println(board.getBhitcount());
				System.out.println(board.getBwriter());
				System.out.println(board.getBdate());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}

	public static void testSelectByBno() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			
			BoardDao dao = new BoardDao();
			dao.setConn(conn);
			
			Board board = dao.selectByBno(1);
			
			if(board != null){
				System.out.println(board.getBno());
				System.out.println(board.getBtitle());
				System.out.println(board.getBcontent());
				System.out.println(board.getBhitcount());
				System.out.println(board.getBwriter());
				System.out.println(board.getBdate());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {}
		}
		
	}

	public static void testInsert() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			BoardDao dao = new BoardDao();
			dao.setConn(conn);
			for(int i=0; i<10000; i++){
				Board board = new Board();
				board.setBtitle("테스트"+i);
				board.setBcontent("테스트"+i);
				board.setBwriter("user10");
				int rowNo = dao.insert(board);
				System.out.println(rowNo+"개 행 입력");
			}
		} catch (Exception e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	
}
