package com.donate.domain;


public class ReportVO {
	private int rno;
	private String name;
	private String product;
	private int price;
	private int count;
	private String ins;
	private String regdate;

	public ReportVO() {
	}

	public ReportVO(String name, String product, int price, int count, String ins) {
		this.price = price;
		this.name = name;
		this.product = product;
		this.count = count;
		this.ins = ins;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getIns() {
		return ins;
	}

	public void setIns(String ins) {
		this.ins = ins;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
