package com.oracle.springProject01.dao.cheDao;

import java.util.List;

import com.oracle.springProject01.model.ChePostVO;
import com.oracle.springProject01.model.Post;

public interface MainDao {
	List<Post> bestListPost(Post post);
	int searchTotal(String keyword);
	List<Post> searchPost(Post post);
}
