package com.donate.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.InsVO;
import com.donate.orm.DBBuilder;

public class InsDAOImp implements InsDAO {

	private static Logger logger = LoggerFactory.getLogger(InsDAOImp.class);
	SqlSession sql;
	String namespace="com.donate.mappers.insMapper";
	public InsDAOImp() {
		new DBBuilder();
		sql = DBBuilder.getFactory().openSession();
	}
	@Override
	public int insert(InsVO ivo) {
		int isOk = sql.insert(namespace+".reg",ivo);
		sql.commit();
		
		return isOk;
	}

	@Override
	public List<InsVO> getList() {
		return sql.selectList(namespace+".list");
	}

	@Override
	public InsVO selectOne(Integer ino) {
		return sql.selectOne(namespace+".info",ino);
	}

	@Override
	public int update(InsVO ivo) {
		int isOk = sql.update(namespace+".upd",ivo);
		sql.commit();
		
		return isOk;
	}

	@Override
	public int delete(Integer ino) {
		int isOk = sql.delete(namespace+".rm",ino);
		sql.commit();
		
		return isOk;
	}

}
