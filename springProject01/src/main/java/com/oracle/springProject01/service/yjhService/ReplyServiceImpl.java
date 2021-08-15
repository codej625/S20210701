package com.oracle.springProject01.service.yjhService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.springProject01.dao.yjhDao.ReplyDao;
import com.oracle.springProject01.model.Reply;
import com.oracle.springProject01.service.paging.Paging;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDao rd;

	@Override
	public List<Reply> postReplyList(int bt_num, int bc_num, int p_num) {
		System.out.println("ReplyServiceImpl List<Reply> postReplyList start...");
		List<Reply> postReplyList = null;
		Reply reply = new Reply();
		reply.setBt_num(bt_num);
		reply.setBc_num(bc_num);
		reply.setP_num(p_num);
		postReplyList = rd.postReplyList(reply);
		
//		Reply reply = new Reply();
//		reply.setBt_num(BT_NUM);
//		REPLY.SETBC_NUM(BC_NUM);
//		REPLY.SETP_NUM(P_NUM);
//		List<Reply> = rd.postReplyList(reply);
//		reply = rd.postReplyList(reply);
		return postReplyList;
	}

	@Override
	public int replyInsert(Reply reply) {
		System.out.println("ReplyServiceImpl int replyInsert start...");
		int result = 0;
		result = rd.replyInsert(reply);
		return result;
	}

	@Override
	public int replyDelete(int bt_num, int bc_num, int p_num, int r_num) {
		System.out.println("ReplyServiceImpl replyDelete start...");
		int result = 0;
		Reply reply = new Reply();
		reply.setBt_num(bt_num);
		reply.setBc_num(bc_num);
		reply.setP_num(p_num);
		reply.setR_num(r_num);
		result = rd.replyDelete(reply);
		return result;
	}

	@Override
	public int replyReplyInsert(Reply reply) {
		System.out.println("ReplyServiceImpl replyIndentUpdate start...");
		int result = 0;
		int result1 = 0;
//		r_indent(들여쓰기) 업데이트
		result1 = rd.replyIndentUpdate(reply);
		System.out.println("ReplyServiceImpl replyReplyInsert start...");
//		대댓글 등록
		result = rd.replyReplyInsert(reply); 
		return result;
	}


}