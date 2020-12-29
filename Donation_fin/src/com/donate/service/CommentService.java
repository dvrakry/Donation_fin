package com.donate.service;

import java.util.List;

import com.donate.domain.CommentVO;

public interface CommentService {
	public int add(CommentVO cvo);
	public List<CommentVO> getList(Integer ino);
	public int modify(CommentVO cvo);
	public int remove(Integer cno);
}
