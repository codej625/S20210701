package com.oracle.springProject01.dao.yjhDao;

import java.util.List;

import com.oracle.springProject01.model.Post;

public interface PostDao {
//	게시물 갯수 가져오기
	int total(Post post);
//	게시물 리스트
	List<Post> listPost(Post post);
//	로그인한 정보가져오기
	Post registerMember(Post post);
//	게시물 작성하기
	int postInsert(Post post);
//	게시물을 신청 했는지 안했는지 확인
	int regInfoCheck(Post post);
//	조회수 증가해주기
	int postHit(Post post);
//	게시물 상세정보
	Post postListDetail(Post post);
//	게시물 수정하기
	int postListUpdate(Post post);
//	게시물 삭제하기
	int postDelete(Post post);
//	게시물 신청하기
	int postRegInfoInsert(Post post);
//	게시물 신청하면 p_capa값 마이너스 해주기
	int postCapaMinusUpdate(Post post);
//	게시물 신청 취소하기
	int postRegInfoDelete(Post post);
//	게시물 신청하면 p_capa값 플러스 해주기
	int postCapaPlusUpdate(Post post);
}
