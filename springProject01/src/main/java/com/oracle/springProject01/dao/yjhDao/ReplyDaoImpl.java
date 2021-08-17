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
	
//	댓글 리스트
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

//	댓글입력
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
	
//	맴버 평점 올려주기
	@Override
	public int memberRateUpdate(Reply reply) {
		System.out.println("ReplyDaoImpl memberRateUpdate start...");
		int result = 0;
		try {
			result = session.update("memberRateUpdate",reply);
			System.out.println("ReplyDaoImpl memberRateUpdate result -> " + result);
		} catch (Exception e) {
			System.out.println("ReplyDaoImpl memberRateUpdate Exception->"+e.getMessage());
		}
		return result;
	}
	
//	닉네임 테이블에 입력
	@Override
	public int nicknameInsert(Reply reply) {
		System.out.println("ReplyDaoImpl nicknameInsert start...");
		int result = 0;
		try {
			result = session.update("nicknameInsert",reply);
			System.out.println("ReplyDaoImpl nicknameInsert result -> " + result);
		} catch (Exception e) {
			System.out.println("ReplyDaoImpl nicknameInsert Exception->"+e.getMessage());
		}
		return result;
	}

//	닉네임 테이블에 입력이 되있으면 칭호번호 업데이트
	@Override
	public int nicknameNumUpdate(Reply reply) {
		System.out.println("ReplyDaoImpl nicknameNumUpdate start...");
		int result = 0;
		try {
			result = session.update("nicknameNumUpdate",reply);
			System.out.println("ReplyDaoImpl nicknameNumUpdate result -> " + result);
		} catch (Exception e) {
			System.out.println("ReplyDaoImpl nicknameNumUpdate Exception->"+e.getMessage());
		}
		return result;
	}

//	댓글 삭제
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
	
//	댓글 step(indent)늘려주기
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

//	대댓글 입력
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
