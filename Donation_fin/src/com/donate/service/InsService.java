package com.donate.service;

import java.util.List;

import com.donate.domain.InsVO;

public interface InsService {
	public int register(InsVO ivo);
	public List<InsVO> getList();
	public InsVO getInfo(Integer ino);
	public int modify(InsVO ivo);
	public int remove(Integer ino);
}
