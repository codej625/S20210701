package com.oracle.springProject01.service.lhjService;

import java.util.List;

import com.oracle.springProject01.model.Lhj_MemberVO;

public interface MemberService {

	//회원가입
	void 					insertMember(Lhj_MemberVO lhj_MemberVO);
	//로그인
	Lhj_MemberVO 			login(Lhj_MemberVO lhj_MemberVO);
	//마이페이지
		//개인정보 조회
	Lhj_MemberVO 			selectMypage(String m_id);
		//개인정보 수정
	Lhj_MemberVO 			mypageUpdate(Lhj_MemberVO lhj_MemberVO);
		//비밀번호 변경 미완
	Lhj_MemberVO			myPWchange(Lhj_MemberVO lhj_MemberVO);
		//개인정보 신청내역 조회
	List<Lhj_MemberVO> 		myRegInfoList(String m_id);
		//신청내역 취소
	Lhj_MemberVO 			myRGNO(Lhj_MemberVO lhj_MemberVO);
		//관심내역 조회
	List<Lhj_MemberVO> myBookMarkList(String m_id);
		//관심내역에서 신청 (b_reg => y)
	Lhj_MemberVO 			myBMtoRG(Lhj_MemberVO lhj_MemberVO);
		//관심내역에서 신청내역으로 insert 
	Lhj_MemberVO 			myBMtoRG2(Lhj_MemberVO lhj_MemberVO);
		//관심내역 취소 
	Lhj_MemberVO 			myBMNO(Lhj_MemberVO lhj_MemberVO);
	 
	

}
