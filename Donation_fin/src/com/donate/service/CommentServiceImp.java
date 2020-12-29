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
	public List<CommentVO> getList(Integer ino) {
		return cdao.selectList(ino);
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
