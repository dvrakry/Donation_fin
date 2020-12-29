package com.donate.service;

import java.util.List;

import com.donate.domain.SupportVO;

public interface SupportService {
	public int regist(SupportVO svo);
	public List<SupportVO> getList();
	public int remove(Integer sno);
}
