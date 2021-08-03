package com.oracle.springProject01.dao.cheDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.springProject01.model.ChePostVO;
import com.oracle.springProject01.model.Post;

@Repository
public class MainDaoImpl implements MainDao {
	@Autowired
	private SqlSession session;

	@Override
	public List<Post> bestListPost(Post post) {
		System.out.println("********* MainDaoImpl bestListPost() start *********");
		List<Post> postList = null;
		try {
			postList = session.selectList("bestListPost", post);
		} catch (Exception e) {
			System.out.println("!!!!MainDaoImpl List<Post> bestListPost() Exception->"+e.getMessage());
		}
		return postList;
	}
	
	@Override
	public int searchTotal(String keyword) {
		System.out.println("********* MainDaoImpl searchTotal() start *********");
		int total = 0;
		try {
			total = session.selectOne("searchTotal", keyword);
		} catch (Exception e) {
			System.out.println("!!!!MainDaoImpl searchTotal() Exception->"+e.getMessage());
		}
		
		return total;
	}
	
	@Override
	public List<Post> searchPost(Post post) {
		System.out.println("********* MainDaoImpl searchPost() start *********");
		List<Post> listPost = null;
		try {
			System.out.println("MainDaoImpl mainSearch keyword -> " + post.getKeyword());
			listPost = session.selectList("searchlist", post);
		} catch (Exception e) {
			System.out.println("!!!!MainDaoImpl List<Post> searchPost() Exception->"+e.getMessage());
		}
		return listPost;
	}

}
