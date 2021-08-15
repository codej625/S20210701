package com.oracle.springProject01.service.PmjService;




import com.oracle.springProject01.model.PmjChatVO;

public interface MemberService {


	//마이페이지
		//개인정보 조회
	PmjChatVO 			selectChat(String m_name);
	
	

}
