package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam06 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("사원번호 입력: ");
		int searchEmpno = Integer.parseInt(sc.nextLine());
		Employee emp = getEmployee(searchEmpno);
		System.out.println(emp.getEmpno() + " : " + emp.getEname());
		System.out.println();
		
		System.out.print("부서이름: ");
		String searchDname = sc.nextLine();
		List<Department> result = getDepartment(searchDname);
		for(Department dept : result){
			System.out.println(dept.getDeptno() + " : "+ dept.getDname() + " : " + dept.getLoc() );
		}
	}

	private static List<Department> getDepartment(String searchDname) {
		Connection conn = null;
		List<Department> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select * from dept where dname like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchDname+"%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Department dept = new Department();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				list.add(dept);
			}
		} catch (Exception e) {
			try {	conn.close();	} catch (SQLException e2) {}
			e.printStackTrace();
		}
		return list;
	}

	private static Employee getEmployee(int searchEmpno) {
		Connection conn = null;
		Employee emp = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select * from emp where empno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, searchEmpno);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				emp = new Employee();
				emp.setEmpno(rs.getInt("empno"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setJob(rs.getString("job"));
				emp.setSal(rs.getDouble("sal"));
			}
			
			pstmt.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			try {	conn.close();	} catch (SQLException e2) {}
			e.printStackTrace();
		}
		
		return emp;
	}
}
