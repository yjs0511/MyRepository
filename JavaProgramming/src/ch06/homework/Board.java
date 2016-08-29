package ch06.homework;

public class Board {
	//field
	int boardNo;
	String title;
	String name;
	String content;
	int hitCount;
	
	Board(){}

	Board(int boardNo, String title, String name, String content, int hitCount) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.name = name;
		this.content = content;
		this.hitCount = hitCount;
	}
	

}
