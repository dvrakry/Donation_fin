package com.donate.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.Paging;
import com.donate.domain.ReportVO;
import com.donate.orm.DBBuilder;

public class ReportDAOImp implements ReportDAO {

	private static Logger logger = LoggerFactory.getLogger(ReportDAOImp.class);
	private String namespace = "com.donate.mappers.reportMapper";
	private SqlSession sql;
	
	public ReportDAOImp() {
		new DBBuilder();
		sql = DBBuilder.getFactory().openSession();
	}
	@Override
	public int insert(ReportVO rvo) {
		sql.delete(namespace+".rm");
		sql.commit();
		int isOk = sql.insert(namespace+".reg",rvo);
		sql.commit();
		return isOk;
	}

	@Override
	public List<ReportVO> selectList(Paging paging) {
		return sql.selectList(namespace+".list",paging);
	}
	@Override
	public int selectCount(String name) {
		return sql.selectOne(namespace+".cnt",name);
	}
	@Override
	public List<ReportVO> selectList(String ins) {
		return sql.selectList(namespace+".rpt",ins);
	}
	

}
