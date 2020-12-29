package com.donate.persistence;

import java.util.List;

import com.donate.domain.ReportVO;

public interface ReportDAO {
	public int insert(ReportVO rvo);
	public List<ReportVO> selectList();
}
