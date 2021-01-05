package com.donate.persistence;

import java.util.List;

import com.donate.domain.CommentVO;

public interface CommentDAO {
	public int insert(CommentVO cvo);
	public List<CommentVO> selectList(Integer ino);
	public int update(CommentVO cvo);
	public int delete(int cno);
	
	public List<CommentVO> selectList_m(int mno, int bno);
	public int insert_m(CommentVO cvo);
}
