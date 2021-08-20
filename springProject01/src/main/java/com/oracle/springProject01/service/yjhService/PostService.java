package com.oracle.springProject01.service.yjhService;

import java.util.List;

import com.oracle.springProject01.model.Post;

public interface PostService {
//	게시물 갯수 가져오기
	int total(int bt_num, int bc_num, String keyword);
//	게시물 리스트
	List<Post> listPost(Post post);
//	로그인한 정보가져오기
	Post registerMember(String sessionID);
//	게시물 작성하기
	int postInsert(Post post);
//	게시물을 신청 했는지 안했는지 확인
	int regInfoCheck(String m_id,int bt_num, int bc_num, int p_num);
//	게시물을 찜 했는지 안했는지 확인
	int bookmarkCheck(String m_id,int bt_num, int bc_num, int p_num);
//	조회수 증가해주기
	int postHit(int bt_num, int bc_num, int p_num);
//	게시물 상세정보
	Post postListDetail(int bt_num, int bc_num, int p_num);
//	게시물 수정하기
	int postListUpdate(Post post);
//	게시물 삭제하기
	int postDelete(int bt_num, int bc_num, int p_num);
//	게시물 신청하기
	int postRegInfoInsert(String m_id,int bt_num, int bc_num, int p_num,String p_cstatus);
//	게시물 신청하면 p_capa값 마이너스 해주기
	int postCapaMinusUpdate(int bt_num, int bc_num, int p_num);
//	게시물 신청 취소하기
	int postRegInfoDelete(String m_id,int bt_num, int bc_num, int p_num);
//	게시물 신청하면 p_capa값 플러스 해주기
	int postCapaPlusUpdate(int bt_num, int bc_num, int p_num);
//	게시물 찜하기
	int postBookmarkInsert(String m_id,int bt_num, int bc_num, int p_num);
//	게시물 찜 취소하기
	int postBookmarkDelete(String m_id,int bt_num, int bc_num, int p_num);
}
