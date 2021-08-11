package com.oracle.springProject01.dao.ljwDao;

import java.util.List;

import com.oracle.springProject01.model.AttachmentFile;
import com.oracle.springProject01.model.AttachmentFileVO;
import com.oracle.springProject01.model.Member;

public interface MemberDao {

	List<Member> listMember(Member member);

	int total();

	int masterauth(String m_id);

	List<AttachmentFileVO> test(String string);

	List<AttachmentFile> check(AttachmentFile attachmentFile);

	int test2(AttachmentFile attachmentFileTest);
}
