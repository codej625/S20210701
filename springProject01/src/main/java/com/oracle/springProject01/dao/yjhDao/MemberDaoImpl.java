package com.oracle.springProject01.dao.yjhDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.springProject01.dao.member.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public List<Member> listMember(Member member) {
		System.out.println("MemberDaoImpl List<Member> listMember start...");
		List<Member> memberList = null;
		try {
			memberList = session.selectList("memberList",member);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return memberList;
	}
}
