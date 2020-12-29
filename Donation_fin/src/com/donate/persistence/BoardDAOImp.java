package com.donate.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.BoardVO;
import com.donate.domain.Paging;
import com.donate.orm.DBBuilder;

public class BoardDAOImp implements BoardDAO {
	private static Logger logger = LoggerFactory.getLogger(BoardDAOImp.class);
	private SqlSession sql;
	private static String namespace = "com.donate.mappers.boardMapper";
	
	public BoardDAOImp() {
		new DBBuilder();
		sql = DBBuilder.getFactory().openSession();
	}

	@Override
	public int insert(BoardVO bvo) {
		int res = sql.insert(namespace+".reg", bvo);
		sql.commit();
		return res;
	}

	@Override
	public ArrayList<BoardVO> selectList(Paging paging) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = sql.selectList(namespace+".list", paging);
		return (ArrayList<BoardVO>) list;
	}

	@Override
	public int update(BoardVO bvo) {
		int updateOk = sql.update(namespace+".edit", bvo);
		if(updateOk > 0) {
			sql.commit();
			return updateOk;
		}else {
			return 0;
		}
	}

	@Override
	public int delete(int bno) {
		int deleteOk = sql.update(namespace+".delete", bno);
		if(deleteOk > 0) {
			sql.commit();
			return deleteOk;
		}else {
			return 0;
		}
	}

	@Override
	public int selectCount() {
		return sql.selectOne(namespace+".cnt");
	}

	@Override
	public BoardVO selectOne(int bno) {
		return sql.selectOne(namespace+".info", bno);
	}
	
	
}
