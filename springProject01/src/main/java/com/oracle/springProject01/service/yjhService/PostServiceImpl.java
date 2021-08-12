package com.oracle.springProject01.service.yjhService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.springProject01.dao.yjhDao.PostDao;
import com.oracle.springProject01.model.Post;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao pd;

//	게시물 갯수 가져오기
	@Override
	public int total(int bt_num, int bc_num) {
		System.out.println("PostServiceImpl int total() start...");
//		post를 생성해서 유형번호와 카테고리값을 넣어준다.
		Post post = new Post();
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		int totCnt = pd.total(post);
		System.out.println("PostServiceImpl int total totCnt->" + totCnt);
		return totCnt;
	}

//	게시물 리스트 가져오기
	@Override
	public List<Post> listPost(Post post) {
		System.out.println("PostServiceImpl List<Post> listPost() start...");
		List<Post> postList = null;
		postList = pd.listPost(post);
		return postList;
	}
	
//	로그인되어있는 아이디 가져오기
	@Override
	public Post registerMember(String sessionID) {
		System.out.println("PostServiceImpl registerMember start...");
		Post post = new Post();
		post.setM_id(sessionID);
		
		Post registerMember = null;
		registerMember = pd.registerMember(post);
		return registerMember;
	}
	
//	게시물 작성하기
	@Override
	public int postInsert(Post post) {
		System.out.println("PostServiceImpl int postInsert start...");
		int result = 0;
		post.setP_cost(post.getP_cost().replaceAll(",", ""));
		result = pd.postInsert(post);
		return result;
	}
	
//	신청했는지 안했는지 확인
	@Override
	public int regInfoCheck(String m_id,int bt_num, int bc_num, int p_num) {
		System.out.println("PostServiceImpl int regInfoCheck start...");
		int result = 0;
		Post post = new Post();
		post.setM_id(m_id);
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		post.setP_num(p_num);
		System.out.println("post.getM_id()->"+post.getM_id());
		System.out.println("post.getBt_num()->"+post.getBt_num());
		System.out.println("post.getBc_num()->"+post.getBc_num());
		result = pd.regInfoCheck(post);
		return result;
	}
	
//	게시물을 찜 했는지 안했는지 확인
	@Override
	public int bookmarkCheck(String m_id, int bt_num, int bc_num, int p_num) {
		System.out.println("PostServiceImpl bookmarkCheck start...");
		int result = 0;
		Post post = new Post();
		post.setM_id(m_id);
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		post.setP_num(p_num);
		System.out.println("post.getM_id()->"+post.getM_id());
		System.out.println("post.getBt_num()->"+post.getBt_num());
		System.out.println("post.getBc_num()->"+post.getBc_num());
		result = pd.bookmarkCheck(post);
		return result;
	}

//	조회수 증가
	@Override
	public int postHit(int bt_num, int bc_num, int p_num) {
		System.out.println("PostServiceImpl Post postHit start...");
		int result = 0;
		Post post = new Post();
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		post.setP_num(p_num);
		result = pd.postHit(post);
		return result;
	}
	
//	게시물 내용보기
	@Override
	public Post postListDetail(int bt_num, int bc_num, int p_num) {
		System.out.println("PostServiceImpl Post postListDetail start...");
		Post post = new Post();
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		post.setP_num(p_num);
		post = pd.postListDetail(post);
		return post;
	}

//	게시물 수정하기
	@Override
	public int postListUpdate(Post post) {
		System.out.println("PostServiceImpl int postListUpdate start...");
		int result = 0;
		post.setP_cost(post.getP_cost().replaceAll(",", ""));
		result = pd.postListUpdate(post);
		return result;
	}

//	게시물 삭제
	@Override
	public int postDelete(int bt_num, int bc_num, int p_num) {
		System.out.println("PostServiceImpl int postDelete start...");
		Post post = new Post();
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		post.setP_num(p_num);
		int result = pd.postDelete(post);
		return result;
	}

//	게시물 신청하기
	@Override
	public int postRegInfoInsert(String m_id, int bt_num, int bc_num, int p_num) {
		System.out.println("PostServiceImpl postRegInfoInsert start...");
		int result = 0;
		Post post = new Post();
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		post.setP_num(p_num);
		post.setM_id(m_id);
		result = pd.postRegInfoInsert(post);
		return result;
	}

//	게시물 신청하면 p_capa값 마이너스 해주기
	@Override
	public int postCapaMinusUpdate(int bt_num, int bc_num, int p_num) {
		System.out.println("PostServiceImpl postCapaMinusUpdate start...");
		int result = 0;
		Post post = new Post();
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		post.setP_num(p_num);
		result = pd.postCapaMinusUpdate(post);
		return result;
	}

//	게시물 신청 취소하기
	@Override
	public int postRegInfoDelete(String m_id, int bt_num, int bc_num, int p_num) {
		System.out.println("PostServiceImpl postRegInfoDelete start...");
		int result = 0;
		Post post = new Post();
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		post.setP_num(p_num);
		post.setM_id(m_id);
		result = pd.postRegInfoDelete(post);
		return result;
	}

//	게시물 신청하면 p_capa값 플러스 해주기
	@Override
	public int postCapaPlusUpdate(int bt_num, int bc_num, int p_num) {
		System.out.println("PostServiceImpl postCapaPlusUpdate start...");
		int result = 0;
		Post post = new Post();
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		post.setP_num(p_num);
		result = pd.postCapaPlusUpdate(post);
		return result;
	}

//	게시물 찜하기
	@Override
	public int postBookmarkInsert(String m_id, int bt_num, int bc_num, int p_num) {
		System.out.println("PostServiceImpl postBookmarkInsert start...");
		int result = 0;
		Post post = new Post();
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		post.setP_num(p_num);
		post.setM_id(m_id);
		result = pd.postBookmarkInsert(post);
		return result;
	}

//	게시물 찜 취소하기
	@Override
	public int postBookmarkDelete(String m_id, int bt_num, int bc_num, int p_num) {
		System.out.println("PostServiceImpl postBookmarkInsert start...");
		int result = 0;
		Post post = new Post();
		post.setBt_num(bt_num);
		post.setBc_num(bc_num);
		post.setP_num(p_num);
		post.setM_id(m_id);
		result = pd.postBookmarkDelete(post);
		return result;
	}


}
