package com.oracle.springProject01.service.yjhService;

import java.util.List;

import com.oracle.springProject01.model.Post;

public interface PostService {
	int total(int bt_num, int bc_num);
	List<Post> listPost(Post post);
	int postInsert(Post post);
}
