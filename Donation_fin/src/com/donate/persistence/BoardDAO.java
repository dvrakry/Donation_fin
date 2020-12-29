package com.donate.persistence;

import java.util.ArrayList;

import com.donate.domain.BoardVO;
import com.donate.domain.Paging;

public interface BoardDAO {
	public int insert(BoardVO bvo);
	public ArrayList<BoardVO> selectList(Paging paging);
	public int update(BoardVO bvo);
	public int delete(int bno);
	public int selectCount();
	public BoardVO selectOne(int bno);
}
