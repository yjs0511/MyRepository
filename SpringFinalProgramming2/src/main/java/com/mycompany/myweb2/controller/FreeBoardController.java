package com.mycompany.myweb2.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myweb2.dto.FreeBoard;
import com.mycompany.myweb2.service.FreeBoardService;

@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/list")
	public String list(String pageNo, Model model, HttpSession session){	// 원래는 String으로 넘어오는데 값이 만약 넘어오지 않는 경우 예외가 발생하므로 초기값을 정해준다. (잘 넘어오면 알아서 타입 변환을 한다)
		int intPageNo = 1;
		if(pageNo == null){	// pageNO가 null이면 세션에서 찾아보기
			pageNo = (String) session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo=Integer.parseInt(pageNo);
			}
		}else{
			intPageNo = Integer.parseInt(pageNo);
		}
		
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 6;
		int pagesPerGroup = 10;
		
		int totalBoardNo = freeBoardService.getCount();
		
		int totalPageNo = totalBoardNo/rowsPerPage + ((totalBoardNo%rowsPerPage != 0)? 1:0);
		int totalGroupNo = totalPageNo/pagesPerGroup + ((totalPageNo%pagesPerGroup != 0)? 1:0);
		
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup+1;
		int endPageNo = startPageNo + pagesPerGroup-1;
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<FreeBoard> list = freeBoardService.list(intPageNo, rowsPerPage);
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("list", list);
		
		return "freeboard/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(){
		return "freeboard/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(FreeBoard freeBoard, HttpSession session){
		String mid = (String) session.getAttribute("login");
		freeBoard.setBwriter(mid);
		int result = freeBoardService.write(freeBoard);
		if(result == FreeBoardService.WRITE_FAIL){
			return "freeboard/write";
		}else{
			return "redirect:/freeboard/list";
		}
	}
	
	@RequestMapping("/info")
	public String info(int bno, Model model){
		FreeBoard freeBoard = freeBoardService.info(bno);
		freeBoard.setBhitcount(freeBoard.getBhitcount()+1);
		freeBoardService.modify(freeBoard);
		model.addAttribute("freeBoard", freeBoard);
		return "freeboard/info";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(int bno, Model model){
		FreeBoard freeBoard = freeBoardService.info(bno);
		model.addAttribute("freeBoard", freeBoard);
		return "freeboard/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(FreeBoard freeBoard){
		FreeBoard dbBoard = freeBoardService.info(freeBoard.getBno());
		freeBoard.setBhitcount(dbBoard.getBhitcount());
		freeBoardService.modify(freeBoard);
		return "redirect:/freeboard/list";
	}
	
	@RequestMapping("/remove")
	public String remove(int bno){
		freeBoardService.remove(bno);
		return "redirect:/freeboard/list";
	}
	
}
