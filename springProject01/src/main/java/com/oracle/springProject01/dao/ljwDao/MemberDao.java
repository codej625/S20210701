package com.oracle.springProject01.dao.ljwDao;

import java.util.List;

import com.oracle.springProject01.model.AttachmentFile;
import com.oracle.springProject01.model.Member;
import com.oracle.springProject01.model.MemberVo;

public interface MemberDao {

	List<Member> memberList(Member member);

	int total();

	List<AttachmentFile> check(AttachmentFile attachmentFile);

	int user_delete(String m_id);

	List<Member> auth_listMember(Member member);

	int a_total();

	MemberVo authorityList(MemberVo memberVo);

	int authority(MemberVo member_list);

}
