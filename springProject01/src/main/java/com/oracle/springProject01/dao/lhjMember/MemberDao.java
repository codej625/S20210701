package com.oracle.springProject01.dao.lhjMember;


import com.oracle.springProject01.model.Lhj_MemberVO;

public interface MemberDao {
	
	//회원가입
	public void insertMember(Lhj_MemberVO lhj_MemberVO);
	//로그인
	public Lhj_MemberVO selectLogin(Lhj_MemberVO lhj_MemberVO);
	//마이페이지
		//개인정보 조회
	public			Lhj_MemberVO selectMypage(String m_id);
	public 			Lhj_MemberVO mypageUpdate(String m_id);
	
}
