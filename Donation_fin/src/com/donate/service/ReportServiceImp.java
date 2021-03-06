package com.donate.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.Paging;
import com.donate.domain.ReportVO;
import com.donate.persistence.ReportDAO;
import com.donate.persistence.ReportDAOImp;

public class ReportServiceImp implements ReportService {

	private static Logger logger = LoggerFactory.getLogger(ReportServiceImp.class);
	private ReportDAO rdao;
	public ReportServiceImp() {
		rdao= new ReportDAOImp();
	}
	@Override
	public int regist(ReportVO rvo) {
		return rdao.insert(rvo);
	}

	@Override
	public List<ReportVO> getList(Paging paging) {
		return rdao.selectList(paging);
	}
	@Override
	public int totalCount(String name) {
		return rdao.selectCount(name);
	}
	@Override
	public List<ReportVO> getList(String ins) {
		return rdao.selectList(ins);
	}

}
