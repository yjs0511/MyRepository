package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam04 {
	public static void main(String[] ar) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");	// jdbc 드라이버를 메모리에 로딩 -- forName() 은 해당 클래스를 메모리에 로딩해 준다
		// OracleDriver oracleDriver = new OracleDriver(); // 이렇게 사용 안 한다. 아래 코드가 드라이버가 메모리에 로딩 될 때 자동으로 실행된다. 정적블록에 저 코드가 잇다.
		
/*		Driver oracleDriver = new OracleDriver();
		DriverManager.registerDriver(oracleDriver);*/
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");	// 대여 반납 형태?
		// 매개변수화 된 SQL문
		// 부서명을 조건으로 해서 부서명 일부분을 입력했을 때
		// 부서가 존재할 경우 부서 번호, 부서이름을 출력하고
		// 부서가 존재하지 않을 경우에는 부서가 없음을 출력하시오. 
		String sql = "select deptno, dname from dept where dname like ? ";	// ? 자리에 어떤 값이 들어온다
		PreparedStatement pstmt = conn.prepareStatement(sql);	// conn.prepareStatement(sql) -- sql문을 실행 준비를 해라
																// PreparedStatement pstmt -- 준비된 객체
		pstmt.setString(1, "%개발%");	// sql문 안의 1번째 인덱스에 ?안의 값을 설정 -- ?안에 숫자가 들어가는 경우 반드시 setInt()를 사용해야 한다.	setString()을 사용하면 '' 이게 자동으로 들어가기 때문
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			do{
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				System.out.println(deptno +" : "+ dname);
			}while(rs.next());
		}else{
			System.out.println("부서가 없음");
		}
		
		rs.close();
		pstmt.close();
		conn.close();	// 귀중한 자원이라 쓰고나면 반드시 닫아줘야 한다.
	}
}