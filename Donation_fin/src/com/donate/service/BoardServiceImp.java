package com.donate.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.BoardVO;
import com.donate.domain.Paging;
import com.donate.persistence.BoardDAO;
import com.donate.persistence.BoardDAOImp;

public class BoardServiceImp implements BoardService {
	private static Logger logger = LoggerFactory.getLogger(BoardServiceImp.class);
	private BoardDAO bdao;
	
	public BoardServiceImp() {
		bdao = new BoardDAOImp();
	}

	@Override
	public int regist(BoardVO bvo) {
		return bdao.insert(bvo);
	}


	@Override
	public BoardVO getInfo(int bno) {
		return bdao.selectOne(bno);
	}

	@Override
	public int modify(BoardVO bvo) {
		return bdao.update(bvo);
	}

	@Override
	public int remove(int bno) {
		return bdao.delete(bno);
	}

	@Override
	public List<BoardVO> getList(Paging paging) {
		return bdao.selectList(paging);
	}

	@Override
	public int totalCount() {
		return bdao.selectCount();
	}

}
