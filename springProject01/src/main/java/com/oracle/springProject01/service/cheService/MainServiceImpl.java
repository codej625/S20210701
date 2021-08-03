package com.oracle.springProject01.service.cheService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.springProject01.dao.cheDao.MainDao;
import com.oracle.springProject01.model.ChePostVO;
import com.oracle.springProject01.model.Post;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	private MainDao md;

	// main.jsp best 게시물 list
	@Override
	public List<Post> bestListPost(Post post) {
		System.out.println("********* MainServiceImpl bestListPost() start *********");
		List<Post> postList = null;
		postList = md.bestListPost(post);
		
		return postList;
	}
	
	//
	@Override
	public int searchTotal(String keyword) {
		System.out.println("********* MainServiceImpl searchTotal() start *********");
		int total = 0;
		total = md.searchTotal(keyword);
		
		return total;
	}
	
	@Override
	public List<Post> searchPost(Post post) {
		System.out.println("********* MainServiceImpl searchPost() start *********");
		List<Post> listPost = null;
		System.out.println("MainServiceImpl mainSearch keyword -> " + post.getKeyword());
		listPost = md.searchPost(post);
		
		return listPost;
	}

}
