package com.oracle.springProject01.dao.ljwDao;

import java.util.List;

import com.oracle.springProject01.model.Member;

public interface MemberDao {

	List<Member> listMember(Member member);

	int total();
	
	int masterauth(String m_id);
}
