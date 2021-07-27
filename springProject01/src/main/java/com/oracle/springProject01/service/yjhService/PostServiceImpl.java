package com.oracle.springProject01.service.yjhService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.springProject01.dao.yjhDao.PostDao;
import com.oracle.springProject01.model.Post;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao pd;

	@Override
	public int total() {
		System.out.println("PostServiceImpl int total() start...");
		int totCnt = pd.total();
		System.out.println("PostServiceImpl int total totCnt->" + totCnt);
		return totCnt;
	}

	@Override
	public List<Post> listPost(Post post) {
		System.out.println("PostServiceImpl List<Post> listPost() start...");
		List<Post> postList = null;
		postList = pd.listPost(post);
		return postList;
	}
	
	@Override
	public int postInsert(Post post) {
		System.out.println("PostServiceImpl int postInsert start...");
		int result = 0;
		post.setP_cost(post.getP_cost().replaceAll(",", ""));
		result = pd.postInsert(post);
		return result;
	}

}
