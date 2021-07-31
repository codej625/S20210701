package com.oracle.springProject01.dao.lhjDao;

import java.util.List;

import com.oracle.springProject01.model.Lhj_MemberVO;
import com.oracle.springProject01.model.Member;

public interface MemberDao {

	// 회원가입
	public void insertMember(Lhj_MemberVO lhj_MemberVO);

	// 로그인
	public Lhj_MemberVO selectLogin(Lhj_MemberVO lhj_MemberVO);

	// 마이페이지
	// 조회
	public Lhj_MemberVO selectMypage(String m_id);

	// 수정
	public void mypageUpdate(Lhj_MemberVO lhj_MemberVO);

	// 비밀번호 변경 미완
	public void myPWchange(Lhj_MemberVO lhj_MemberVO);

	// 신청내역 조회
	public List<Lhj_MemberVO> myRegInfoList(String m_id);

	// 관심내역 조회
	public List<Lhj_MemberVO> myBookMarkList(String m_id);

}
