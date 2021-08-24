package com.oracle.springProject01.service.PmjService;





import com.oracle.springProject01.model.PmjChatVO;

public interface MemberService {


	
	PmjChatVO 			selectChat(String m_name);
	PmjChatVO 	    detail(int bt_num, int  bc_num, int p_num); 
	
	

}
