package com.oracle.springProject01.service.ljwService;

import java.util.List;

import com.oracle.springProject01.model.AttachmentFile;
import com.oracle.springProject01.model.AttachmentFileVO;
import com.oracle.springProject01.model.Member;

public interface MemberService {

	List<Member> listMember(Member member);

	int total();

	int masterauth(String m_id);

	List<AttachmentFileVO> test(AttachmentFileVO attachmentFileVO);

	List<AttachmentFile> check(AttachmentFile attachmentFile);
	
	int user_delete(String m_id);


}
