package com.oracle.springProject01.service.yjhService;

import java.util.List;

import com.oracle.springProject01.model.Member;


public interface MemberService {
	List<Member> listMember(Member member);

	Member id(Member member);

}
