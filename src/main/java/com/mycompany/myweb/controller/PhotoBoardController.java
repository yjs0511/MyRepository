package com.mycompany.myweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.PhotoBoard;
import com.mycompany.myweb.service.PhotoBoardService;

@Controller
@RequestMapping("/photoboard")
public class PhotoBoardController {
	
	@Autowired
	private PhotoBoardService photoBoardService;
	
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
		
		int rowsPerPage = 8;
		int pagesPerGroup = 5;
		
		int totalBoardNo = photoBoardService.getCount();
		
		int totalPageNo = totalBoardNo/rowsPerPage + ((totalBoardNo%rowsPerPage != 0)? 1:0);
		int totalGroupNo = totalPageNo/pagesPerGroup + ((totalPageNo%pagesPerGroup != 0)? 1:0);
		
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup+1;
		int endPageNo = startPageNo + pagesPerGroup-1;
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<PhotoBoard> list = photoBoardService.list(intPageNo, rowsPerPage);
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
		
		return "photoboard/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(){
		return "photoboard/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(PhotoBoard photoBoard, HttpSession session){
		try{
			String mid = (String) session.getAttribute("login");
			photoBoard.setBwriter(mid);
			
			photoBoard.setOriginalfile(photoBoard.getPhoto().getOriginalFilename());
			
			String savedfile = new Date().getTime() + photoBoard.getPhoto().getOriginalFilename();
			
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile);	// 저장할 파일의 절대 파일 시스템의 경로
			photoBoard.getPhoto().transferTo(new File(realpath));										// 실제로 파일을 저장하는 코드(파일시스템 경로에 실제 파일을 저장)
			
			photoBoard.setSavedfile(savedfile);
			photoBoard.setMimetype(photoBoard.getPhoto().getContentType());
			
			int result = photoBoardService.write(photoBoard);
			
			if(result == PhotoBoardService.WRITE_FAIL){
				return "photoboard/write";
			}else{
				return "redirect:/photoboard/list";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "photoboard/write";
		}
	}
	
	@RequestMapping("/showPhoto")
	public String showPhoto(String savedfile, HttpServletRequest request, HttpServletResponse response){
		
		try{
			String fileName = savedfile;
			/*
			 * 브루우저에서 보여주지 않고 강제로 다운로드할 경우
			fileName = URLEncoder.encode(fileName, "UTF-8");	// 한글에 대한 유니코드로 받아서 16진수로 변환
			response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName +"\"");	//파일 첨부(다운로드) 기능 및 이름 지정
			*/																				// \" \" 파일 이름이 어디 까지다 라는 걸 지정
			String mimeType = request.getServletContext().getMimeType(fileName);	// getMimeType() 메소드는 파일명을 주게 되면 파일의 확장자명을 리턴하는 메소드
			response.setContentType(mimeType);
			
			OutputStream os = response.getOutputStream();
			
			String filePath = request.getServletContext().getRealPath("/WEB-INF/photo/" + fileName); // Context 위치를 기준으로 그 아래 경로를 지정
			InputStream is = new FileInputStream(filePath);
			
			byte[] values = new byte[1024];
			int byteNum = -1;
			while((byteNum = is.read(values))!= -1){
				os.write(values, 0, byteNum);
			}
			os.flush();
			is.close();
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping("/info")
	public String info(int bno, Model model){
		PhotoBoard photoBoard = photoBoardService.info(bno); 
		photoBoard.setBhitcount(photoBoard.getBhitcount()+1);
		photoBoardService.modify(photoBoard);
		model.addAttribute("photoboard", photoBoard);
		return "photoboard/info";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(int bno, Model model){
		PhotoBoard photoBoard = photoBoardService.info(bno);
		model.addAttribute("photoboard", photoBoard);
		return "photoboard/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(PhotoBoard photoBoard, HttpSession session){
		
		try{
			PhotoBoard dbBoard = photoBoardService.info(photoBoard.getBno());
			photoBoard.setBhitcount(dbBoard.getBhitcount());
			
			photoBoard.setOriginalfile(photoBoard.getPhoto().getOriginalFilename());
			
			String savedfile = new Date().getTime() + photoBoard.getPhoto().getOriginalFilename();
			
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile);	// 저장할 파일의 절대 파일 시스템의 경로
			photoBoard.getPhoto().transferTo(new File(realpath));										// 실제로 파일을 저장하는 코드(파일시스템 경로에 실제 파일을 저장)
			
			photoBoard.setSavedfile(savedfile);
			photoBoard.setMimetype(photoBoard.getPhoto().getContentType());
			
			int result = photoBoardService.modify(photoBoard);
			
			if(result == PhotoBoardService.WRITE_FAIL){
				return "photoboard/modify";
			}else{
				return "redirect:/photoboard/list";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "photoboard/modify";
		}
	}
	
	@RequestMapping("/remove")
	public String remove(int bno){
		photoBoardService.remove(bno);
		return "redirect:/photoboard/list";
	}
	
	
}
