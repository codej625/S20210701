package com.oracle.springProject01.dao.yjhDao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardCategoryDaoImpl implements BoardCategoryDao {
	
	@Autowired
	private SqlSession session;

}
