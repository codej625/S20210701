package com.oracle.springProject01.service.yjhService;

import java.util.List;

import com.oracle.springProject01.model.Reply;
import com.oracle.springProject01.service.paging.Paging;

public interface ReplyService {
	List<Reply> postReplyList(int bt_num, int bc_num, int p_num);
	int replyInsert(Reply reply);

}
