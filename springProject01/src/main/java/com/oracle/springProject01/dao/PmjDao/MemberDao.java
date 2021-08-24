package com.oracle.springProject01.dao.PmjDao;

import com.oracle.springProject01.model.PmjChatVO;

public interface MemberDao {

	PmjChatVO selectchat(String m_name);

	PmjChatVO detail(PmjChatVO pmjChatVO);

}