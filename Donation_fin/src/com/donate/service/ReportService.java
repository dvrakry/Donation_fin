package com.donate.service;

import java.util.List;

import com.donate.domain.Paging;
import com.donate.domain.ReportVO;

public interface ReportService {
	public int regist(ReportVO rvo);
	public List<ReportVO> getList(Paging paging);
	public int totalCount(String name);
	public List<ReportVO> getList(String ins);
}
