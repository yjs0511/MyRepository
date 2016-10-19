package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam03 {
	public static void main(String[] ar) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");	// jdbc 드라이버를 메모리에 로딩 -- forName() 은 해당 클래스를 메모리에 로딩해 준다
		// OracleDriver oracleDriver = new OracleDriver(); // 이렇게 사용 안 한다. 아래 코드가 드라이버가 메모리에 로딩 될 때 자동으로 실행된다. 정적블록에 저 코드가 잇다.
		
/*		Driver oracleDriver = new OracleDriver();
		DriverManager.registerDriver(oracleDriver);*/
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");	// 대여 반납 형태?
		// 매개변수화 된 SQL문
		String sql = "select empno, ename, (sal*12+nvl(comm,0)) as yearsal from emp ";	// ? 자리에 어떤 값이 들어온다
		sql+="where sal>? and deptno=? ";
		sql+="order by yearsal desc";
		PreparedStatement pstmt = conn.prepareStatement(sql);	// conn.prepareStatement(sql) -- sql문을 실행 준비를 해라
																// PreparedStatement pstmt -- 준비된 객체
		pstmt.setInt(1, 400);	// sql문 안의 1번째 인덱스에 ?안의 값을 설정 -- ?안에 숫자가 들어가는 경우 반드시 setInt()를 사용해야 한다.	setString()을 사용하면 '' 이게 자동으로 들어가기 때문
		pstmt.setInt(2, 30);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){	// 결과셋의 커서가 before first 행에 있기 때문에 개행해줘야 한다 -- 첫번 째 행보다 앞의 행
			int empno = rs.getInt("empno");	// 매개값으로 인덱스 값을 줘도 되고 컬럼명을 줘도 된다.
										// 숫자로 주면 결과셋의 입력한 숫자번 째 컬럼이 값으로 들어간다.
			String ename = rs.getString("ename");
			int yearsal = rs.getInt("yearsal");
			System.out.println(empno + " : " + ename+ " : " +yearsal);
		}	// 마지막 행이 끝나면 커서가 after last 행으로 간다	-- 마지막 행보다 뒤의 행
		
		rs.close();
		pstmt.close();
		conn.close();	// 귀중한 자원이라 쓰고나면 반드시 닫아줘야 한다.
	}
}
