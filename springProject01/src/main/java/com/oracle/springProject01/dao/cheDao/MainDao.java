package com.oracle.springProject01.dao.cheDao;

import java.util.List;

import com.oracle.springProject01.model.ChePostVO;
import com.oracle.springProject01.model.Lhj_MemberVO;
import com.oracle.springProject01.model.Post;
import com.oracle.springProject01.model.RecentPost;

public interface MainDao {
	List<Post> bestListPost(Post post);
	int searchTotal(String keyword);
	List<Post> searchPost(Post post);
	int cntRecentPost(String m_id);
	void insertRecentPost(RecentPost rpost);
	List<RecentPost> recentPostList(RecentPost rpost);
	List<RecentPost> imgList(RecentPost postImg);
	Lhj_MemberVO main_select(Lhj_MemberVO lhj_MemberVO);

}
