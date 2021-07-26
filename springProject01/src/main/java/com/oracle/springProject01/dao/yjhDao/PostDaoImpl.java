package com.oracle.springProject01.dao.yjhDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.springProject01.model.Post;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	private SqlSession session;

	@Override
	public int total() {
		System.out.println("PostDaoImpl int total() start...");
		int tot = 0;
		try {
			tot = session.selectOne("total");
		} catch (Exception e) {
			System.out.println("PostDaoImpl int total Exception->" + e.getMessage());
		}
		return tot;
	}

	@Override
	public List<Post> listPost(Post post) {
		System.out.println("PostDaoImpl List<Post> listPost() start...");
		List<Post> postList = null;
		try {
			postList = session.selectList("postList",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl List<Post> listPost() Exception->"+e.getMessage());
		}
		return postList;
	}

}
