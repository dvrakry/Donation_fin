package com.donate.service;

import java.util.List;

import com.donate.domain.BoardVO;
import com.donate.domain.Paging;


public interface BoardService {
	public int regist(BoardVO bvo);
	public List<BoardVO> getList(Paging paging);
	public BoardVO getInfo(int bno);
	public int modify(BoardVO bvo);
	public int remove(int bno);
	public int totalCount();
}
