 package com.oracle.springProject01.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oracle.springProject01.model.Lhj_MemberVO;
import com.oracle.springProject01.service.lhj_login.MemberService;

@Controller
public class Lhj_Controller {
	
	@Autowired
	private	MemberService ms;
	
	//로깅
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(Lhj_Controller.class);
	
	//메인화면
	@RequestMapping(value = "/main/main")
	public String main() {
		System.out.println("go main");
		return "main/main";
	}
	
	//회원가입 화면
	@RequestMapping(value = "/main/join", method = RequestMethod.GET)
	public String insertGET() throws Exception {
		System.out.println("Lhj_Controller String insertGET start...");
		logger.info("C: 회원가입 입력페이지 GET");
		return "main/join";
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
	
	//로그인 화면
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String loginGET() throws Exception{
		System.out.println("Lhj_Controller String loginGET start...");
		logger.info("C: 로그인 입력페이지 GET");
		return "member/login";
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
		System.out.println("아이디 잘 가져왓는지 확인"+m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		
		return "/member/mypage_update";
	}
	
	//마이페이지 수정 결과
	@RequestMapping(value = "/member/mypage_update", method = RequestMethod.POST)
	public String mypage_update(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request, String m_id, HttpSession session) {
		System.out.println("lhjController mypage_update222 Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		lhj_MemberVO = ms.mypageUpdate(lhj_MemberVO);
		System.out.println("아이디 잘 가져왓는지 확인22"+m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		
		return "/member/mypage_update";
	}
	
	//마이페이지 비밀번호 변경 화면
	@RequestMapping(value = "/member/mypage_changePW", method = RequestMethod.GET)
	public String mypage_changePW(Model model, HttpServletRequest request, String m_id) throws Exception{
		System.out.println("lhjController mypage_changePW Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		System.out.println("아이디 잘 가져왓는지 확인 for pw"+m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		 
		return "/member/mypage_changePW";
	}
	//비밀번호 변경 아직 미와ㄴ성
	@RequestMapping(value = "/member/mypage_changePW", method = RequestMethod.POST)
	public String mypage_changePW(Lhj_MemberVO lhj_MemberVO, Model model, HttpServletRequest request, String m_id, HttpSession session) {
		System.out.println("lhjController mypage_changePW22 Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		lhj_MemberVO = ms.myPWchange(lhj_MemberVO);
		System.out.println("아이디 잘 가져왓는지 확인22"+m_id);
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
		List<Lhj_MemberVO> myRegInfoList = ms.myRegInfoList(m_id);
		model.addAttribute("myRegInfoList", myRegInfoList);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		 
		return "/member/mypage_myreginfo";
	}
	
	//마이페이지 관심 내역
	@RequestMapping(value = "/member/mypage_mybookmark")
	public String mybookmark(Model model, HttpServletRequest request, String m_id) throws Exception{
		System.out.println("lhjController mybookmark Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		List<Lhj_MemberVO> myBookMarkList = ms.myBookMarkList(m_id);
		model.addAttribute("myBookMarkList", myBookMarkList);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		
		return "/member/mypage_mybookmark";
	}
	
	

	
	

}
