package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam05 {
	public static void main(String[] ar)  {
		/*Class.forName("oracle.jdbc.OracleDriver");	// jdbc 드라이버를 메모리에 로딩 -- forName() 은 해당 클래스를 메모리에 로딩해 준다
		Scanner sc = new Scanner(System.in);
		// OracleDriver oracleDriver = new OracleDriver(); // 이렇게 사용 안 한다. 아래 코드가 드라이버가 메모리에 로딩 될 때 자동으로 실행된다. 정적블록에 저 코드가 잇다.
		
		Driver oracleDriver = new OracleDriver();
		DriverManager.registerDriver(oracleDriver);
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "kosa12345");	// 대여 반납 형태?
		// 매개변수화 된 SQL문
		// 부서명을 조건으로 해서 부서명 일부분을 입력했을 때
		// 부서가 존재할 경우 부서 번호, 부서이름을 출력하고
		// 부서가 존재하지 않을 경우에는 부서가 없음을 출력하시오. 
		System.out.print("검색할 이름: ");
		String sql = "select * from employees where lower(first_name) like ";	// ? 자리에 어떤 값이 들어온다
		sql += "'%"+sc.nextLine()+"%'";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);	// conn.prepareStatement(sql) -- sql문을 실행 준비를 해라
																// PreparedStatement pstmt -- 준비된 객체
		//pstmt.setString(1, "% %");	// sql문 안의 1번째 인덱스에 ?안의 값을 설정 -- ?안에 숫자가 들어가는 경우 반드시 setInt()를 사용해야 한다.	setString()을 사용하면 '' 이게 자동으로 들어가기 때문
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			int employee_id = rs.getInt("employee_id");
			String first_name = rs.getString("first_name");
			System.out.println(employee_id +" : " + first_name);
			
		}
		
		rs.close();
		pstmt.close();
		conn.close();	// 귀중한 자원이라 쓰고나면 반드시 닫아줘야 한다.
*/
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("검색할 이름: ");
			String name = sc.nextLine();

			List<Employee> result = getList(name);
			for(Employee emp : result){
				System.out.println(emp.getEmpno() + " : " + emp.getEname());
			}
		}
		
	}
	
	public static List<Employee> getList(String searchName){
		List<Employee> list = new ArrayList<>();
		
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select * from emp where ename like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+searchName+"%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt("empno"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setJob(rs.getString("job"));
				emp.setSal(rs.getDouble("sal"));
				list.add(emp);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e){
			try {	conn.close();	} catch (SQLException e2) {}
			e.printStackTrace();
		}
		
		return list;
	}
}