package com.donate.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.SupportVO;
import com.donate.orm.DBBuilder;

public class SupportDAOImp implements SupportDAO {
	private static Logger logger = LoggerFactory.getLogger(SupportDAOImp.class);
	private SqlSession sql;
	private static String namespace = "com.donate.mappers.supportMapper";
	
	
	
	public SupportDAOImp() {
		new DBBuilder();
		sql = DBBuilder.getFactory().openSession();
	}
	
	@Override
	public int insert(SupportVO svo) {
		int isReg = sql.insert(namespace+".sreg", svo);
		sql.commit();
		return isReg > 0 ? 1 : 0;
	}

	@Override
	public List<SupportVO> selectList() {
		return sql.selectList(namespace+".list");
	}



	@Override
	public int delete(Integer sno) {
		int isRm = sql.delete(namespace+".rm", sno);
		sql.commit();
		return isRm > 0 ? 1 : 0;
		
	}

	

}
