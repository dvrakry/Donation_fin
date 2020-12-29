package com.donate.service;

import java.util.ArrayList;

import com.donate.domain.MemberVO;

public interface MemberService {
	public int join(MemberVO mvo);
	public MemberVO login(MemberVO mvo);
	public ArrayList<MemberVO> getList();
	public MemberVO getInfo(String mid);
	public int modify(MemberVO mvo);
	public int remove(String mid);
	public int midCheck(String mid);
}
