package com.oracle.springProject01.service.yjhService;

import java.util.List;

import com.oracle.springProject01.model.Post;

public interface PostService {
	int total();
	List<Post> listPost(Post post);
}
