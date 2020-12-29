package com.donate.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.InsVO;
import com.donate.persistence.InsDAO;
import com.donate.persistence.InsDAOImp;

public class InsServiceImp implements InsService {

	private static Logger logger = LoggerFactory.getLogger(InsServiceImp.class);
	private InsDAO idao;
	public InsServiceImp() {
		idao = new InsDAOImp();
	}
	@Override
	public int register(InsVO ivo) {
		return idao.insert(ivo);
	}

	@Override
	public List<InsVO> getList() {
		return idao.getList();
	}

	@Override
	public InsVO getInfo(Integer ino) {
		return idao.selectOne(ino);
	}

	@Override
	public int modify(InsVO ivo) {
		return idao.update(ivo);
	}

	@Override
	public int remove(Integer ino) {
		return idao.delete(ino);
	}

}
