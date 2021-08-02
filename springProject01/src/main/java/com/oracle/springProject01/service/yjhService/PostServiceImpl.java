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
	public int total(int bt_num, int bc_num) {
		System.out.println("PostServiceImpl int total() start...");
//		post를 생성해서 유형번호와 카테고리값을 넣어준다.
		Post post = new Post();
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		int totCnt = pd.total(post);
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
	public Post registerMember(String sessionID) {
		System.out.println("PostServiceImpl registerMember start...");
		Post post = new Post();
		post.setM_id(sessionID);
		
		Post registerMember = null;
		registerMember = pd.registerMember(post);
		return registerMember;
	}
	
	@Override
	public int postInsert(Post post) {
		System.out.println("PostServiceImpl int postInsert start...");
		int result = 0;
		post.setP_cost(post.getP_cost().replaceAll(",", ""));
		result = pd.postInsert(post);
		return result;
	}

	@Override
	public Post postListDetail(int bt_num, int bc_num, int p_num) {
		System.out.println("PostServiceImpl Post postListDetail start...");
		Post post = new Post();
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		post.setP_num(p_num);
		post = pd.postListDetail(post);
		return post;
	}

	@Override
	public int postListUpdate(Post post) {
		System.out.println("PostServiceImpl int postListUpdate start...");
		int result = 0;
		post.setP_cost(post.getP_cost().replaceAll(",", ""));
		result = pd.postListUpdate(post);
		return result;
	}

	@Override
	public int postDelete(int bt_num, int bc_num, int p_num) {
		System.out.println("PostServiceImpl int postDelete start...");
		Post post = new Post();
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		post.setP_num(p_num);
		int result = pd.postDelete(post);
		return result;
	}


}
