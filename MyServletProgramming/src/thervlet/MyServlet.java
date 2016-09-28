package thervlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	//필드
	private String location;
	
	//생성자
	public MyServlet(){
		System.out.println("MyServlet 객체 생성");
	}
	
	//초기화 메소드
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("MyServlet 객체 초기화");
		location = config.getInitParameter("location");
	}
	
	//메소드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<hmtl>");
		out.println("<head><meta charset='UTF-8'></head>");
		out.println("<body>");
		out.println("여기는 "+location+" 입니다. 현재시간은 "+ new Date().toString());
		out.println("</body>");
		out.println("</hmtl>");
	}
	
}
