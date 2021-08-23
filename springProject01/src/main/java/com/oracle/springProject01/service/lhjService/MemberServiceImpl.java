package com.oracle.springProject01.service.lhjService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.springProject01.dao.lhjDao.MemberDao;
import com.oracle.springProject01.model.AttachmentFileVO;
import com.oracle.springProject01.model.Lhj_MemberVO;

@Service("LhjService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao md;

	// 회원가입
	@Override
	public void insertMember(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("lhj_login memberServiceImpl insertMember start..");
		if (lhj_MemberVO == null) {
			return;
		}
		md.insertMember(lhj_MemberVO);
	}
	
	//회원가입 - 네이버
	@Override
	public void insertMember_NaverID(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("lhj_login memberServiceImpl insertMember_NaverID start..");
		if(lhj_MemberVO == null) {
			return ; 
		}
		md.insertMember_NaverID(lhj_MemberVO);
	}
	
	//카카오 회원가입
	@Override
	public void insertMember_KAKAOID(Lhj_MemberVO lhj_MemberVO, String m_name, String m_id) {
		System.out.println("lhj_login memberServiceImpl insertMember_KAKAOID start..");
		if(lhj_MemberVO == null) {
			return ; 
		}
		md.insertMember_KAKAOID(lhj_MemberVO, m_name, m_id);
		
	}
	
	//회원가입 아이디 중복 확인 ajax

	@Override
	public void idOverlap(String m_id, HttpServletResponse response) throws IOException {
		System.out.println("lhj_login memberServiceImpl idOverlap start..");
		Lhj_MemberVO lhj_MemberVO = new Lhj_MemberVO();
		lhj_MemberVO = md.idOverlap(m_id);
		if (lhj_MemberVO == null) {
			// dao에서 select이 되지 않아야 true
			// id가 없어야 true(사용 가능)
			response.getWriter().print("1");
		} else {
			// id가 있으면 false(중복으로 사용 불가능)
			response.getWriter().print("0");
		}

	}

	// 회원가입 전화번호 중복 확인 ajax
	@Override
	public void telOverlap(String m_tel, HttpServletResponse response) throws IOException {
		System.out.println("lhj_login memberServiceImpl telOverlap start..");
		Lhj_MemberVO lhj_MemberVO = new Lhj_MemberVO();
		lhj_MemberVO = md.telOverlap(m_tel);
		if (lhj_MemberVO == null) {
			// dao에서 select이 되지 않아야 true
			// m_tel가 없어야 true(사용 가능)
			response.getWriter().print("1");
		} else {
			// m_tel가 있으면 false(중복으로 사용 불가능)
			response.getWriter().print("0");
		}

	}

	// 로그인
	@Override
	public Lhj_MemberVO login(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("service lhj_login MemberserviceImpl login Start...");
		return md.selectLogin(lhj_MemberVO);
	}

	// 로그인 아이디 찾기
	@Override
	public Lhj_MemberVO find_m_id(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("service lhj_login MemberserviceImpl find_m_id Start...");
		return md.find_m_id(lhj_MemberVO);
	}

	// 로그인 비밀번호 찾기
	@Override
	public Lhj_MemberVO find_m_pw(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("service lhj_login MemberserviceImpl find_m_pw Start...");
		return md.find_m_pw(lhj_MemberVO);
	}

	// 마이페이지
	// 개인정보 조회
	@Override
	public Lhj_MemberVO selectMypage(String m_id) {
		System.out.println("service lhjLoginservice memverserviceImpl selectMypage start...");
		Lhj_MemberVO lhj_MemberVO = null;
		lhj_MemberVO = md.selectMypage(m_id);

		return lhj_MemberVO;
	}

	// 개인정보 수정
	@Override
	public Lhj_MemberVO mypageUpdate(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("service lhjLoginservice memverserviceImpl mypageUpdate start...");
		md.mypageUpdate(lhj_MemberVO);
		return lhj_MemberVO;
	}

	// 비밀번호 변경
	@Override
	public Lhj_MemberVO myPWchange(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("service lhjLoginservice memverserviceImpl myPWchange start...");
		md.myPWchange(lhj_MemberVO);
		return lhj_MemberVO;
	}

	// 마이페이지 신청내역 조회 -all
	@Override
	public List<Lhj_MemberVO> myRegInfoList(String m_id) {
		System.out.println("service lhjLoginservice memverserviceImpl myRegInfo start...");
		List<Lhj_MemberVO> myRegInfoList = null;
		myRegInfoList = md.myRegInfoList(m_id);
		System.out.println(
				"service lhjLoginservice memverserviceImpl myRegInfo myRegInfoList.size()->" + myRegInfoList.size());
		return myRegInfoList;
	}

	// 마이페이지 신청내역 조회 -class
	@Override
	public List<Lhj_MemberVO> myRegInfo_classList(String m_id) {
		System.out.println("service lhjLoginservice memverserviceImpl myRegInfo_classList start...");
		List<Lhj_MemberVO> myRegInfo_classList = null;
		myRegInfo_classList = md.myRegInfo_classList(m_id);
		System.out.println("service lhjLoginservice memverserviceImpl myRegInfo myRegInfo_classList.size()->"
				+ myRegInfo_classList.size());
		return myRegInfo_classList;
	}

	// 마이페이지 신청내역 조회 -meeting
	@Override
	public List<Lhj_MemberVO> myRegInfo_meetingList(String m_id) {
		System.out.println("service lhjLoginservice memverserviceImpl myRegInfo_meetingList start...");
		List<Lhj_MemberVO> myRegInfo_meetingList = null;
		myRegInfo_meetingList = md.myRegInfo_meetingList(m_id);
		System.out.println("service lhjLoginservice memverserviceImpl myRegInfo myRegInfo_meetingList.size()->"
				+ myRegInfo_meetingList.size());
		return myRegInfo_meetingList;
	}

	// 신청내역 취소
	@Override
	public Lhj_MemberVO myRGNO(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("service lhjLoginservice memverserviceImpl myRGNO start...");
		md.myRGNO(lhj_MemberVO);
		return lhj_MemberVO;
	}

	// 마이페이지 관심내역 조회 -all
	@Override
	public List<Lhj_MemberVO> myBookMarkList(String m_id) {
		System.out.println("service lhjLoginservice memverserviceImpl myBookMarkList start...");
		List<Lhj_MemberVO> myBookMarkList = null;
		myBookMarkList = md.myBookMarkList(m_id);
		System.out.println(
				"service lhjLoginservice memverserviceImpl myBookMark myBookMarkList.size()->" + myBookMarkList.size());
		return myBookMarkList;
	}

	// 마이페이지 관심내역 조회 -class
	@Override
	public List<Lhj_MemberVO> myBookMark_classList(String m_id) {
		System.out.println("service lhjLoginservice memverserviceImpl myBookMark_classList start...");
		List<Lhj_MemberVO> myBookMark_classList = null;
		myBookMark_classList = md.myBookMark_classList(m_id);
		System.out.println("service lhjLoginservice memverserviceImpl myBookMark myBookMark_classList.size()->"
				+ myBookMark_classList.size());
		return myBookMark_classList;
	}

	// 마이페이지 관심내역 조회 -meeting
	@Override
	public List<Lhj_MemberVO> myBookMark_meetingList(String m_id) {
		System.out.println("service lhjLoginservice memverserviceImpl myBookMark_meetingList start...");
		List<Lhj_MemberVO> myBookMark_meetingList = null;
		myBookMark_meetingList = md.myBookMark_meetingList(m_id);
		System.out.println("service lhjLoginservice memverserviceImpl myBookMark myBookMark_meetingList.size()->"
				+ myBookMark_meetingList.size());
		return myBookMark_meetingList;
	}

	// 관심내역에서 신청 (b_reg => y)
	@Override
	public Lhj_MemberVO myBMtoRG(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("service lhjLoginservice memverserviceImpl myBMtoRG start...");
		md.myBMtoRG(lhj_MemberVO);
		return lhj_MemberVO;
	}

	// 관심내역에서 신청내역으로 insert
	@Override
	public Lhj_MemberVO myBMtoRG2(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("service lhjLoginservice memverserviceImpl myBMtoRG2 start...");
		md.myBMtoRG2(lhj_MemberVO);
		return lhj_MemberVO;
	}

	// 관심내역 취소
	@Override
	public Lhj_MemberVO myBMNO(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("service lhjLoginservice memverserviceImpl myBMNO start...");
		md.myBMNO(lhj_MemberVO);
		return lhj_MemberVO;
	}

	// 회원 탈퇴 (member_withdrawal => y)
	@Override
	public Lhj_MemberVO myDelMySelf2(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("service lhjLoginservice memverserviceImpl myDelMySelf2 start...");
		md.myDelMySelf2(lhj_MemberVO);
		return lhj_MemberVO;
	}

	// 내가 쓴 글 리스트 -all
	@Override
	public List<Lhj_MemberVO> myPostList(String m_id) {
		System.out.println("service lhjLoginservice memverserviceImpl myPostList start...");
		List<Lhj_MemberVO> myPostList = null;
		myPostList = md.myPostList(m_id);
		System.out.println("service lhjLoginservice memverserviceImpl myPostList.size()->" + myPostList.size());
		return myPostList;
	}

	// 내가 쓴 글 리스트 -class
	@Override
	public List<Lhj_MemberVO> myPostList_class(String m_id) {
		System.out.println("service lhjLoginservice memverserviceImpl myPostList_class start...");
		List<Lhj_MemberVO> myPostList_class = null;
		myPostList_class = md.myPostList_class(m_id);
		System.out.println(
				"service lhjLoginservice memverserviceImpl myPostList_class.size()->" + myPostList_class.size());
		return myPostList_class;
	}

	// 내가 쓴 글 리스트 -meeting
	@Override
	public List<Lhj_MemberVO> myPostList_meeting(String m_id) {
		System.out.println("service lhjLoginservice memverserviceImpl myPostList_meeting start...");
		List<Lhj_MemberVO> myPostList_meeting = null;
		myPostList_meeting = md.myPostList_meeting(m_id);
		System.out.println(
				"service lhjLoginservice memverserviceImpl myPostList_meeting.size()->" + myPostList_meeting.size());
		return myPostList_meeting;
	}

	// 내가 쓴 글 에 대해 신청한 회원 list
	@Override
	public List<Lhj_MemberVO> mypage_myPostMEmberList(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("service lhjLoginservice memverserviceImpl mypage_myPostMEmberList start...");
		List<Lhj_MemberVO> mypage_myPostMEmberList = null;
		mypage_myPostMEmberList = md.mypage_myPostMEmberList(lhj_MemberVO);
		System.out.println("service lhjLoginservice memverserviceImpl mypage_myPostMEmberList.size()->"
				+ mypage_myPostMEmberList.size());
		return mypage_myPostMEmberList;
	}

	@Override
	public Lhj_MemberVO mypage_mycertification(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("MemberServiceImpl mypage_mycertification start...");
		lhj_MemberVO = md.mypage_mycertification(lhj_MemberVO);
		return lhj_MemberVO;
	}

	// 메일 인증 받기
	@Override
	public int mail(Lhj_MemberVO lhj_MemberVO) {
		System.out.println("MemberServiceImpl Start mail...");
		int mail = 0;
		mail = md.mail(lhj_MemberVO);
		return mail;
	}

	// 개설자 권한 파일첨부 등록
	@Override
	public int certification(AttachmentFileVO attachmentFileVO) {
		System.out.println("MemberServiceImpl Start certification...");
		int result = 0;

		// 날짜를 입력하기 위한 SimpleDateFormat, Calendar 객체 생성==========================
		SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar time = Calendar.getInstance();
		String date = Format.format(time.getTime());

		// attachmentFileVO.getFiles()속에 리스트로 저장된 값들을 하나씩 꺼낸다
		for (MultipartFile file : attachmentFileVO.getFiles()) {
			//
			String name = "images/" + file.getOriginalFilename();
			attachmentFileVO.setF_orgname(name);
			attachmentFileVO.setM_id(attachmentFileVO.getM_id().toString());
			attachmentFileVO.setF_regdate(date);
			md.certification(attachmentFileVO);
		}
		attachmentFileVO.setM_id(attachmentFileVO.getM_id().toString());
		attachmentFileVO.setM_meetingauth(attachmentFileVO.getM_meetingauth());
		attachmentFileVO.setM_masterauth(attachmentFileVO.getM_masterauth());
		attachmentFileVO.setM_certification(attachmentFileVO.getM_certification());
		result = md.certification(attachmentFileVO);
		return result;
	}

	// 메일 인증 확인용
	@Override
	public AttachmentFileVO member(AttachmentFileVO attachmentFileVO) {
		System.out.println("MemberServiceImpl Start member...");
		attachmentFileVO = md.member(attachmentFileVO);
		return attachmentFileVO;
	}

	


	
}
