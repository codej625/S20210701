package com.oracle.springProject01.dao.yjhDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.springProject01.model.Reply;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Reply> postReplyList(Reply reply) {
		System.out.println("ReplyDaoImpl List<Reply> postReplyList start...");
		List<Reply> postReplyList = null;
		try {
			postReplyList = session.selectList("postReplyList",reply);
		} catch (Exception e) {
			System.out.println("ReplyDaoImpl postReplyList Exception->"+e.getMessage());
		}
		return postReplyList;
	}

	@Override
	public int replyInsert(Reply reply) {
		System.out.println("ReplyDaoImpl int replyInsert start...");
		int result = 0;
		try {
			System.out.println("ReplyDaoImpl replyInsert sql start");
			result = session.insert("replyInsert",reply);
			System.out.println("ReplyDaoImpl replyInsert result -> " + result);
		} catch (Exception e) {
			System.out.println("ReplyDaoImpl replyInsert Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int replyDelete(Reply reply) {
		System.out.println("ReplyDaoImpl replyDelete start...");
		int result = 0;
		try {
			result = session.delete("replyDelete",reply);
			System.out.println("ReplyDaoImpl replyDelete result -> " + result);
		} catch (Exception e) {
			System.out.println("ReplyDaoImpl replyDelete Exception->"+e.getMessage());
		}
		return result;
	}
	
	@Override
	public int replyIndentUpdate(Reply reply) {
		System.out.println("ReplyDaoImpl replyIndentUpdate start...");
		int result1 = 0;
		try {
			result1 = session.update("replyIndentUpdate",reply);
			System.out.println("ReplyDaoImpl replyIndentUpdate result1->"+result1);
		} catch (Exception e) {
			System.out.println("ReplyDaoImpl replyIndentUpdate Exception->"+e.getMessage());
		}
		return result1;
	}

	@Override
	public int replyReplyInsert(Reply reply) {
		System.out.println("ReplyDaoImpl replyReplyInsert start...");
		int result = 0;
		try {
			result = session.insert("replyReplyInsert",reply);
			System.out.println("ReplyDaoImpl replyReplyInsert result -> " + result);
		} catch (Exception e) {
			System.out.println("ReplyDaoImpl replyReplyInsert Exception->"+e.getMessage());
		}
		return result;
	}

	


}
