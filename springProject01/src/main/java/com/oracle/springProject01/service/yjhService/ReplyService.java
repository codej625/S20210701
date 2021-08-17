package com.oracle.springProject01.service.yjhService;

import java.util.List;

import com.oracle.springProject01.model.Reply;
import com.oracle.springProject01.service.paging.Paging;

public interface ReplyService {
//	댓글 리스트
	List<Reply> postReplyList(int bt_num, int bc_num, int p_num);
//	댓글 입력
	int replyInsert(Reply reply);
//	댓글 삭제
	int replyDelete(int bt_num, int bc_num, int p_num, int r_num);
//	대댓글 입력
	int replyReplyInsert(Reply reply);

}
