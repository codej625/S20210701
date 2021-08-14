package com.oracle.springProject01.service.cheService;

import java.util.List;

import com.oracle.springProject01.model.ChePostVO;
import com.oracle.springProject01.model.Post;
import com.oracle.springProject01.model.RecentPost;

public interface MainService {
	List<Post> bestListPost(Post post);
	int searchTotal(String keyword);
	List<Post> searchPost(Post post);
	int cntRecentPost(String m_id);
	void insertRecentPost(RecentPost rpost);
	List<RecentPost> recentPostList(RecentPost rpost);
}
