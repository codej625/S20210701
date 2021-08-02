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


//	@Override
//	public Reply postReplyList(Reply reply) {
//		System.out.println("ReplyDaoImpl Reply postReplyList start...");
//		Reply reply2 = new Reply();
//		try {
//			reply2 = session.selectList(statement);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return null;
//	}

}
