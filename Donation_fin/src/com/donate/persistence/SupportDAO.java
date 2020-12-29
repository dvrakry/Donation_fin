package com.donate.persistence;

import java.util.List;

import com.donate.domain.SupportVO;

public interface SupportDAO {
	public int insert(SupportVO svo);
	public List<SupportVO> selectList();
	//public SupportVO selectOne(Integer sno);
	public int delete(Integer sno);
}
