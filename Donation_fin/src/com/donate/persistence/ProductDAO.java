package com.donate.persistence;

import java.util.List;

import com.donate.domain.Paging;
import com.donate.domain.ProductVO;

public interface ProductDAO {
	public int insert(ProductVO pvo);
	public List<ProductVO> selectList(Paging paging);
	public ProductVO selectOne(Integer pno);
	public int update(ProductVO pvo);
	public int delete(Integer pno);
	public int selectCount();
	
}
