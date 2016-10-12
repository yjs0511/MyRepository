package com.mycompany.myapp.exam02;

public class Board {
	private int bno;	// 이 변수 값만 요청 파라미터 값이 같아야만 한다.
	private String title;
	private String content;
	private int hitcount;	// 이 변수 같은 경우는 요청파라미터 이름과 다르기 때문에 사용할 수 없다.
							// 객체로 보낼 경우에만 해당
	
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHitcount() {
		return hitcount;
	}

	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	
	
}
