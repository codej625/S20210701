package com.oracle.springProject01.service.yjhService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.springProject01.dao.yjhDao.BoardCategoryDao;

@Service
public class BoardCategoryServiceImpl implements BoardCategoryService {
	
	@Autowired
	private BoardCategoryDao bcd;

	@Override
	public int boardCategoryNum() {
		System.out.println("BoardCategoryServiceImpl int boardCategoryNum start...");
		
		return 0;
	}
	
}
