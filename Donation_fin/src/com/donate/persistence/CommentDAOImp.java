package com.donate.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.CommentVO;
import com.donate.orm.DBBuilder;

public class CommentDAOImp implements CommentDAO {

	private static Logger logger = LoggerFactory.getLogger(CommentDAOImp.class);
	private String namespace = "com.donate.mappers.commentMapper";
	private SqlSession sql;
	public CommentDAOImp() {
		new DBBuilder();
		sql = DBBuilder.getFactory().openSession();
	}
	@Override
	public int insert(CommentVO cvo) {
		int isOk = sql.insert(namespace+".add",cvo);
		sql.commit();
		return isOk;
	}
	
	
	
	
	@Override
	public int insert_m(CommentVO cvo) {
		int isOk_m = sql.insert(namespace+".add_m",cvo);
		sql.commit();
		return isOk_m;
	}
	
	
	

	@Override
	public List<CommentVO> selectList(Integer ino) {
		return sql.selectList(namespace+".list",ino);
	}
	
	
	
	
	@Override
	public List<CommentVO> selectList_m(int mno) {
		return sql.selectList(namespace+".list_m",mno);
	}
	
	

	
	
	@Override
	public int update(CommentVO cvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int cno) {
		int isOk = sql.delete(namespace+".rm",cno);
		sql.commit();
		return isOk;
	}

	

}
