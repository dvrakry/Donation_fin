package com.donate.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.Paging;
import com.donate.domain.ProductVO;
import com.donate.orm.DBBuilder;

public class ProductDAOImp implements ProductDAO{
	private static Logger logger = LoggerFactory.getLogger(ProductDAOImp.class);
	private SqlSession sql;
	private static String namespace = "com.donate.mappers.productMapper";
	
	public ProductDAOImp() {
		new DBBuilder();
		sql = DBBuilder.getFactory().openSession();
	}

	@Override
	public int insert(ProductVO pvo) {
		int isReg = sql.insert(namespace+".reg", pvo);
		sql.commit();
		return isReg > 0 ? 1 : 0;
	}

	@Override
	public List<ProductVO> selectList(Paging paging) {		
		return sql.selectList(namespace+".list",paging);
	}

	@Override
	public ProductVO selectOne(Integer pno) {
		return sql.selectOne(namespace+".info", pno);
	}

	@Override
	public int update(ProductVO pvo) {
		int isUp = sql.update(namespace+".mod", pvo);
		sql.commit();
		return isUp > 0 ? 1 : 0 ;
	}

	@Override
	public int delete(Integer pno) {
		int isRm = sql.delete(namespace+".rm", pno);
		sql.commit();
		return isRm > 0 ? 1 : 0;
	}

	@Override
	public int selectCount() {
		
		return sql.selectOne(namespace+".cnt");
	}
	
	

}
