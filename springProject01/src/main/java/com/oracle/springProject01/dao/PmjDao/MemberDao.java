package com.oracle.springProject01.dao.PmjDao;


     

import com.oracle.springProject01.model.PmjChatVO;

public interface MemberDao {

	//마이페이지 조회
	public			PmjChatVO selectchat(String m_name);
}