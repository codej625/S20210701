 package com.oracle.springProject01.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oracle.springProject01.model.Lhj_MemberVO;
import com.oracle.springProject01.service.lhjService.MemberService;

@Controller
public class Lhj_Controller {
	
	@Autowired
	private	MemberService ms;
	
	//로깅
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(Lhj_Controller.class);
	
	//메인화면
//	@RequestMapping(value = "/main/main")
//	public String main() {
//		System.out.println("go main");
//		return "main/main";
//	}
	
	//회원가입 화면
	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	public String insertGET() throws Exception {
		System.out.println("Lhj_Controller String insertGET start...");
		logger.info("C: 회원가입 입력페이지 GET");
		return "member/join";
	}
	
	//회원가입 처리
	@RequestMapping(value = "/members/join", method = RequestMethod.POST)
	public String insertPOST(Lhj_MemberVO lhj_MemberVO) throws Exception{
		System.out.println("Lhj_Controller String insertPOST start...");
		logger.info("C: "+ lhj_MemberVO);
		ms.insertMember(lhj_MemberVO);		
		logger.info("C: 회원가입 처리페이지 POST");
		
		return "member/login";
	}
	
	//아이디 중복확인 처리
	@RequestMapping(value="/idOverlap", method=RequestMethod.POST)
	public void idOverlap(HttpServletResponse response, @RequestParam("m_id") String m_id) throws IOException {
		System.out.println("Lhj_Controller String idOverlap start...");
		//@RequestParam는 요청의 특정 파라미터 값을 찾아낼 때 사용하는 어노테이션
		ms.idOverlap(m_id,response);	//서비스에 있는 idOverlap 호출.
	}
	
	//아이디 중복확인 처리
	@RequestMapping(value="/telOverlap", method=RequestMethod.POST)
	public void telOverlap(HttpServletResponse response, @RequestParam("m_tel") String m_tel) throws IOException {
		System.out.println("Lhj_Controller String telOverlap start...");
		//@RequestParam는 요청의 특정 파라미터 값을 찾아낼 때 사용하는 어노테이션
		ms.idOverlap(m_tel,response);	//서비스에 있는 idOverlap 호출.
	}
	
	//로그인 화면
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String loginGET() throws Exception{
		System.out.println("Lhj_Controller String loginGET start...");
		logger.info("C: 로그인 입력페이지 GET");
		return "member/login";
	}
	
	//로그인 아이디 찾기로 이동
	@RequestMapping(value = "/member/find_m_id" )
	public String find_m_id(Lhj_MemberVO lhj_MemberVO, Model model) {
		System.out.println("Lhj_Controller String find_m_id start...");
		return "member/find_m_id";
	}
	
	//로그인 아이디 찾기 실행
	@RequestMapping(value = "/member/find_m_id", method = RequestMethod.POST)
	public String find_idAction(Lhj_MemberVO lhj_MemberVO, Model model) {
		System.out.println("Lhj_Controller String find_idAction start...");
		
		Lhj_MemberVO lhj_MemberVO2 = ms.find_m_id(lhj_MemberVO);
		if(lhj_MemberVO2 == null) {
			model.addAttribute("check", 1);
		}else {
			model.addAttribute("check", 0);
			model.addAttribute("m_id", lhj_MemberVO2.getM_id());
		}
		return "member/find_m_id";
	}
	
	//로그인 비밀번호 찾기로 이동
	@RequestMapping(value = "/member/find_m_pw" )
	public String find_m_pw(Lhj_MemberVO lhj_MemberVO, Model model) {
		System.out.println("Lhj_Controller String find_m_pw start...");
		return "member/find_m_pw";
	}
	
	//로그인 비밀번호 찾기 실행
	@RequestMapping(value = "/member/find_m_pw", method = RequestMethod.POST)
	public String find_pwAction(Lhj_MemberVO lhj_MemberVO, Model model) {
		System.out.println("Lhj_Controller String find_pwAction start...");
		
		Lhj_MemberVO lhj_MemberVO2 = ms.find_m_pw(lhj_MemberVO);
		if(lhj_MemberVO2 == null) {
			model.addAttribute("check", 1);
		}else {
			model.addAttribute("check", 0);
			model.addAttribute("m_pw", lhj_MemberVO2.getM_pw());
		}
		return "member/find_m_pw";
	}
	
	//로그인 처리	//로그인 카카오 로그인이랑 네이버 로그인 api 추가할 예정
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String loginPOST(Lhj_MemberVO lhj_MemberVO, String m_id, Model model, HttpServletRequest request) throws Exception{
		System.out.println("LoginController login Start...");
		Lhj_MemberVO login = ms.login(lhj_MemberVO);
		System.out.println("LoginController result->" + login);
		if(login == null) {
			logger.info("아이디 혹은 비밀번호 오류");
			return "redirect:/member/login";
		}else {
			//세션유지
			request.getSession().setAttribute("sessionID", m_id);
			model.addAttribute("m_id", m_id);
			System.out.println("m_id->" + m_id);
			return "/main/main";
		}
	}
	
	//로그아웃 처리
	@RequestMapping(value = "/member/logout")
	public String logout(HttpSession session) {
		System.out.println("LoginController logout Start...");
		session.setAttribute("sessionID", null);
		session.invalidate();
		return "/main/main";
	}
	
	//마이페이지	//캘린더 api 추가 예정
	@RequestMapping(value = "/member/mypage")
	public String mypage(Model model, HttpServletRequest request, String m_id) throws Exception{
		System.out.println("lhjController mypage Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		System.out.println("아이디 잘 가져왓는지 확인"+m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		 
		return "/member/mypage";
	}
	
	//마이페이지 수정 폼
	@RequestMapping(value = "/member/mypage_update", method = RequestMethod.GET)
	public String mypage_update(Model model, HttpServletRequest request, String m_id) throws Exception{
		System.out.println("lhjController mypage_update Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		
		return "/member/mypage_update";
	}
	
	//마이페이지 수정 결과
	@RequestMapping(value = "/member/mypage_update", method = RequestMethod.POST)
	public String mypage_update(Model model, HttpServletRequest request, String m_id, HttpSession session, MultipartFile m_img) throws IOException, Exception {
		System.out.println("lhjController mypage_update222 Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
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
	
	//파일 업로드 관련
	private String uploadFile(String originalName, byte[] fileData , String uploadPath) 
			  throws Exception {
	     UUID uid = UUID.randomUUID();
	   // requestPath = requestPath + "/resources/image";
	    System.out.println("uploadPath->"+uploadPath);
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
	    FileCopyUtils.copy(fileData, target);   // org.springframework.util.FileCopyUtils
	    
	    return savedName;
	  }	
	
	//마이페이지 비밀번호 변경 화면
	@RequestMapping(value = "/member/mypage_changePW", method = RequestMethod.GET)
	public String mypage_changePW(Model model, HttpServletRequest request, String m_id) throws Exception{
		System.out.println("lhjController mypage_changePW Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		 
		return "/member/mypage_changePW";
	}
	//비밀번호 변경 결과
	@RequestMapping(value = "/member/mypage_changePW", method = RequestMethod.POST)
	public String mypage_changePW(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request, String m_id, HttpSession session) {
		System.out.println("lhjController mypage_changePW22 Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		lhj_MemberVO = ms.myPWchange(lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		
		return "/member/mypage_changePW";
	}
	
	//마이페이지 신청 내역	//결제 api 추가 예정
	@RequestMapping(value = "/member/mypage_myreginfo")
	public String myreginfo(Model model, HttpServletRequest request, String m_id) throws Exception{
		System.out.println("lhjController myreginfo Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		//전체 리스트
		List<Lhj_MemberVO> myRegInfoList = ms.myRegInfoList(m_id);
		//클래스 리스트
		List<Lhj_MemberVO> myRegInfo_classList = ms.myRegInfo_classList(m_id);
		//모임 리스트
		List<Lhj_MemberVO> myRegInfo_meetingList = ms.myRegInfo_meetingList(m_id); 
		
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);		
		model.addAttribute("myRegInfoList", myRegInfoList);
		model.addAttribute("myRegInfo_classList", myRegInfo_classList);
		model.addAttribute("myRegInfo_meetingList", myRegInfo_meetingList);
		 
		return "/member/mypage_myreginfo";
	}
	
	// 마이페이지 신청내역 post관련 보여주는거
	@RequestMapping(value = "/member/mypage_myreginfo_title")
	public String mypage_myreginfo_title(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request, String m_id) throws Exception{
		System.out.println("lhjController mypage_myreginfo_title Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		
		Lhj_MemberVO mypage_myreginfo_title = ms.mypage_myreginfo_title(lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", mypage_myreginfo_title);
		
		return "/member/mypage_myreginfo_title";
	}
	
	//마이페이지 신청내역 취소
	@RequestMapping(value = "/member/mypage_myreginfoDE", method = { RequestMethod.GET, RequestMethod.POST })
	public String myreginfoDE(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request, HttpSession session) throws Exception{
		System.out.println("lhjController myreginfo Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		String m_id = sessionID; 
		lhj_MemberVO = ms.myRGNO(lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		
		return "forward:/member/mypage_myreginfo";
	}
	
	
	//마이페이지 관심 내역
	@RequestMapping(value = "/member/mypage_mybookmark")
	public String mybookmark(Model model, HttpServletRequest request, String m_id) throws Exception{
		System.out.println("lhjController mybookmark Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		//전체 북마크 리스트
		List<Lhj_MemberVO> myBookMarkList = ms.myBookMarkList(m_id);
		//북마크 클래스 리스트
		List<Lhj_MemberVO> myBookMark_classList = ms.myBookMark_classList(m_id);
		//북마크 미팅 리스트
		List<Lhj_MemberVO> myBookMark_meetingList = ms.myBookMark_meetingList(m_id);
		model.addAttribute("myBookMarkList", myBookMarkList);
		model.addAttribute("myBookMark_classList", myBookMark_classList);
		model.addAttribute("myBookMark_meetingList", myBookMark_meetingList);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		
		return "/member/mypage_mybookmark";
	}
	
	//마이페이지 관심내역 신청
	@RequestMapping(value = "/member/mypage_mybookmarkSin", method = { RequestMethod.GET, RequestMethod.POST })
	public String mybookmarkSin(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("lhjController mybookmarkSin Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		String m_id = sessionID;
		lhj_MemberVO = ms.myBMtoRG(lhj_MemberVO);
		Lhj_MemberVO lhj_MemberVO2 = ms.myBMtoRG2(lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO2);
		
		return "forward:/member/mypage_myreginfo";
	}
	
	//마이페이지 관심내역 취소
	@RequestMapping(value = "/member/mypage_mybookmarkNO", method = { RequestMethod.GET, RequestMethod.POST })
	public String mybookmarkNO(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("lhjController mybookmarkSin Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		String m_id = sessionID;
		lhj_MemberVO = ms.myBMNO(lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		
		return "forward:/member/mypage_mybookmark";
	}

	//마이페이지 탈퇴 폼
	@RequestMapping(value = "/member/mypage_deleteMyself")
	public String myDelMySelf(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("lhjController mybookmarkSin Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		String m_id = sessionID;
		lhj_MemberVO = ms.selectMypage(m_id);
		System.out.println("아이디 잘 가져왓는지 확인 for pw"+m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		
		return "/member/mypage_deleteMyself";
	}
	
	//마이페이지 탈퇴
	@RequestMapping(value = "/member/mypage_deleteMyselfs", method = { RequestMethod.GET, RequestMethod.POST })
	public String myDelMySelf2(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("lhjController mybookmarkSin Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		String m_id = sessionID;
		lhj_MemberVO = ms.myDelMySelf2(lhj_MemberVO);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		
		return "forward:/member/logout";
	}
	
	//마이페이지 인증 화면
	@RequestMapping(value = "/member/mypage_mycertification", method = RequestMethod.GET)
	public String mypage_mycertification(Model model, HttpServletRequest request, String m_id) throws Exception{
		System.out.println("lhjController mypage_changePW Start...");
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		 
		return "/member/mypage_mycertification";
	}
	
	//마이페이지 내가 쓴 글 화면
	@RequestMapping(value = "/member/mypage_myPostList", method = RequestMethod.GET)
	public String mypage_myPostList(Model model, HttpServletRequest request, String m_id) throws Exception{
		System.out.println("lhjController mypage_changePW Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		 
		return "/member/mypage_myPostList";
	}
	
}