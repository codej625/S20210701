package com.oracle.springProject01.dao.cheDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.springProject01.model.ChePostVO;
import com.oracle.springProject01.model.Lhj_MemberVO;
import com.oracle.springProject01.model.Post;
import com.oracle.springProject01.model.RecentPost;

@Repository
public class MainDaoImpl implements MainDao {
	@Autowired
	private SqlSession session;

	@Override
	public List<Post> bestListPost(Post post) {
		System.out.println("********* MainDaoImpl bestListPost() start *********");
		List<Post> postList = null;
		try {
			postList = session.selectList("bestListPost", post);
		} catch (Exception e) {
			System.out.println("!!!!MainDaoImpl bestListPost() Exception->" + e.getMessage());
		}
		return postList;
	}

	@Override
	public int searchTotal(String keyword) {
		System.out.println("********* MainDaoImpl searchTotal() start *********");
		int total = 0;
		try {
			total = session.selectOne("searchTotal", keyword);
		} catch (Exception e) {
			System.out.println("!!!!MainDaoImpl searchTotal() Exception->" + e.getMessage());
		}

		return total;
	}

	@Override
	public List<Post> searchPost(Post post) {
		System.out.println("********* MainDaoImpl searchPost() start *********");
		List<Post> listPost = null;
		try {
			System.out.println("MainDaoImpl mainSearch keyword -> " + post.getKeyword());
			listPost = session.selectList("searchlist", post);
		} catch (Exception e) {
			System.out.println("!!!!MainDaoImpl searchPost() Exception->" + e.getMessage());
		}
		return listPost;
	}

	@Override
	public int cntRecentPost(String m_id) {
		System.out.println("********* MainDaoImpl cntRecentPost() start *********");
		int total = 0;

		try {
			total = session.selectOne("cntRecent", m_id);
			System.out.println("MainDaoImpl cntRecentPost total -> " + total);
		} catch (Exception e) {
			System.out.println("!!!!MainDaoImpl cntRecentPost() Exception->" + e.getMessage());
		}

		return total;
	}

	@Override
	public void insertRecentPost(RecentPost rpost) {
		System.out.println("********* MainDaoImpl insertRecentPost() start *********");
		try {
			session.insert("insertRecent", rpost);
			System.out.println("insertRecentPost session success!");
		} catch (Exception e) {
			System.out.println("!!!!MainDaoImpl insertRecentPost() Exception->" + e.getMessage());
		}
	}

	@Override
	public List<RecentPost> recentPostList(RecentPost rpost) {
		System.out.println("********* MainDaoImpl recentPostList() start *********");
		List<RecentPost> listRpost = null;
		try {
			listRpost = session.selectList("Recentlist", rpost);
			System.out.println("MainDaoImpl recentPostList listRpost size -> " + listRpost.size());
		} catch (Exception e) {
			System.out.println("!!!!MainDaoImpl recentPostList() Exception->" + e.getMessage());
		}

		return listRpost;
	}

	@Override
	public List<RecentPost> imgList(RecentPost postImg) {
		System.out.println("********* MainDaoImpl recentPostList() start *********");
		List<RecentPost> imgList = null;
		try {
			imgList = session.selectList("ImgList", postImg);
			System.out.println("MainDaoImpl recentPostList listRpost size -> " + imgList.size());
		} catch (Exception e) {
			System.out.println("!!!!MainDaoImpl recentPostList() Exception->" + e.getMessage());
		}

		return imgList;
	}

	@Override
	public Lhj_MemberVO main_select(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("********* MainDaoImpl main_select() start *********");
		Lhj_MemberVO main_select = null;
		try {
			main_select = session.selectOne("MainSelect", lhj_MemberVO);
		} catch (Exception e) {
			System.out.println("!!!!MainDaoImpl main_select() Exception->" + e.getMessage());
		}

		return main_select;
	}

}
