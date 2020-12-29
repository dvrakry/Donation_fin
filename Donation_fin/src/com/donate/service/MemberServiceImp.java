package com.donate.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.MemberVO;
import com.donate.persistence.MemberDAO;
import com.donate.persistence.MemberDAOImp;

public class MemberServiceImp implements MemberService {
	private static Logger logger = LoggerFactory.getLogger(MemberServiceImp.class);
	private MemberDAO mdao;
	
	public MemberServiceImp() {
		mdao = new MemberDAOImp();
	}
	
	@Override
	public int join(MemberVO mvo) {
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		return mdao.selectOne(mvo);
	}

	@Override
	public ArrayList<MemberVO> getList() {
		return mdao.selectList();
	}

	@Override
	public MemberVO getInfo(String mid) {
		return mdao.selectOne(mid);
	}

	@Override
	public int modify(MemberVO mvo) {
		return mdao.update(mvo);
	}

	@Override
	public int remove(String mid) {
		return mdao.delete(mid);
	}

	@Override
	public int midCheck(String mid) {
		return mdao.selectCount(mid);
	}

}
