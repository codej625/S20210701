package com.oracle.springProject01.service.Lhj_login;

import com.oracle.springProject01.model.Lhj_MemberVO;

public interface MemberService {

	//회원가입
	void 					insertMember(Lhj_MemberVO lhj_MemberVO);
	//로그인
	Lhj_MemberVO 			login(Lhj_MemberVO lhj_MemberVO);
	//마이페이지
		//개인정보 조회
	Lhj_MemberVO 			selectMypage(String m_id);
	Lhj_MemberVO 			mypageUpdate(String m_id);

	

}
