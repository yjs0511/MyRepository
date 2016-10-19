package ch07.service;

import java.util.List;

import ch07.dao.BoardDao;
import ch07.dto.Board;

public class BoardService {
	public static void main(String[] args){
		BoardDao dao = new BoardDao();
		
		// 번호를 주고 게시물 정보 얻기
		Board board = dao.selectByBno(2);
		System.out.println(board.getBno() + " : " + board.getBtitle() + " : " + board.getBcontent());
		
		// 현재 총 멤버의 정보 얻기
		List<Board> list = dao.selectAll();
		for(Board b : list){
			System.out.println(b.getBno() + " : " + b.getBtitle() + " : " + b.getBcontent());
		}
	}
}
