package com.oracle.springProject01.service.ljwService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.springProject01.dao.ljwDao.MemberDao;
import com.oracle.springProject01.model.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao md;

	@Override
	public List<Member> listMember(Member member) {
		List<Member> MemberList = null;
		System.out.println("MemberServiceImpl Start listMember...");
		MemberList = md.listMember(member);
		System.out.println("MemberServiceImpl listMember.size()->" + MemberList);
		return MemberList;
	}

	@Override
	public int total() {
		System.out.println("MemberServiceImpl Start total...");
		int totCnt = md.total();
		System.out.println("MemberServiceImpl total totCnt->" + totCnt);
		return totCnt;
	}

	@Override
	public int masterauth(String m_id) {
		System.out.println("MemberServiceImpl Start total...");
		int update = md.masterauth(m_id);
		System.out.println("MemberServiceImpl masterauth update->" + update);
		return update;
	}

}
