package com.donate.domain;

public class ProductVO {

	private int pno;
	private String pname;
	private int price;
	private String imgfile;
	private String thumb;
	public ProductVO() {}
	
	
	// 상품등록
	public ProductVO(String pname,int price,String imgfile) {
		this.pname = pname;
		this.price = price;
		this.imgfile = imgfile;
	}
	
	// 상품 리스트
	public ProductVO(int pno, String pname, int price,String thumb) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.thumb = thumb;
	}


	public int getPno() {
		return pno;
	}


	public void setPno(int pno) {
		this.pno = pno;
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
		
	
	
}
