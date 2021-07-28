package com.oracle.springProject01.dao.cheDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.springProject01.model.ChePostVO;

@Repository
public class MainDaoImpl implements MainDao {
	@Autowired
	private SqlSession session;

	@Override
	public List<ChePostVO> bestListPost(ChePostVO post) {
		System.out.println("MainDaoImpl List<Post> bestListPost() start...");
		List<ChePostVO> postList = null;
		try {
			postList = session.selectList("bestListPost",post);
			System.out.println("post.title -> " + post.getP_title());
		} catch (Exception e) {
			System.out.println("MainDaoImpl List<Post> bestListPost() Exception->"+e.getMessage());
		}
		return postList;
	}

}
