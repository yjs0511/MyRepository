package ch08.service;

import java.util.Date;

import ch08.dao.BoardDao;
import ch08.dto.Board;

public class Exam04 {
	public static void main(String[] args){
		BoardDao dao = new BoardDao();
		Board board = new Board();
		
		board.setBno(4);
		board.setBtitle("제목4");
		board.setBcontent("내용4");
		board.setBwriter("user4");
		board.setBhitcount(1);
		board.setBdate(new Date(1990,01,01));
		
		dao.insert(board);
		
	}
}
