package com.oracle.springProject01.service.yjhService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.springProject01.dao.yjhDao.MemberDao;
import com.oracle.springProject01.model.Member;

@Service("YjhService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao md;

	@Override
	public List<Member> listMember(Member member) {
		System.out.println("MemberServiceImpl List<Member> listMember start...");
		List<Member> memberList = null;
		memberList = md.listMember(member);
		return memberList;
	}

	@Override
	public Member id(Member member) {
		System.out.println("MemberServiceImpl Member id start...");
		member = md.id(member);
		return member;
	}

}
