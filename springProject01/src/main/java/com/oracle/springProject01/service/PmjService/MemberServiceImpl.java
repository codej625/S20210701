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



	@Override
	public PmjChatVO detail(int bt_num, int bc_num, int p_num) {
		System.out.println("PmjServiceImpl detail ...");
		PmjChatVO pmjChatVO = new PmjChatVO();
		pmjChatVO.setBt_num(bt_num);
		pmjChatVO.setBc_num(bc_num);
		pmjChatVO.setP_num(p_num);
		pmjChatVO = md.detail(pmjChatVO);
		return pmjChatVO;
	}
	
	
	
}
