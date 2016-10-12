package com.mycompany.myapp.exam05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/exam05")
@Controller
public class Exam05Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam05Controller.class);

	@RequestMapping("/index")
	public String index() {
		logger.info("index 요청 처리");
		return "exam05/index";
	}

	@RequestMapping("/index2")
	public ModelAndView index2() {
		logger.info("index2 요청 처리");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exam05/index");
		return mav;
	}

	@RequestMapping("/index3")
	public void index3(HttpServletRequest request, HttpServletResponse response) throws IOException {	// void를 사용하는 경우는 JSP로 작업하지 않는 경우
																										// 간단한 데이터는 void 사용
		logger.info("index3 요청 처리");
		response.setContentType("image/jpeg");
		
		//String filePath = request.getRealPath("webapp/image/photo1.jpg");	// 검은 막대기는 기왕이면 쓰지 말라는 뜻
		String filePath = request.getServletContext().getRealPath("/WEB-INF/image/photo1.jpg");
		InputStream is = new FileInputStream(filePath);
		OutputStream os = response.getOutputStream();
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		
		while((byteNum = is.read(values)) != -1){
			os.write(values, 0, byteNum);
		}
		os.flush();
		is.close(); // OutputStream은 톰캣이 관리하기 때문에 안 닫아도 된다.
	}
}
