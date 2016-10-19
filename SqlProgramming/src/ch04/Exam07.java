package ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exam07 {
	public static void main(String[] args){
		List<JobSalary> result = getMethod("사원", 1000);
		for(JobSalary js : result){
			System.out.println(js.getJob()+ " : " + js.getSalary());
		}
	}

	private static List<JobSalary> getMethod(String job, int sal) {
		List<JobSalary> jsList = new ArrayList<>();
		Connection conn = null;
		String sql = "select job, sum(sal) as salary from emp where not job=? group by job having sum(sal)>=? order by sum(sal)";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job);
			pstmt.setInt(2, sal);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				JobSalary js = new JobSalary();
				js.setJob(rs.getString("job"));		// 1을 넣어도 된다.
				js.setSalary(rs.getInt("salary"));	// 2를 넣어도 된다.
				jsList.add(js);
			}
			
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return jsList;
	}
}
