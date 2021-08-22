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
	public MemberVo authorityList(MemberVo member) {
		System.out.println("MemberServiceImpl Start authorityList...");

		return md.authorityList(member);
	}

	@Override
	public int authority(MemberVo memberVo) {
		System.out.println("MemberServiceImpl Start authority...");
		int result;

		if (memberVo.getM_meetingauth().equals("N")) {
			memberVo.setM_meetingauth("Y");
			System.out.println("1번 탔당");
		}
		if (memberVo.getM_masterauth().equals("M")) {
			memberVo.setM_masterauth("M");
			System.out.println("2번 탔당");
		}
		if (memberVo.getM_masterauth().equals("N")) {
			memberVo.setM_masterauth("Y");
			System.out.println("3번 탔당");
		}
		if (memberVo.getM_meetingauth().equals("M")) {
			memberVo.setM_meetingauth("M");
			System.out.println("4번 탔당");
		}
//		if (memberVo.getM_meetingauth().equals(null)) {
//			memberVo.setM_meetingauth("M");
//			System.out.println("5번 탔당");
//		}
//		if (memberVo.getM_meetingauth().equals(null)) {
//			memberVo.setM_meetingauth("M");
//			System.out.println("6번 탔당");
//		}
		// 값이 if문을 타고 변경 되었는지 확인
		System.out.println("MemberServiceImpl member.getM_meetingauth()->" + memberVo.getM_meetingauth());
		System.out.println("MemberServiceImpl member.getM_masterauth()->" + memberVo.getM_masterauth());

		return result = md.authority(memberVo);
	}

	@Override
	public int authority2(MemberVo memberVo) {
		System.out.println("MemberServiceImpl Start authority2...");
		int result;

		if (memberVo.getM_meetingauth().equals("N")) {
			memberVo.setM_meetingauth("Y");
			System.out.println("1-1번 탔당");
		}
		if (memberVo.getM_meetingauth().equals("M")) {
			memberVo.setM_meetingauth("N");
			System.out.println("1-2번 탔당");
		}
		if (memberVo.getM_masterauth().equals("N")) {
			memberVo.setM_masterauth("Y");
			System.out.println("2-1번 탔당");
		}
		if (memberVo.getM_masterauth().equals("M")) {
			memberVo.setM_masterauth("N");
			System.out.println("2-2번 탔당");
		}
		// 값이 if문을 타고 변경 되었는지 확인
		System.out.println("MemberServiceImpl member.getM_meetingauth()->" + memberVo.getM_meetingauth());
		System.out.println("MemberServiceImpl member.getM_masterauth()->" + memberVo.getM_masterauth());

		return result = md.authority(memberVo);
	}

}
