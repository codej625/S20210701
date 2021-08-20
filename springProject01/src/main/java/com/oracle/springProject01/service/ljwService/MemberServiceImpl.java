package com.oracle.springProject01.service.ljwService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.springProject01.dao.ljwDao.MemberDao;
import com.oracle.springProject01.model.AttachmentFile;
import com.oracle.springProject01.model.Member;
import com.oracle.springProject01.model.MemberVo;

@Service("LjwService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao md;

	// 회원 리스트
	@Override
	public List<Member> memberList(Member member) {
		System.out.println("MemberServiceImpl Start memberList...");
		List<Member> memberList = md.memberList(member);
		System.out.println("MemberServiceImpl memberList.size()->" + memberList);
		return memberList;
	}

	// 회원 총 인원 알아보기
	@Override
	public int total() {
		System.out.println("MemberServiceImpl Start total...");
		int totCnt = md.total();
		System.out.println("MemberServiceImpl total totCnt->" + totCnt);
		return totCnt;
	}

	@Override
	public List<AttachmentFile> check(AttachmentFile attachmentFile) {
		System.out.println("MemberServiceImpl Start mail...");
		List<AttachmentFile> check = md.check(attachmentFile);
		return check;
	}

	// 권한 해제
	@Override
	public int user_delete(String m_id) {
		System.out.println("MemberServiceImpl Start user_delete...");
		int delete = md.user_delete(m_id);
		return delete;
	}

	@Override
	public List<Member> auth_listMember(Member member) {
		System.out.println("MemberServiceImpl Start auth_listMember...");
		List<Member> auth_listMember = md.auth_listMember(member);
		return auth_listMember;
	}

	@Override
	public int a_total() {
		System.out.println("MemberServiceImpl Start a_total...");
		int a_total = md.a_total();
		return a_total;
	}

	@Override
	public MemberVo authorityList(String m_id) {
		System.out.println("MemberServiceImpl Start authorityList...");
		MemberVo authorityList = md.authorityList(m_id);
		return authorityList;
	}

	@Override
	public int authority(MemberVo member) {
		System.out.println("MemberServiceImpl Start authority...");
		System.out.println("member.getM_meetingauth()->" + member.getM_meetingauth());
		MemberVo authority = member;
		int result = 0;
		if (authority != null) {
			if (authority.getM_meetingauth() == "N") {
				authority.setM_meetingauth("Y");
			}
			if (authority.getM_masterauth() == "N") {
				authority.setM_masterauth("Y");
			}
			System.out.println(authority.getM_masterauth());
			result = md.authority(authority);
		}
		return result;
	}

}
