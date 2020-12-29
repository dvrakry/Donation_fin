package com.donate.domain;

public class SupportVO {

	private int sno;	// 장바구니 각각 상품의 번호 
	private String pname;
	private int price;
	private String thumb;
	
	public SupportVO() {}
	
	// 장바구니 넣는 목록
	public SupportVO(String thumb,String pname,int price) {
		this.pname = pname;
		this.price = price;
		this.thumb = thumb;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	
	
	
	
	
}
