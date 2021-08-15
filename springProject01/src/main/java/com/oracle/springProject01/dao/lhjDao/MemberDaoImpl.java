package com.oracle.springProject01.dao.lhjDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.springProject01.model.AttachmentFileVO;
import com.oracle.springProject01.model.Lhj_MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession session;

	// 회원가입 구현
	@Override
	public void insertMember(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("dao lhjMember MemberDaoImpl insertMember Start ...");
		try {
			session.insert("hj_insertMember", lhj_MemberVO);

		} catch (Exception e) {
			System.out.println("dao lhjMember MemberDaoImpl insertMember Exception->" + e.getMessage());
		}
	}
	//네이버 회원가입 구현
	@Override
	public void insertMember_NaverID(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("dao lhjMember MemberDaoImpl insertMember_NaverID Start ...");
		try {
			session.insert("hj_insertMember_naver", lhj_MemberVO);
			
		} catch (Exception e) {
			System.out.println("dao lhjMember MemberDaoImpl insertMember_NaverID Exception->"+e.getMessage());
		}
	}
	
	
	
	//회원가입 아이디 중복 확인 ajax

	@Override
	public Lhj_MemberVO idOverlap(String m_id) {
		System.out.println("daoImple lhjMember MemberDaoImpl idOverlap start");

		return session.selectOne("hj_m_idCheck", m_id);
	}

	// 회원가입 전화번호 중복 확인 ajax
	@Override
	public Lhj_MemberVO telOverlap(String m_tel) {
		System.out.println("daoImple lhjMember MemberDaoImpl telOverlap start");

		return session.selectOne("hj_m_telCheck", m_tel);
	}

	// 로그인
	@Override
	public Lhj_MemberVO selectLogin(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("daoImple select login_id start");
		return session.selectOne("hj_selectLog", lhj_MemberVO);
	}

	// 로그인 아이디 찾기
	@Override
	public Lhj_MemberVO find_m_id(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("daoImple select find_m_id start");
		try {
			lhj_MemberVO = session.selectOne("hj_find_m_pw", lhj_MemberVO);
		} catch (Exception e) {
			System.out.println("Dao lhjmember memberDaoImpl find_m_id error -> " + e.getMessage());
		}
		return lhj_MemberVO;

	}

	// 로그인 비밀번호 찾기
	@Override
	public Lhj_MemberVO find_m_pw(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("daoImple select find_m_pw start");
		try {
			lhj_MemberVO = session.selectOne("hj_find_m_pw", lhj_MemberVO);
		} catch (Exception e) {
			System.out.println("Dao lhjmember memberDaoImpl find_m_pw error -> " + e.getMessage());
		}
		return lhj_MemberVO;

	}

	// 마이페이지
	// 개인정보 조회
	@Override
	public Lhj_MemberVO selectMypage(String m_id) {
		System.out.println("dao lhjmember memberDaoImpl selectMypage Start");
		Lhj_MemberVO lhj_MemberVO = new Lhj_MemberVO();
		try {
			lhj_MemberVO = session.selectOne("hj_selectMypage", m_id);
		} catch (Exception e) {
			System.out.println("Dao lhjmember memberDaoImpl selectMypage error -> " + e.getMessage());
		}
		return lhj_MemberVO;
	}

	// 개인정보 수정
	@Override
	public void mypageUpdate(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("dao lhjmember memberDaoImpl mypageUpdate Start");
		try {
			session.update("hj_updateMypage", lhj_MemberVO);
		} catch (Exception e) {
			System.out.println("dao lhjMember MemberDaoImpl mypageUpdate Exception->" + e.getMessage());
		}
	}

	// 비밀번호 변경
	@Override
	public void myPWchange(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("dao lhjmember memberDaoImpl myPWchange Start");
		try {
			session.update("hj_changePW", lhj_MemberVO);
		} catch (Exception e) {
			System.out.println("dao lhjMember MemberDaoImpl myPWchange Exception->" + e.getMessage());
		}
	}

	// 신청 내역 조회 -all
	@Override
	public List<Lhj_MemberVO> myRegInfoList(String m_id) {
		List<Lhj_MemberVO> myRegInfoList = null;
		System.out.println("dao lhjmember memberDaoImpl myRegInfo Start");
		try {
			myRegInfoList = session.selectList("hj_myRegInfo", m_id);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl myRegInfoList Exception->" + e.getMessage());
		}
		return myRegInfoList;
	}

	// 신청 내역 조회 -class
	@Override
	public List<Lhj_MemberVO> myRegInfo_classList(String m_id) {
		List<Lhj_MemberVO> myRegInfo_classList = null;
		System.out.println("dao lhjmember memberDaoImpl myRegInfo_classList Start");
		try {
			myRegInfo_classList = session.selectList("hj_myRegInfo_class", m_id);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl myRegInfo_classList Exception->" + e.getMessage());
		}
		return myRegInfo_classList;
	}

	// 신청 내역 조회 -meeting
	@Override
	public List<Lhj_MemberVO> myRegInfo_meetingList(String m_id) {
		List<Lhj_MemberVO> myRegInfo_meetingList = null;
		System.out.println("dao lhjmember memberDaoImpl myRegInfo_meetingList Start");
		try {
			myRegInfo_meetingList = session.selectList("hj_myRegInfo_meeting", m_id);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl myRegInfo_meetingList Exception->" + e.getMessage());
		}
		return myRegInfo_meetingList;
	}

	// 신청내역 취소
	@Override
	public void myRGNO(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("dao lhjMember MemberDaoImpl myRGNO Start ...");
		try {
			session.delete("hj_myRGNO", lhj_MemberVO);

		} catch (Exception e) {
			System.out.println("dao lhjMember MemberDaoImpl myRGNO Exception->" + e.getMessage());
		}
	}

	// 관심 내역 조회 -all
	@Override
	public List<Lhj_MemberVO> myBookMarkList(String m_id) {
		List<Lhj_MemberVO> myBookMarkList = null;
		System.out.println("dao lhjmember memberDaoImpl myBookMarkList Start");
		try {
			myBookMarkList = session.selectList("hj_myBookMark", m_id);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception->" + e.getMessage());
		}
		return myBookMarkList;
	}

	// 관심 내역 조회 -class
	@Override
	public List<Lhj_MemberVO> myBookMark_classList(String m_id) {
		List<Lhj_MemberVO> myBookMark_classList = null;
		System.out.println("dao lhjmember memberDaoImpl myBookMark_classList Start");
		try {
			myBookMark_classList = session.selectList("hj_myBookMark_class", m_id);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception->" + e.getMessage());
		}
		return myBookMark_classList;
	}

	// 관심 내역 조회 -meeting
	@Override
	public List<Lhj_MemberVO> myBookMark_meetingList(String m_id) {
		List<Lhj_MemberVO> myBookMark_meetingList = null;
		System.out.println("dao lhjmember memberDaoImpl myBookMark_meetingList Start");
		try {
			myBookMark_meetingList = session.selectList("hj_myBookMark_meeting", m_id);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception->" + e.getMessage());
		}
		return myBookMark_meetingList;
	}

	// 관심내역에서 신청 (b_reg => y)
	@Override
	public void myBMtoRG(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("dao lhjmember memberDaoImpl myBMtoRG Start");
		try {
			session.update("hj_myBMtomyRG", lhj_MemberVO);
		} catch (Exception e) {
			System.out.println("dao lhjMember MemberDaoImpl myBMtoRG Exception->" + e.getMessage());
		}
	}

	// 관심내역에서 신청내역으로 insert
	@Override
	public void myBMtoRG2(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("dao lhjMember MemberDaoImpl myBMtoRG2 Start ...");
		try {
			session.insert("hj_myBMtoRG2", lhj_MemberVO);

		} catch (Exception e) {
			System.out.println("dao lhjMember MemberDaoImpl myBMtoRG2 Exception->" + e.getMessage());
		}
	}

	// 관심내역 취소
	@Override
	public void myBMNO(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("dao lhjMember MemberDaoImpl myBMNO Start ...");
		try {
			session.delete("hj_myBMNO", lhj_MemberVO);

		} catch (Exception e) {
			System.out.println("dao lhjMember MemberDaoImpl myBMNO Exception->" + e.getMessage());
		}
	}

	// 회원 탈퇴 (member_withdrawal => y)
	@Override
	public void myDelMySelf2(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("dao lhjmember memberDaoImpl mypageUpdate Start");
		try {
			session.update("hj_myDelMySelf2", lhj_MemberVO);
		} catch (Exception e) {
			System.out.println("dao lhjMember MemberDaoImpl mypageUpdate Exception->" + e.getMessage());
		}
	}

	// 내가 쓴 글 리스트-all
	@Override
	public List<Lhj_MemberVO> myPostList(String m_id) {
		List<Lhj_MemberVO> myPostList = null;
		System.out.println("dao lhjmember memberDaoImpl myPostList Start");
		try {
			myPostList = session.selectList("hj_myPostList", m_id);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception->" + e.getMessage());
		}
		return myPostList;
	}

	// 내가 쓴 글 리스트-class
	@Override
	public List<Lhj_MemberVO> myPostList_class(String m_id) {
		List<Lhj_MemberVO> myPostList_class = null;
		System.out.println("dao lhjmember memberDaoImpl myPostList_class Start");
		try {
			myPostList_class = session.selectList("hj_myPostList_class", m_id);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception->" + e.getMessage());
		}
		return myPostList_class;
	}

	// 내가 쓴 글 리스트-meeting
	@Override
	public List<Lhj_MemberVO> myPostList_meeting(String m_id) {
		List<Lhj_MemberVO> myPostList_meeting = null;
		System.out.println("dao lhjmember memberDaoImpl myPostList_meeting Start");
		try {
			myPostList_meeting = session.selectList("hj_myPostList_meeting", m_id);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception->" + e.getMessage());
		}
		return myPostList_meeting;
	}

	@Override
	public List<Lhj_MemberVO> mypage_myPostMEmberList(Lhj_MemberVO lhj_MemberVO) {
		List<Lhj_MemberVO> mypage_myPostMEmberList = null;
		System.out.println("dao lhjmember memberDaoImpl mypage_myPostMEmberList Start");
		try {
			mypage_myPostMEmberList = session.selectList("hj_myPostMEmberList", lhj_MemberVO);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception->" + e.getMessage());
		}
		return mypage_myPostMEmberList;
	}

	// 인증
	@Override
	public Lhj_MemberVO mypage_mycertification(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("dao lhjMember MemberDaoImpl mypage_mycertification Start...");
		try {
			lhj_MemberVO = session.selectOne("hj_mycertification", lhj_MemberVO);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl mypage_mycertification error...->" + e.getMessage());
		}
		return lhj_MemberVO;
	}

	// 메일 인증 받기
	@Override
	public int mail(Lhj_MemberVO lhj_MemberVO) {
		int mail = 0;
		System.out.println("dao lhjMember MemberDaoImpl mail Start...");
		try {
			mail = session.update("hj_mail", lhj_MemberVO);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl mail Exception->" + e.getMessage());
		}
		return mail;
	}

	// 개설자 권한 인증 파일첨부 등록
//	@Override
//	public void certification(AttachmentFile attachmentFile) {
//		System.out.println("dao lhjMember MemberDaoImpl certification Start...");
//		try {
//			session.insert("hj_Attachment", attachmentFile);
//		} catch (Exception e) {
//			System.out.println("MemberDaoImpl certification Exception->" + e.getMessage());
//		}
//	}

	// 개설자 권한 신청
//	@Override
//	public int certification2(Lhj_MemberVO lhj_MemberVO) {
//		System.out.println("dao lhjMember MemberDaoImpl certification2 Start...");
//		int result = 0;
//		System.out.println("value->" + lhj_MemberVO.getM_meetingauth() + lhj_MemberVO.getM_masterauth()
//				+ lhj_MemberVO.getM_certification());
//		try {
//			result = session.update("hj_user", lhj_MemberVO);
//		} catch (Exception e) {
//			System.out.println("MemberDaoImpl certification2 Exception->" + e.getMessage());
//		}
//		return result;
//	}

	@Override
	public int certification(AttachmentFileVO attachmentFileVO) {
		System.out.println("dao lhjMember MemberDaoImpl certification Start...");
		int result = 0;
		try {
			session.insert("hj_Attachment", attachmentFileVO);
			result = session.update("hj_user", attachmentFileVO);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl certification Exception->" + e.getMessage());
		}
		System.out.println("dao lhjMember MemberDaoImpl certification End...");
		return result;
	}

	// 메일 인증 확인용
	@Override
	public AttachmentFileVO member(AttachmentFileVO attachmentFileVO) {
		System.out.println("dao lhjMember MemberDaoImpl member Start...");
		try {
			attachmentFileVO = session.selectOne("hj_member", attachmentFileVO);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl member Exception->" + e.getMessage());
		}
		return attachmentFileVO;
	}

}