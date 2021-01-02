package com.donate.domain;


public class CommentVO {
	private int cno;
	private int ino;
	private String writer;
	private String comment;
	private String cregdate;
	
	private int mno;
	
	
	public CommentVO() {
		 
	}
	
	public CommentVO(int ino, String writer, String comment) {
		
		this.ino = ino;
		this.writer = writer;
		this.comment = comment;
	}
	
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCregdate() {
		return cregdate;
	}
	public void setCregdate(String cregdate) {
		this.cregdate = cregdate;
	}

	
	
	
	
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}
	
	

}
