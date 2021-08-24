package com.oracle.springProject01.dao.yjhDao;

import java.util.List;

import com.oracle.springProject01.model.Member;


public interface MemberDao {
	List<Member> listMember(Member member);
	
	Member id(Member member);

}
