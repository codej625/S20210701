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
	public int total(Post post) {
		System.out.println("PostDaoImpl int total() start...");
		int tot = 0;
		try {
			tot = session.selectOne("total",post);
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
	
	@Override
	public Post registerMember(Post post) {
		System.out.println("PostDaoImpl registerMember start...");
		Post registerMember = null;
		try {
			registerMember = session.selectOne("registerMember",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl registerMember Exception->"+e.getMessage());
		}
		return registerMember;
	}

	@Override
	public int postInsert(Post post) {
		System.out.println("PostDaoImpl int postInsert start...");
		int result = 0;
		try {
			result = session.insert("postInsert",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl int postInsert Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int postHit(Post post) {
		System.out.println("PostDaoImpl int postHit start...");
		int result = 0;
		try {
			result = session.update("postHit",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl int postHit Exception->"+e.getMessage());
		}
		return result;
	}
	
	@Override
	public Post postListDetail(Post post) {
		System.out.println("PostDaoImpl Post postListDetail start...");
		Post post1 = new Post();
		try {
			post1 = session.selectOne("postListDetail",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl Post postListDetail Exception->"+e.getMessage());
		}
		return post1;
	}

	@Override
	public int postListUpdate(Post post) {
		System.out.println("PostDaoImpl int postListUpdate start...");
		int result = 0;
		try {
			result = session.update("postListUpdate", post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl int postListUpdate Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int postDelete(Post post) {
		System.out.println("PostDaoImpl int postDelete start...");
		int result = 0;
		try {
			result = session.delete("postDelete",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl int postListUpdate Exception->"+e.getMessage());
		}
		return result;
	}

}
