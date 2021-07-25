package com.oracle.springProject01.dao.post;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.springProject01.model.Post;

@Repository
public class chePostDaoImpl implements chePostDao {
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Post> postSelect() {
		List<Post> postList = null;
		System.out.println("***** PostDaoImpl postSelect Start *****");
		postList = session.selectList("TkSelectPost");
		System.out.println("PostDaoImpl postSelect postList.size() -> " + postList.size());
		return postList;
	}
}
