package com.oracle.springProject01.dao.yjhDao;

import java.util.List;

import com.oracle.springProject01.model.Post;

public interface PostDao {
	int total();
	List<Post> listPost(Post post);
}
