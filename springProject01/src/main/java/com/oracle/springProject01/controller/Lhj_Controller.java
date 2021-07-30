package com.oracle.springProject01.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oracle.springProject01.model.Lhj_MemberVO;
import com.oracle.springProject01.service.Lhj_login.MemberService;


@Controller
public class Lhj_Controller {
	
	@Autowired
	private	MemberService ms;

//	private MemberService service; 
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(Lhj_Controller.class);
	
	//회원가입
	@RequestMapping(value = "/main/join", method = RequestMethod.GET)
	public String insertGET() throws Exception {
		System.out.println("Lhj_Controller String insertGET start...");
		logger.info("C: 회원가입 입력페이지 GET");
		return "main/join";
	}
	
	@RequestMapping(value = "/members/join", method = RequestMethod.POST)
	public String insertPOST(Lhj_MemberVO lhj_MemberVO) throws Exception{
		System.out.println("Lhj_Controller String insertPOST start...");
		logger.info("C: "+ lhj_MemberVO);
		ms.insertMember(lhj_MemberVO);		
		logger.info("C: 회원가입 처리페이지 POST");
		
		return "member/login";
	}
	
	//로그인
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String loginGET() throws Exception{
		System.out.println("Lhj_Controller String loginGET start...");
		logger.info("C: 로그인 입력페이지 GET");
		return "member/login";
	}
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	   public String loginPOST(Lhj_MemberVO lhj_MemberVO, String m_id, Model model, HttpServletRequest request) throws Exception{
	      System.out.println("LoginController login Start...");
	      Lhj_MemberVO login = ms.login(lhj_MemberVO);
	      System.out.println("LoginController result->" + login);
	      if(login == null) {
	         logger.info("아이디 혹은 비밀번호 오류");
	         return "redirect:/member/login";
	      } else {
	         //세션유지
	         request.getSession().setAttribute("sessionID", m_id);
	         String m_name = login.getM_name();
	         model.addAttribute("m_name", m_name);
	         System.out.println("m_name -> " + m_name);
	         model.addAttribute("m_id", m_id);
	         System.out.println("m_id -> " + m_id);
	         return "/main/main";
	      }
	   }
	//마이페이지
	@RequestMapping(value = "/member/mypage")
	public String mypage(Model model, HttpServletRequest request, String m_id) throws Exception{
		System.out.println("lhjController mypage Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.selectMypage(m_id);
		System.out.println("아이디 잘 가져왓는지 확"+m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		 
		return "/member/mypage";
	}
	//마이페이지 수정//아직 미완성이에요 마이페이지 상세정보 조회만 가능해요~!
	@RequestMapping(value = "/member/mypage_update")
	public String mypage_update(Model model, HttpServletRequest request, String m_id) throws Exception{
		System.out.println("lhjController mypage Start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		m_id = sessionID;
		Lhj_MemberVO lhj_MemberVO = ms.mypageUpdate(m_id);
		System.out.println("아이디 잘 가져왓는지 확"+m_id);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		 
		return "/member/mypage_update";
	}
	   //로그아웃 처리
	   @RequestMapping(value = "/member/logout")
	   public String logout(HttpSession session) {
	      System.out.println("LoginController logout Start...");
	      session.invalidate();
	      return "/main/main";
	   }

	

}
