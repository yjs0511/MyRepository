package ch08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Account;

public class AccountDao {
	private Connection conn;

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public int update(Account account) throws SQLException{
		String sql = "update account set abalance=? where ano=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);	// try~catch문으로 예외 처리를 하면 안된다. throws를 사용해야 한다.
																// 여기서 예외를 잡아 버리면 이 메소드는 절대로 예외가 발생하지 않는다.
																// 그렇게 되면 Exam08에서 rollback이 어떤 경우에도 실행되지 않게 된다.
																// Dao 에는 Connection을 연결하는 코드를 넣으면 안된다. - 여기서는 이미 연결이 됬다고 가정한다
		pstmt.setInt(1, account.getAbalance());
		pstmt.setString(2, account.getAno());
		int lowNum = pstmt.executeUpdate();
		return lowNum;	// 몇개의 행이 수정됬는지 알 수 있도록 lowNum을 리턴한다.
	}
}
