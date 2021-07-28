package com.oracle.springProject01.service.cheService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.springProject01.dao.cheDao.MainDao;
import com.oracle.springProject01.model.ChePostVO;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	private MainDao md;

	@Override
	public List<ChePostVO> bestListPost(ChePostVO post) {
		System.out.println("MainServiceImpl List<Post> bestListPost() start...");
		List<ChePostVO> postList = null;
		postList = md.bestListPost(post);
		return postList;
	}

}
