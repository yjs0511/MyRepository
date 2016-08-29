package ch06.homework;

public class Board {
	//field
	private int boardNo;
	private String title;
	private String name;
	private String content;
	private int hitCount;
	
	Board(){}

	Board(int boardNo, String title, String name, String content, int hitCount) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.name = name;
		this.content = content;
		this.hitCount = hitCount;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	
}
