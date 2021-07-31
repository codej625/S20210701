package com.oracle.springProject01.service.ljwService;

import java.util.List;

import com.oracle.springProject01.model.Member;

public interface MemberService {

	List<Member> listMember(Member member);

	int total();

	int masterauth(String m_id);
}
