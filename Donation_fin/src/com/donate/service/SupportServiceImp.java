package com.donate.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.SupportVO;
import com.donate.persistence.SupportDAO;
import com.donate.persistence.SupportDAOImp;

public class SupportServiceImp implements SupportService {
	private static Logger logger = LoggerFactory.getLogger(SupportServiceImp.class);

	private SupportDAO sdao;
	
	public SupportServiceImp() {
		sdao = new SupportDAOImp();
	}
	
	@Override
	public int regist(SupportVO svo) {
		return sdao.insert(svo);
	}

	@Override
	public List<SupportVO> getList() {
		return sdao.selectList();
	}
	@Override
	public int remove(Integer sno) {
		return sdao.delete(sno);
	}
	
}
