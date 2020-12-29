package com.donate.persistence;

import java.util.List;


import com.donate.domain.InsVO;

public interface InsDAO {
	public int insert(InsVO ivo);
	public List<InsVO> getList();
	public InsVO selectOne(Integer ino);
	public int update(InsVO ivo);
	public int delete(Integer ino);
}
