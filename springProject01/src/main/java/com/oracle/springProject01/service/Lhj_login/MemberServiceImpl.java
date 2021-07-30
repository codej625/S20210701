package com.oracle.springProject01.service.Lhj_login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.springProject01.dao.lhjMember.MemberDao;
import com.oracle.springProject01.model.Lhj_MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao	md;

	//회원가입
	@Override
	public void insertMember(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("lhj_login memberServiceImpl insertMember start..");
		if(lhj_MemberVO == null) {
			return ; 
		}
		md.insertMember(lhj_MemberVO);
	}
	//로그인
	@Override
	public Lhj_MemberVO login(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("service lhj_login MemberserviceImpl login Start...");
		return md.selectLogin(lhj_MemberVO);
	}
	//마이페이지
		//개인정보 조회
	@Override
	public Lhj_MemberVO selectMypage(String m_id) {
		System.out.println("service lhjLoginservice memverserviceImpl selectMypage start...");
		Lhj_MemberVO lhj_MemberVO = null;
		lhj_MemberVO = md.selectMypage(m_id); 
		
		return lhj_MemberVO;
	}
		//개인정보 수정 미완
	@Override
	public Lhj_MemberVO mypageUpdate(String m_id) {
		System.out.println("service lhjLoginservice memverserviceImpl mypageUpdate start...");
		Lhj_MemberVO lhj_MemberVO = null;
		lhj_MemberVO = md.selectMypage(m_id); 
		
		return null;
	}


	
	


}
