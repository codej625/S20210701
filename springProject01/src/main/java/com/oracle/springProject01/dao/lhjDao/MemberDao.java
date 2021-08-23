package com.oracle.springProject01.dao.lhjDao;

import java.util.List;

import com.oracle.springProject01.model.AttachmentFile;
import com.oracle.springProject01.model.AttachmentFileVO;
import com.oracle.springProject01.model.Lhj_MemberVO;

public interface MemberDao {
	
	//회원가입
	public void insertMember(Lhj_MemberVO lhj_MemberVO);
		//회원가입 아이디 중복 확인 ajax
	public Lhj_MemberVO idOverlap(String m_id);
		//회원가입 전화번호 중복 확인 ajax
	public Lhj_MemberVO telOverlap(String m_tel);
	//로그인
	public Lhj_MemberVO selectLogin(Lhj_MemberVO lhj_MemberVO);
		//로그인 아이디 찾기
	public Lhj_MemberVO find_m_id(Lhj_MemberVO lhj_MemberVO);
		//로그인 비밀번호 찾기
	public Lhj_MemberVO find_m_pw(Lhj_MemberVO lhj_MemberVO);
	//마이페이지
		//조회
	public			Lhj_MemberVO selectMypage(String m_id);
		//수정
	public void 	mypageUpdate(Lhj_MemberVO lhj_MemberVO);
		//비밀번호 변경
	public void 	myPWchange(Lhj_MemberVO lhj_MemberVO);
		//신청내역 조회 -all
	public			List<Lhj_MemberVO> myRegInfoList(String m_id);
		//신청내역 조회 -class
	public 			List<Lhj_MemberVO> myRegInfo_classList(String m_id);
		//신청내역 조회 -meeting
	public 			List<Lhj_MemberVO> myRegInfo_meetingList(String m_id);
		//신청내역 취소
	public void		myRGNO(Lhj_MemberVO lhj_MemberVO); 
		//관심내역 조회 -all
	public			List<Lhj_MemberVO> myBookMarkList(String m_id);
		//관심내역 조회 -class
	public 			List<Lhj_MemberVO> myBookMark_classList(String m_id);
		//관심내역 조회 -meeting
	public 			List<Lhj_MemberVO> myBookMark_meetingList(String m_id);
		//관심내역에서 신청 (b_reg => y)
	public void		myBMtoRG(Lhj_MemberVO lhj_MemberVO);
		//관심내역에서 신청내역으로 insert 
	public void 	myBMtoRG2(Lhj_MemberVO lhj_MemberVO);
		//관심내역 취소
	public void 	myBMNO(Lhj_MemberVO lhj_MemberVO);
	//회원 탈퇴 (member_withdrawal => y)
	public void 	myDelMySelf2(Lhj_MemberVO lhj_MemberVO);
		//내가 쓴 글 리스트-all
	public List<Lhj_MemberVO> myPostList(String m_id);
		//내가 쓴 글 리스트-class
	public List<Lhj_MemberVO> myPostList_class(String m_id);
		//내가 쓴 글 리스트-meeting
	public List<Lhj_MemberVO> myPostList_meeting(String m_id);
		//내가 쓴 글에 신청한 회원 리스트
	public List<Lhj_MemberVO> mypage_myPostMEmberList(Lhj_MemberVO lhj_MemberVO);
		//네이버 회원가입
	public void insertMember_NaverID(Lhj_MemberVO lhj_MemberVO);
		//모임, 클래스 인증
	Lhj_MemberVO	mypage_mycertification(Lhj_MemberVO lhj_MemberVO);      
		//메일 인증
	int mail(Lhj_MemberVO lhj_MemberVO);
		//개설자 권한 인증 파일첨부 등록
	int certification(AttachmentFileVO attachmentFileVO);
		//메일 인증 확인
	AttachmentFileVO member(AttachmentFileVO attachmentFileVO);
	
	//카카오 회원가입
	public void insertMember_KAKAOID(Lhj_MemberVO lhj_MemberVO, String m_name, String m_id);
	
	
	
}