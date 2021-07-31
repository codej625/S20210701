package com.oracle.springProject01.service.lhjService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.springProject01.dao.lhjDao.MemberDao;
import com.oracle.springProject01.model.Lhj_MemberVO;

@Service("LhjService")
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
		//개인정보 수정
	@Override
	public Lhj_MemberVO mypageUpdate(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("service lhjLoginservice memverserviceImpl mypageUpdate start...");
		md.mypageUpdate(lhj_MemberVO);
		return lhj_MemberVO;
	}
		//비밀번호 변경 미완
	@Override
	public Lhj_MemberVO myPWchange(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("service lhjLoginservice memverserviceImpl mypageUpdate start...");
		md.myPWchange(lhj_MemberVO);
		return lhj_MemberVO;
	}
	
	
		//마이페이지 신청내역 조회
	@Override
	public List<Lhj_MemberVO> myRegInfoList(String m_id) {
		System.out.println("service lhjLoginservice memverserviceImpl myRegInfo start...");
		List<Lhj_MemberVO> myRegInfoList = null;
		myRegInfoList = md.myRegInfoList(m_id);
		System.out.println("service lhjLoginservice memverserviceImpl myRegInfo myRegInfoList.size()->" +myRegInfoList.size());
		return myRegInfoList;
	}
		//마이페이지 관심내역 조회
	@Override
	public List<Lhj_MemberVO> myBookMarkList(String m_id) {
		System.out.println("service lhjLoginservice memverserviceImpl myBookMarkList start...");
		List<Lhj_MemberVO> myBookMarkList = null;
		myBookMarkList = md.myBookMarkList(m_id);
		System.out.println("service lhjLoginservice memverserviceImpl myBookMark myBookMarkList.size()->" +myBookMarkList.size());
		return myBookMarkList;
	}
	
	


	
	


}
