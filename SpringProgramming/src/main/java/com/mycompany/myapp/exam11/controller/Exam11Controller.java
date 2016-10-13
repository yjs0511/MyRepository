package com.mycompany.myapp.exam11.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.exam11.dto.Board;
import com.mycompany.myapp.exam11.dto.Member;
import com.mycompany.myapp.exam11.service.Exam11BoardService;
import com.mycompany.myapp.exam11.service.Exam11MemberService;

@Controller("MemberController")		// @Controller("MemberController") 컨트롤러 객체 이름을 바꿀 수 있다. 디폴트값은 exam11Controller
@RequestMapping("/exam11")
public class Exam11Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam11Controller.class);
	
	@Autowired	// 필드, 생성자, setter 주입 다 가능
	// @Resource 는 setter 주입만 가능
	private Exam11MemberService memberService;
	
	@Autowired
	private Exam11BoardService boardService;
	
	/*public void setExam11MemberService(Exam11MemberService exam11MemberService) {
		this.exam11MemberService = exam11MemberService;
	}*/


	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam11/index";
	}
	
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.GET)
	public String memberJoinForm(){
		logger.info("memberJoin(GET) 처리");
		return "exam11/memberJoinForm";
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST)
	public String memberJoin(Member member){
		logger.info("memberJoin(POST) 처리");
		logger.info("mid: "+member.getMid());
		logger.info("mpassword: "+member.getMpassword());
		logger.info("email: "+member.getEmail());
		logger.info("mtel: "+member.getMtel());
		logger.info("mjob: "+member.getMjob());
		logger.info("mskill: "+Arrays.toString(member.getMskill()));
		logger.info("maddress1: "+member.getMaddress1());
		logger.info("maddress2: "+member.getMaddress2());
		logger.info("mbirth: "+member.getMbirth());
		
		memberService.join(member);
		return "redirect:/exam11/memberLogin";
	}
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.GET)
	public String memberLoginForm(){
		logger.info("memberLogin(GET) 처리");
		return "exam11/memberLoginForm";
	}
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.POST)
	public String memberLogin(String mid, String mpassword){
		logger.info("memberLogin(POST) 처리");
		logger.info("mid: "+mid);
		logger.info("mpassword: "+mpassword);
		
		int result = memberService.login(mid, mpassword);
		if(result == Exam11MemberService.LOGIN_SUCCESS){
			return "redirect:/exam11/index";
		}else if(result == Exam11MemberService.LOGIN_FAIL_MID){
			return "redirect:/exam11/memberLogin";		// 리다이렉트를 하지 않고 JSP 페이지 요청을 하면 F5를 눌렀을 때 페이지 갱신이 되지 않고 이전 요청을 다시 실행한다. 문제 발생
		}else{
			return "redirect:/exam11/memberLogin";
		}
	}
	
	@RequestMapping("/memberLogout")
	public String memberLogout(){
		logger.info("memberLogout 처리");
		return "redirect:/exam11/index";
	}
	
	@RequestMapping(value="boardWrite", method=RequestMethod.GET)
	public String boardWriteForm(){
		logger.info("boardWriteForm 처리");
		return "exam11/boardWriteForm";
	}
	
	@RequestMapping(value="boardWrite", method=RequestMethod.POST)
	public String boardWrite(Board board){
		logger.info("boardWrite 처리");
		boardService.write(board);
		return "redirect:/exam11/index";
	}
	
	@RequestMapping("/boardList")
	public String boardList(Model model){
		logger.info("boardList 처리");
		List<Board> list = boardService.getList();
		model.addAttribute("boardList", list);
		return "exam11/boardList";
	}
	
	@RequestMapping("/boardView")
	public String boardView(int bno, Model model){	// 매개변수 bno가 확실히 넘어올 수 있도록 보장해줘야 한다. 예외 발생을 방지하려면... (int형으로 변환해 줘야 한다.)
		Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);	//JSP 에서 표현식으로 board라는 이름으로 데이터에 접근 
		logger.info("boardView 처리");
		return "exam11/boardView";
	}
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.GET)
	public String boardUpdateForm(int bno, Model model){	// 매개변수 bno가 확실히 넘어올 수 있도록 보장해줘야 한다. 예외 발생을 방지하려면... (int형으로 변환해 줘야 한다.)
		logger.info("boardUpdateForm 처리");
		Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);	//JSP 에서 표현식으로 board라는 이름으로 데이터에 접근 
		return "exam11/boardUpdateForm";
	}
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(Board board){	
		logger.info("boardUpdate 처리");
		boardService.updateBoard(board);
		return "redirect:/exam11/boardList";
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(int bno){	
		logger.info("boardDelete 처리");
		boardService.deleteBoard(bno);
		return "redirect:/exam11/boardList";
	}
}
