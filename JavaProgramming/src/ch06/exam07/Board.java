package ch06.exam07;

public class Board {
	//Field
	int no;
	String title;
	String content;
	String writer;
	int hitCount;
	
	//Constructor Overloading
	Board(){}
	
	Board(int no){
		//int merong = 0; this() 생성자는 첫번째 줄에 있어야만 한다!
		this(no, null, null, null, 0);
		int merong=0;
	}
	
	Board(int no, String title){
		this(no, title, null, null, 0);
	}
	
	Board(String title, int no){
		this(no, title, null, null, 0);
	}
	
	Board(int no, String title, String content){
		this(no, title, content, null, 0);
	}
	
	Board(int no, String title, String content, String writer){
		this(no, title, content, writer, 0);
	}
	
	Board(int no, String title, String content, String writer, int hitCount){
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hitCount = hitCount;
	}
	
	//Method

}
