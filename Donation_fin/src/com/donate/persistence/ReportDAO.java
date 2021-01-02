package com.donate.persistence;

import java.util.List;

import com.donate.domain.Paging;
import com.donate.domain.ReportVO;

public interface ReportDAO {
	public int insert(ReportVO rvo);
	public List<ReportVO> selectList(Paging paging);
	public int selectCount(String name);
	public List<ReportVO> selectList(String ins);
}
