package com.donate.service;

import java.util.List;

import com.donate.domain.Paging;
import com.donate.domain.ProductVO;

public interface ProductService {
	public int regist(ProductVO pvo);
	public List<ProductVO> getList(Paging paging);
	public ProductVO getInfo(Integer pno);
	public int modify(ProductVO pvo);
	public int remove(Integer pno);
	public int totalCount();
}
