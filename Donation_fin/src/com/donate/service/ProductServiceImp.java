package com.donate.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.Paging;
import com.donate.domain.ProductVO;
import com.donate.persistence.ProductDAO;
import com.donate.persistence.ProductDAOImp;

public class ProductServiceImp implements ProductService{
	private static Logger logger = LoggerFactory.getLogger(ProductServiceImp.class);
	private ProductDAO pdao;
	
	public ProductServiceImp() {
		pdao = new ProductDAOImp();
	}

	@Override
	public int regist(ProductVO pvo) {
		return pdao.insert(pvo);
	}

	@Override
	public List<ProductVO> getList(Paging paging) {
		return pdao.selectList(paging);
	}

	@Override
	public ProductVO getInfo(Integer pno) {
		return pdao.selectOne(pno);
	}

	@Override
	public int modify(ProductVO pvo) {
		return pdao.update(pvo);
	}

	@Override
	public int remove(Integer pno) {		
		return pdao.delete(pno);
	}

	@Override
	public int totalCount() {
		return pdao.selectCount();
	}	
}
