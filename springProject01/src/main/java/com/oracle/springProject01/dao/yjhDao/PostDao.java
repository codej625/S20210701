package com.oracle.springProject01.dao.yjhDao;

import java.util.List;

import com.oracle.springProject01.model.Post;

public interface PostDao {
	int total(Post post);
	List<Post> listPost(Post post);
	int postInsert(Post post);
	int postHit(Post post);
	Post postListDetail(Post post);
	int postListUpdate(Post post);
	int postDelete(Post post);
	Post registerMember(Post post);
}
