package com.donate.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.donate.domain.MemberVO;
import com.donate.orm.DBBuilder;

public class MemberDAOImp implements MemberDAO {
	private SqlSession sql;
	private static String namespace = "com.donate.mappers.memberMapper";
	
	public MemberDAOImp() {
		new DBBuilder();
		sql = DBBuilder.getFactory().openSession();
	}

	@Override
	public int insert(MemberVO mvo) {
		int res = sql.insert(namespace+".join", mvo);
		sql.commit();
		return res;
	}
	@Override
	public MemberVO selectOne(MemberVO mvo) {
		return sql.selectOne(namespace+".login", mvo);
	}

	@Override
	public ArrayList<MemberVO> selectList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = sql.selectList(namespace+".list");
		return (ArrayList<MemberVO>) list;
	}

	@Override
	public int update(MemberVO mvo) {
		int updateOk = sql.update(namespace+".edit", mvo);
		if(updateOk > 0) {
			sql.commit();
			return updateOk;
		}else {
			return 0;
		}
	}

	@Override
	public int delete(String mid) {
		int deleteOk = sql.update(namespace+".delete", mid);
		if(deleteOk > 0) {
			sql.commit();
			return deleteOk;
		}else {
			return 0;
		}
	}


	@Override
	public MemberVO selectOne(String mid) {
		return sql.selectOne(namespace+".info", mid);
	}

	@Override
	public int selectCount(String mid) {
		return sql.selectOne(namespace+".midCount", mid);
	}


}
