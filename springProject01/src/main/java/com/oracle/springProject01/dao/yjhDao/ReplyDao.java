package com.oracle.springProject01.dao.yjhDao;

import java.util.List;

import com.oracle.springProject01.model.Reply;

public interface ReplyDao {
	List<Reply> postReplyList(Reply reply);
	int replyInsert(Reply reply);
}
