package com.donate.persistence;

import java.util.ArrayList;

import com.donate.domain.MemberVO;

public interface MemberDAO {
	public int insert(MemberVO mvo);
	public MemberVO selectOne(MemberVO mvo);
	public ArrayList<MemberVO> selectList();
	public MemberVO selectOne(String mid);
	public int update(MemberVO mvo);
	public int delete(String mid);
	public int selectCount(String mid);
	
}
