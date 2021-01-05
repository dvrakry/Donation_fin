package com.donate.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.CommentVO;
import com.donate.persistence.CommentDAO;
import com.donate.persistence.CommentDAOImp;

public class CommentServiceImp implements CommentService {

	private static Logger logger = LoggerFactory.getLogger(CommentServiceImp.class);
	private CommentDAO cdao;
	public CommentServiceImp() {
		cdao = new CommentDAOImp();
	}
	@Override
	public int add(CommentVO cvo) {
		int isOk = cdao.insert(cvo);
		logger.info(">>>isOk");
		return isOk;
	}
	
	@Override
	public int add_m(CommentVO cvo) {
		int isOk_m = cdao.insert_m(cvo);
		logger.info(">>>isOk");
		return isOk_m;
	}
	
	
	

	@Override
	public List<CommentVO> getList(Integer ino) {
		return cdao.selectList(ino);
	}
	
	
	@Override
	public List<CommentVO> getList_m(int mno, int bno) {
		return cdao.selectList_m(mno, bno);
	}
	
	
	

	@Override
	public int modify(CommentVO cvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(Integer cno) {
		return cdao.delete(cno);
	}
	
	

}
