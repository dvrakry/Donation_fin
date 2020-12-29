package com.donate.domain;


public class BoardVO {
	private int bno;
	private String iname;
	private String title;
	private String bregdate;
	private String bmoddate;
	private String imgfile;
	private String thumb;
	private String bid;
	private String bcontent;
	private String bperson;
	
	public BoardVO() {}

	//입력
	public BoardVO(String iname, String bregdate, String imgfile, String bid, String bcontent, String bperson) {
		this.iname = iname;
		this.bregdate = bregdate;
		this.imgfile = imgfile;
		this.bid = bid;
		this.bcontent = bcontent;
		this.bperson = bperson;
	}
	//리스트
	public BoardVO(int bno, String iname, String title, String bregdate, String thumb, String imgfile, String bid, String bcontent, String bperson) {
		this.bno = bno;
		this.iname = iname;
		this.title = title;
		this.bregdate = bregdate;
		this.thumb = thumb;
		this.bid = bid;
		this.bcontent = bcontent;
		this.bperson = bperson;
		this.imgfile = imgfile;

	}
	// 업데이트
	public BoardVO(int bno, String bmoddate, String imgfile, String thumb, String bcontent, String bperson) {
		this.bno = bno;
		this.bmoddate = bmoddate;
		this.imgfile = imgfile;
		this.thumb = thumb;
		this.bcontent = bcontent;
		this.bperson = bperson;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBregdate() {
		return bregdate;
	}

	public void setBregdate(String bregdate) {
		this.bregdate = bregdate;
	}

	public String getBmoddate() {
		return bmoddate;
	}

	public void setBmoddate(String bmoddate) {
		this.bmoddate = bmoddate;
	}

	public String getImgfile() {
		return imgfile;
	}

	public void setImgfile(String imgfile) {
		this.imgfile = imgfile;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBperson() {
		return bperson;
	}

	public void setBperson(String bperson) {
		this.bperson = bperson;
	}
	
	
	
}
	
