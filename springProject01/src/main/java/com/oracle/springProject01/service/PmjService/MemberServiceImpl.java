package com.oracle.springProject01.service.PmjService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.springProject01.dao.PmjDao.MemberDao;

import com.oracle.springProject01.model.PmjChatVO;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao md; 

	@Override
	public PmjChatVO selectChat(String m_name) {
		System.out.println("service pmjService memberserviceImpl selectChat start...");
		PmjChatVO pmjChatVO = null;
		pmjChatVO = md.selectchat(m_name);
		return pmjChatVO;
	}
	
}
