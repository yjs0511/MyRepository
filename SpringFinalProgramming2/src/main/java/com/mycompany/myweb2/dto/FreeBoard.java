package com.mycompany.myweb2.dto;

import java.util.Date;	//util은 날짜 정보를 다른 객체로 전달하고자 할 때(일반적으로는 이걸 쓴다)	/ sql은 타입을 지정할 때

import org.springframework.format.annotation.DateTimeFormat;

public class FreeBoard {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private int bhitcount;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bdate;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String writer) {
		this.bwriter = writer;
	}
	public int getBhitcount() {
		return bhitcount;
	}
	public void setBhitcount(int bhitcount) {
		this.bhitcount = bhitcount;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	
	
}
