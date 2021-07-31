package com.oracle.springProject01.dao.lhjMember;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.springProject01.model.Lhj_MemberVO;


@Repository
public class LhjMemberDaoImpl implements MemberDao {

	@Autowired
	private	SqlSession	session;

	//회원가입 구현
	@Override
	public void insertMember(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("dao lhjMember MemberDaoImpl insertMember Start ...");
		try {
			session.insert("hj_insertMember", lhj_MemberVO);
			
		} catch (Exception e) {
			System.out.println("dao lhjMember MemberDaoImpl insertMember Exception->"+e.getMessage());
		}
	}
	//로그인
	@Override
	public Lhj_MemberVO selectLogin(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("daoImple select login_id start");
		return session.selectOne("hj_selectLog", lhj_MemberVO);
	}
	//마이페이지
		//개인정보 조회
	@Override
	public Lhj_MemberVO selectMypage(String m_id) {
		System.out.println("dao lhjmember memberDaoImpl selectMypage Start");
		Lhj_MemberVO lhj_MemberVO = new Lhj_MemberVO();
		try {
			lhj_MemberVO = session.selectOne("hj_selectMypage", m_id);
		} catch (Exception e) {
			System.out.println("Dao lhjmember memberDaoImpl selectMypage error -> "+e.getMessage());
		}
		return lhj_MemberVO;
	}
		//개인정보 수정
	@Override
	public void mypageUpdate(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("dao lhjmember memberDaoImpl mypageUpdate Start");
		try {
			session.update("hj_updateMypage",lhj_MemberVO);
		} catch (Exception e) {
			System.out.println("dao lhjMember MemberDaoImpl mypageUpdate Exception->"+e.getMessage());
		}
	}

		//비밀번호 변경 미완
	@Override
	public void myPWchange(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("dao lhjmember memberDaoImpl myPWchange Start");
		try {
			session.update("hj_changePW",lhj_MemberVO);
		} catch (Exception e) {
			System.out.println("dao lhjMember MemberDaoImpl myPWchange Exception->"+e.getMessage());
		}
	}
	
	
		//신청 내역 조회
	@Override
	public List<Lhj_MemberVO> myRegInfoList(String m_id) {
		List<Lhj_MemberVO> myRegInfoList = null;
		System.out.println("dao lhjmember memberDaoImpl myRegInfo Start");
		try {
			myRegInfoList = session.selectList("hj_myRegInfo", m_id);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception->"+e.getMessage());
		}
		return myRegInfoList;
	}
		//관심 내역 조회
	@Override
	public List<Lhj_MemberVO> myBookMarkList(String m_id) {
		List<Lhj_MemberVO> myBookMarkList = null;
		System.out.println("dao lhjmember memberDaoImpl myBookMarkList Start");
		try {
			myBookMarkList = session.selectList("hj_myBookMark", m_id);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception->"+e.getMessage());
		}
		return myBookMarkList;
	}
		
	

	
}
