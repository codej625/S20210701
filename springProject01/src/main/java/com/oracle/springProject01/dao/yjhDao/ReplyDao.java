package com.oracle.springProject01.dao.yjhDao;

import java.util.List;

import com.oracle.springProject01.model.Reply;

public interface ReplyDao {
//	댓글 리스트
	List<Reply> postReplyList(Reply reply);
//	댓글 입력
	int replyInsert(Reply reply);
//	맴버 평점 업데이트
	int memberRateUpdate(Reply reply);
//	닉네임 테이블에 입력
	int nicknameInsert(Reply reply);
//	닉네임 테이블에 입력이 되있으면 칭호번호 업데이트
	int nicknameNumUpdate(Reply reply);
//	댓글 삭제
	int replyDelete(Reply reply);
//	댓글 step(indent)늘려주기
	int replyIndentUpdate(Reply reply);
//	대댓글 입력
	int replyReplyInsert(Reply reply);
}
