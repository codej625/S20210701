package com.oracle.springProject01.service.cheService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.springProject01.dao.cheDao.MainDao;
import com.oracle.springProject01.model.ChePostVO;
import com.oracle.springProject01.model.Lhj_MemberVO;
import com.oracle.springProject01.model.Post;
import com.oracle.springProject01.model.RecentPost;

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

	// 검색 개수 조회
	@Override
	public int searchTotal(String keyword) {
		System.out.println("********* MainServiceImpl searchTotal() start *********");
		int total = 0;
		total = md.searchTotal(keyword);

		return total;
	}

	// 검색
	@Override
	public List<Post> searchPost(Post post) {
		System.out.println("********* MainServiceImpl searchPost() start *********");
		List<Post> listPost = null;
		System.out.println("MainServiceImpl mainSearch keyword -> " + post.getKeyword());
		listPost = md.searchPost(post);

		return listPost;
	}

	// 최근 본 게시물 삽입
	@Override
	public void insertRecentPost(RecentPost rpost) {
		System.out.println("********* MainServiceImpl insertRecentPost() start *********");
		System.out.println("MainServiceImpl insertRecentPost bt_num" + rpost.getBt_num());
		System.out.println("MainServiceImpl insertRecentPost bc_num" + rpost.getBc_num());
		System.out.println("MainServiceImpl insertRecentPost p_num" + rpost.getP_num());
		System.out.println("MainServiceImpl insertRecentPost rp_cnt" + rpost.getRp_cnt());
		System.out.println("MainServiceImpl insertRecentPost m_id" + rpost.getM_id());
		md.insertRecentPost(rpost);
	}

	@Override
	public int cntRecentPost(String m_id) {
		System.out.println("********* MainServiceImpl cntRecentPost() start *********");
		int total = 0;
		total = md.cntRecentPost(m_id);
		System.out.println("MainServiceImpl cntRecentPost total -> " + total);

		return total;
	}

	@Override
	public List<RecentPost> recentPostList(RecentPost rpost) {
		System.out.println("********* MainServiceImpl recentPostList() start *********");
		List<RecentPost> listRpost = null;
		listRpost = md.recentPostList(rpost);
		System.out.println("MainDaoImpl recentPostList listRpost size -> " + listRpost.size());

		return listRpost;
	}

	@Override
	public List<RecentPost> imgList(RecentPost postImg) {
		System.out.println("********* MainServiceImpl imgList() start *********");
		List<RecentPost> imgList = null;
		imgList = md.recentPostList(postImg);
		System.out.println("MainDaoImpl imgList imgList size -> " + imgList.size());

		return imgList;
	}

	@Override
	public Lhj_MemberVO main_select(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("********* MainServiceImpl main_select() start *********");
		lhj_MemberVO = md.main_select(lhj_MemberVO);
		return lhj_MemberVO;
	}

}
