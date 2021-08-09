package com.oracle.springProject01.service.lhjService;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.oracle.springProject01.model.Lhj_MemberVO;

public interface MemberService {

	//회원가입
	void 					insertMember(Lhj_MemberVO lhj_MemberVO);
		//회원가입 아이디 중복 확인 ajax
	void idOverlap(String m_id, HttpServletResponse response) throws IOException;
		//회원가입 핸드폰번호 중복 확인 ajax
	void telOverlap(String m_tel, HttpServletResponse response) throws IOException;
	//로그인
	Lhj_MemberVO 			login(Lhj_MemberVO lhj_MemberVO);
		//로그인 아이디 찾기
	Lhj_MemberVO			find_m_id(Lhj_MemberVO lhj_MemberVO);
		//로그인 비밀번호 찾기
	Lhj_MemberVO 			find_m_pw(Lhj_MemberVO lhj_MemberVO);
	//마이페이지
		//개인정보 조회
	Lhj_MemberVO 			selectMypage(String m_id);
		//개인정보 수정
	Lhj_MemberVO 			mypageUpdate(Lhj_MemberVO lhj_MemberVO);
		//비밀번호 변경
	Lhj_MemberVO			myPWchange(Lhj_MemberVO lhj_MemberVO);
		//개인정보 신청내역 조회 -all
	List<Lhj_MemberVO> 		myRegInfoList(String m_id);
		//개인정보 신청내역 조회 - class
	List<Lhj_MemberVO> 		myRegInfo_classList(String m_id);
		//개인정보 신청내역 조회 - meeting
	List<Lhj_MemberVO> 		myRegInfo_meetingList(String m_id);
		//신청내역 취소
	Lhj_MemberVO 			myRGNO(Lhj_MemberVO lhj_MemberVO);
		//관심내역 조회
	List<Lhj_MemberVO> 		myBookMarkList(String m_id);
		//관심내역 조회 - class
	List<Lhj_MemberVO> 		myBookMark_classList(String m_id);
		//관심내역 조회 - meeting
	List<Lhj_MemberVO> 		myBookMark_meetingList(String m_id);
		//관심내역에서 신청 (b_reg => y)
	Lhj_MemberVO 			myBMtoRG(Lhj_MemberVO lhj_MemberVO);
		//관심내역에서 신청내역으로 insert 
	Lhj_MemberVO 			myBMtoRG2(Lhj_MemberVO lhj_MemberVO);
		//관심내역 취소 
	Lhj_MemberVO 			myBMNO(Lhj_MemberVO lhj_MemberVO);
		//회원 탈퇴 (member_withdrawal => y)
	Lhj_MemberVO 			myDelMySelf2(Lhj_MemberVO lhj_MemberVO);
	
		//내가 쓴 글 리스트 -all
	List<Lhj_MemberVO> myPostList(String m_id);
		//내가 쓴 글 리스트 -class
	List<Lhj_MemberVO> myPostList_class(String m_id);
		//내가 쓴 글 리스트 -meeting
	List<Lhj_MemberVO> myPostList_meeting(String m_id);
	
		//내가 쓴 글 리스트에 대한 신청 인원 정보
	List<Lhj_MemberVO> 		mypage_myPostMEmberList(Lhj_MemberVO lhj_MemberVO);
	
	
	
	
	
	
	
	 
	
	

	
	
	 
	

}
