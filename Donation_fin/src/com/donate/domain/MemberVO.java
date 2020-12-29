package com.donate.domain;


public class MemberVO {
	private int mno; 
	private String mname;
	private String mid;
	private String mpwd;
	private String mphone;
	private String mins;
	
	public MemberVO() {}
	
	
	//로그인
	public MemberVO(String mid, String mpwd) {
		this.mid = mid;
		this.mpwd = mpwd;
	}



	//일반고객
	public MemberVO(String mname, String mid, String mpwd, String mphone) {
		this.mname = mname;
		this.mid = mid;
		this.mpwd = mpwd;
		this.mphone = mphone;
	}
	
	//시설고객
	public MemberVO(String mname, String mid, String mpwd, String mphone, String mins) {
		this.mname = mname;
		this.mid = mid;
		this.mpwd = mpwd;
		this.mphone = mphone;
		this.mins = mins;
	}
	


	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMins() {
		return mins;
	}

	public void setMins(String mins) {
		this.mins = mins;
	}
	
}
