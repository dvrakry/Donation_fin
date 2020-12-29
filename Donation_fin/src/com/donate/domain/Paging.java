package com.donate.domain;

public class Paging {
	public int pageSize = 10; // 한 페이지에 보여줄 글 수
	public int pageBlock = 5; // 페이지네이션의 수
	public int clPage; // 클릭한 페이지 넘버
	public int total; // DB에 등록된 총 글의 수
	public int endNo; // 한 페이지에 보여주는 게시글의 끝 번호
	public int startNo; // 한 페이지에 보여주는 게시글의 시작 번호
	public int totalPage; // 총 페이지 수
	public int prevBlock; // 이전 페이지 번호
	public int nextBlock; // 다음 페이지 번호
	
	public Paging() {}
	public Paging(int clPage, int total) {
		this.clPage = clPage;
		this.total = total;
		this.endNo = clPage * pageSize;
		this.startNo = (endNo - pageSize);
		this.totalPage = (total/pageSize) + 1;
		this.prevBlock = ((this.clPage-1)/this.pageBlock)*this.pageBlock;
		this.nextBlock = this.prevBlock + this.pageBlock + 1;
		this.nextBlock = this.nextBlock > this.totalPage 
				? this.totalPage : this.nextBlock;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getClPage() {
		return clPage;
	}
	public void setClPage(int clPage) {
		this.clPage = clPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPrevBlock() {
		return prevBlock;
	}
	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}
	public int getNextBlock() {
		return nextBlock;
	}
	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}
}
