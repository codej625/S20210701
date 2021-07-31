package com.oracle.springProject01.dao.yjhDao;

import java.util.List;

import com.oracle.springProject01.dao.member.Member;

public interface MemberDao {
	List<Member> listMember(Member member);

}
