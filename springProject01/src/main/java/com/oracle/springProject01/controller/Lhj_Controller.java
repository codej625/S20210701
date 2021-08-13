package com.oracle.springProject01.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oracle.springProject01.model.AttachmentFileVO;
import com.oracle.springProject01.model.Lhj_MemberVO;
import com.oracle.springProject01.service.lhjService.MemberService;

@Controller
public class Lhj_Controller {

	@Autowired
	private MemberService ms;

	@Autowired
	private JavaMailSender mailSender;

	// 로깅
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(Lhj_Controller.class);

	// 메인화면
//	@RequestMapping(value = "/main/main")
//	public String main() {
//		System.out.println("go main");
//		return "main/main";
//	}

	// 회원가입 화면
	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	public String insertGET() throws Exception {
		System.out.println("Lhj_Controller String insertGET start...");
		logger.info("C: 회원가입 입력페이지 GET");
		return "member/join";
	}

	// 회원가입 처리
	@RequestMapping(value = "/members/join", method = RequestMethod.POST)
	public String insertPOST(Lhj_MemberVO lhj_MemberVO) throws Exception {
		System.out.println("Lhj_Controller String insertPOST start...");
		logger.info("C: " + lhj_MemberVO);
		ms.insertMember(lhj_MemberVO);
		logger.info("C: 회원가입 처리페이지 POST");

		return "member/login";
	}

	// 아이디 중복확인 처리
	@RequestMapping(value = "/idOverlap", method = RequestMethod.POST)
	public void idOverlap(HttpServletResponse response, @RequestParam("m_id") String m_id) throws IOException {
		System.out.println("Lhj_Controller String idOverlap start...");
		// @RequestParam는 요청의 특정 파라미터 값을 찾아낼 때 사용하는 어노테이션
		ms.idOverlap(m_id, response); // 서비스에 있는 idOverlap 호출.
	}

	// 아이디 중복확인 처리
	@RequestMapping(value = "/telOverlap", method = RequestMethod.POST)
	public void telOverlap(HttpServletResponse response, @RequestParam("m_tel") String m_tel) throws IOException {
		System.out.println("Lhj_Controller String telOverlap start...");
		// @RequestParam는 요청의 특정 파라미터 값을 찾아낼 때 사용하는 어노테이션
		ms.idOverlap(m_tel, response); // 서비스에 있는 idOverlap 호출.
	}

	// 로그인 화면
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String loginGET() throws Exception {
		System.out.println("Lhj_Controller String loginGET start...");
		logger.info("C: 로그인 입력페이지 GET");
		return "member/login";
	}

	// 로그인 아이디 찾기로 이동
	@RequestMapping(value = "/member/find_m_id")
	public String find_m_id(Lhj_MemberVO lhj_MemberVO, Model model) {
		System.out.println("Lhj_Controller String find_m_id start...");
		return "member/find_m_id";
	}

	// 로그인 아이디 찾기 실행
	@RequestMapping(value = "/member/find_m_id", method = RequestMethod.POST)
	public String find_idAction(Lhj_MemberVO lhj_MemberVO, Model model) {
		System.out.println("Lhj_Controller String find_idAction start...");

		Lhj_MemberVO lhj_MemberVO2 = ms.find_m_id(lhj_MemberVO);
		if (lhj_MemberVO2 == null) {
			model.addAttribute("check", 1);
		} else {
			model.addAttribute("check", 0);
			model.addAttribute("m_id", lhj_MemberVO2.getM_id());
		}
		return "member/find_m_id";
	}

	// 로그인 비밀번호 찾기로 이동
	@RequestMapping(value = "/member/find_m_pw")
	public String find_m_pw(Lhj_MemberVO lhj_MemberVO, Model model) {
		System.out.println("Lhj_Controller String find_m_pw start...");
		return "member/find_m_pw";
	}

	// 로그인 비밀번호 찾기 실행
	@RequestMapping(value = "/member/find_m_pw", method = RequestMethod.POST)
	public String find_pwAction(Lhj_MemberVO lhj_MemberVO, Model model) {
		System.out.println("Lhj_Controller String find_pwAction start...");

		Lhj_MemberVO lhj_MemberVO2 = ms.find_m_pw(lhj_MemberVO);
		if (lhj_MemberVO2 == null) {
			model.addAttribute("check", 1);
		} else {
			model.addAttribute("check", 0);
			model.addAttribute("m_pw", lhj_MemberVO2.getM_pw());
		}
		return "member/find_m_pw";
	}

	// 로그인 처리 //로그인 카카오 로그인이랑 네이버 로그인 api 추가할 예정
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String loginPOST(Lhj_MemberVO lhj_MemberVO, String m_id, Model model, HttpServletRequest request)
			throws Exception {
		System.out.println("LoginController login Start...");
		Lhj_MemberVO login = ms.login(lhj_MemberVO);
		System.out.println("LoginController result->" + login);
		if (login == null) {
			logger.info("아이디 혹은 비밀번호 오류");
			return "redirect:/member/login";
		} else {
			// 세션유지
			request.getSession().setAttribute("sessionID", m_id);
			model.addAttribute("m_id", m_id);
			System.out.println("m_id->" + m_id);
			return "/main/main";
		}
	}

	// 로그아웃 처리
	@RequestMapping(value = "/member/logout")
	public String logout(HttpSession session) {
		System.out.println("LoginController logout Start...");
		session.setAttribute("sessionID", null);
		session.invalidate();
		return "/main/main";
	}

	// 마이페이지 //캘린더 api 추가 예정
	@RequestMapping(value = "/member/mypage")
	public String mypage(Model model, HttpServletRequest request, String m_id) throws Exception {
		System.out.println("lhjController mypage Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		System.out.println("아이디 잘 가져왓는지 확인" + m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);

		return "/member/mypage";
	}

	// 마이페이지 수정 폼
	@RequestMapping(value = "/member/mypage_update", method = RequestMethod.GET)
	public String mypage_update(Model model, HttpServletRequest request, String m_id) throws Exception {
		System.out.println("lhjController mypage_update Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);

		return "/member/mypage_update";
	}

	// 마이페이지 수정 결과
	@RequestMapping(value = "/member/mypage_update", method = RequestMethod.POST)
	public String mypage_update(Model model, HttpServletRequest request, String m_id, HttpSession session,
			MultipartFile m_img) throws IOException, Exception {
		System.out.println("lhjController mypage_update222 Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = new Lhj_MemberVO();
		lhj_MemberVO.setM_name(request.getParameter("m_name"));
		lhj_MemberVO.setM_tel(request.getParameter("m_tel"));
		lhj_MemberVO.setM_area(request.getParameter("m_area"));
		lhj_MemberVO.setM_field(request.getParameter("m_field"));
		lhj_MemberVO.setM_id(request.getParameter("m_id"));

		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
		String savedName = uploadFile(m_img.getOriginalFilename(), m_img.getBytes(), uploadPath);
		System.out.println("uploadPath: " + uploadPath);
		System.out.println("savedName: " + savedName);
		lhj_MemberVO.setM_img(savedName);
		lhj_MemberVO = ms.mypageUpdate(lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);

		return "/member/mypage_update";
	}

	// 파일 업로드 관련
	private String uploadFile(String originalName, byte[] fileData, String uploadPath) throws Exception {
		UUID uid = UUID.randomUUID();
		// requestPath = requestPath + "/resources/image";
		System.out.println("uploadPath->" + uploadPath);
		// Directory 생성
		File fileDirectory = new File(uploadPath);
		if (!fileDirectory.exists()) {
			fileDirectory.mkdirs();
			System.out.println("업로드용 폴더 생성 : " + uploadPath);
		}

		String savedName = uid.toString() + "_" + originalName;
		logger.info("savedName: " + savedName);
		File target = new File(uploadPath, savedName);
//	    File target = new File(requestPath, savedName);
		FileCopyUtils.copy(fileData, target); // org.springframework.util.FileCopyUtils

		return savedName;
	}

	// 마이페이지 비밀번호 변경 화면
	@RequestMapping(value = "/member/mypage_changePW", method = RequestMethod.GET)
	public String mypage_changePW(Model model, HttpServletRequest request, String m_id) throws Exception {
		System.out.println("lhjController mypage_changePW Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);

		return "/member/mypage_changePW";
	}

	// 비밀번호 변경 결과
	@RequestMapping(value = "/member/mypage_changePW", method = RequestMethod.POST)
	public String mypage_changePW(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request, String m_id,
			HttpSession session) {
		System.out.println("lhjController mypage_changePW22 Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		lhj_MemberVO = ms.myPWchange(lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);

		return "/member/mypage_changePW";
	}

	// 마이페이지 신청 내역 //결제 api 추가 예정
	@RequestMapping(value = "/member/mypage_myreginfo")
	public String myreginfo(Model model, HttpServletRequest request, String m_id) throws Exception {
		System.out.println("lhjController myreginfo Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		// 전체 리스트
		List<Lhj_MemberVO> myRegInfoList = ms.myRegInfoList(m_id);
		// 클래스 리스트
		List<Lhj_MemberVO> myRegInfo_classList = ms.myRegInfo_classList(m_id);
		// 모임 리스트
		List<Lhj_MemberVO> myRegInfo_meetingList = ms.myRegInfo_meetingList(m_id);

		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		model.addAttribute("myRegInfoList", myRegInfoList);
		model.addAttribute("myRegInfo_classList", myRegInfo_classList);
		model.addAttribute("myRegInfo_meetingList", myRegInfo_meetingList);

		return "/member/mypage_myreginfo";
	}

	// 마이페이지 신청내역 post관련 보여주는거

	// 마이페이지 신청내역 취소
	@RequestMapping(value = "/member/mypage_myreginfoDE", method = { RequestMethod.GET, RequestMethod.POST })
	public String myreginfoDE(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request, HttpSession session)
			throws Exception {
		System.out.println("lhjController myreginfo Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		String m_id = sessionID;
		lhj_MemberVO = ms.myRGNO(lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);

		return "forward:/member/mypage_myreginfo";
	}

	// 마이페이지 관심 내역
	@RequestMapping(value = "/member/mypage_mybookmark")
	public String mybookmark(Model model, HttpServletRequest request, String m_id) throws Exception {
		System.out.println("lhjController mybookmark Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		// 전체 북마크 리스트
		List<Lhj_MemberVO> myBookMarkList = ms.myBookMarkList(m_id);
		// 북마크 클래스 리스트
		List<Lhj_MemberVO> myBookMark_classList = ms.myBookMark_classList(m_id);
		// 북마크 미팅 리스트
		List<Lhj_MemberVO> myBookMark_meetingList = ms.myBookMark_meetingList(m_id);
		model.addAttribute("myBookMarkList", myBookMarkList);
		model.addAttribute("myBookMark_classList", myBookMark_classList);
		model.addAttribute("myBookMark_meetingList", myBookMark_meetingList);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);

		return "/member/mypage_mybookmark";
	}

	// 마이페이지 관심내역 신청
	@RequestMapping(value = "/member/mypage_mybookmarkSin", method = { RequestMethod.GET, RequestMethod.POST })
	public String mybookmarkSin(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request,
			HttpSession session) {
		System.out.println("lhjController mybookmarkSin Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		String m_id = sessionID;
		lhj_MemberVO = ms.myBMtoRG(lhj_MemberVO);
		Lhj_MemberVO lhj_MemberVO2 = ms.myBMtoRG2(lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO2);

		return "forward:/member/mypage_myreginfo";
	}

	// 마이페이지 관심내역 취소
	@RequestMapping(value = "/member/mypage_mybookmarkNO", method = { RequestMethod.GET, RequestMethod.POST })
	public String mybookmarkNO(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request,
			HttpSession session) {
		System.out.println("lhjController mybookmarkSin Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		String m_id = sessionID;
		lhj_MemberVO = ms.myBMNO(lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);

		return "forward:/member/mypage_mybookmark";
	}

	// 마이페이지 탈퇴 폼
	@RequestMapping(value = "/member/mypage_deleteMyself")
	public String myDelMySelf(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("lhjController mybookmarkSin Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		String m_id = sessionID;
		lhj_MemberVO = ms.selectMypage(m_id);
		System.out.println("아이디 잘 가져왓는지 확인 for pw" + m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);

		return "/member/mypage_deleteMyself";
	}

	// 마이페이지 탈퇴
	@RequestMapping(value = "/member/mypage_deleteMyselfs", method = { RequestMethod.GET, RequestMethod.POST })
	public String myDelMySelf2(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request,
			HttpSession session) {
		System.out.println("lhjController mybookmarkSin Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		String m_id = sessionID;
		lhj_MemberVO = ms.myDelMySelf2(lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);

		return "forward:/member/logout";
	}

	// 마이페이지 인증 화면
	@RequestMapping(value = "/member/mypage_mycertification")
	public String mypage_mycertification(Model model, HttpServletRequest request, Lhj_MemberVO lhj_MemberVO,
			String m_id) throws Exception {
		System.out.println("lhjController mypage_mycertification Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
//======m_id에 값을 셋팅하고 조회하기 위해 DTO단위로 보냄
		lhj_MemberVO.setM_id(m_id);
		lhj_MemberVO = ms.mypage_mycertification(lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		System.out.println("lhjController mypage_mycertification return...");
		return "/member/mypage_mycertification";
	}

	// 마이페이지 내가 쓴 글 화면
	@RequestMapping(value = "/member/mypage_myPostList", method = RequestMethod.GET)
	public String mypage_myPostList(Model model, HttpServletRequest request, String m_id) throws Exception {
		System.out.println("lhjController mypage_changePW Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		// 내가 쓴 글 리스트 -all
		List<Lhj_MemberVO> myPostList = ms.myPostList(m_id);
		// 내가 쓴 글 리스트 -class
		List<Lhj_MemberVO> myPostList_class = ms.myPostList_class(m_id);
		// 내가 쓴 글 리스트 -meeting
		List<Lhj_MemberVO> myPostList_meeting = ms.myPostList_meeting(m_id);
		model.addAttribute("myPostList", myPostList);
		model.addAttribute("myPostList_class", myPostList_class);
		model.addAttribute("myPostList_meeting", myPostList_meeting);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);

		return "/member/mypage_myPostList";
	}

	// 마이페이지 내가 쓴글의 회원 관리 화면
	@RequestMapping(value = "/member/mypage_myPostMEmberList_", method = RequestMethod.GET)
	public String mypage_myPostMEmberList(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request,
			String m_id) throws Exception {
		System.out.println("lhjController mypage_changePW Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		// 내가 쓴 글 리스트 -all
		List<Lhj_MemberVO> mypage_myPostMEmberList = ms.mypage_myPostMEmberList(lhj_MemberVO);
		model.addAttribute("mypage_myPostMEmberList", mypage_myPostMEmberList);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);

		return "/member/mypage_myPostMEmberList_";
	}

	@RequestMapping(value = "/admin/mailTransport", method = RequestMethod.POST)
	@ResponseBody
	public String mailTransport(Model model, Lhj_MemberVO lhj_MemberVO) {
		System.out.println("Mail Start...");
//======받는 사람 이메일
		String tomail = lhj_MemberVO.getM_id();
//======넘어온 m_id값 확인용
		System.out.println(tomail);
//======보내는 사람 이메일		
		String setfrom = "dkwksla@gmail.com";
		String title = "인증번호 입니다.";
		try {
			MimeMessage message = mailSender.createMimeMessage();
//=========="UTF-8"방식으로 메세지를 보낼수 있는 객체 생성
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
//==========보내는 사람			
			messageHelper.setFrom(setfrom);
//==========받는 사람
			messageHelper.setTo(tomail);
//==========메일 제목			
			messageHelper.setSubject(title);
//==========Math내장 객체로 랜덤 인증번호 만들기
			String tempPassword = (int) (Math.random() * 999999) + 1 + "";
//==========랜덤번호로 만들어진 인증번호를 DB에 입력하기 setter를 이용해서 집어넣음
			lhj_MemberVO.setM_mail(tempPassword);
//==========setText함수에 인증번호와 간단한 메세지를 넣음
			messageHelper.setText("인증번호 : " + tempPassword);
//==========set 되어있는 메세지 확인용
			System.out.println("인증번호 : " + tempPassword);
//==========메세지 전송
			mailSender.send(message);
//==========정상 전달시 메세지
			System.out.println("Mail Sending End...");
//==========form에서 넘겨받은 m_id와 위에서 setter에 넣어놓은 인증번호를 갖고 DB에 넣기위해 DTO단위로 서비스로 보냄
			ms.mail(lhj_MemberVO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("전송 실패");
		}
//======반환값은 없음
		return "null";
	}

	@PostMapping(value = "/member/certification")
	@ResponseBody
	public void upload(AttachmentFileVO attachmentFileVO, Model model, HttpServletRequest request) throws Exception {
		System.out.println("Ljw_Controller upload Start...");
		System.out.println(
				"controller value->" + attachmentFileVO.getM_meetingauth() + attachmentFileVO.getM_masterauth());
//======인증번호가 틀렸는지 확인
//		if (attachmentFileVO.getM_mail().equals(null)) {
//			String error = "인증번호가 틀립니다.";
//			model.addAttribute("error", error);
//			return "member/certification";
//		}
//======MultipartFile 객체로 파일을 받아서 for문으로 하나씩 빼서 저장===================================
		for (MultipartFile file : attachmentFileVO.getFiles()) {
//==========C:/Image/ + 원본 파일이름으로 저장===================================================
			String originalfileName = file.getOriginalFilename();
//==========파일로 만들기 위한 작업 경로를 지정
			File data = new File("C:/Images/" + originalfileName);
//==========저장 파일로 변환
			file.transferTo(data);
//==========파일 확인용 메세지
			System.out.println(attachmentFileVO.getFiles());
//==========VO로 받은 files 갯수 확인용 Message==================================================
			System.out.println("files->" + attachmentFileVO.getFiles().size());
		}
//======데이터 값을 DB에 저장하기 위해 DTO 단위로 Service로 보냄========================================
		ms.certification(attachmentFileVO);
//======List를 Model에 담아서 return=====================================================
	}

}