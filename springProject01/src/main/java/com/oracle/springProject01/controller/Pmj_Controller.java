package com.oracle.springProject01.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.oracle.springProject01.model.Lhj_MemberVO;
import com.oracle.springProject01.model.PmjChatVO;
import com.oracle.springProject01.service.PmjService.MemberService;

//import com.oracle.springProject01.service.chatting.Pmj_MemberService;

@Controller
public class Pmj_Controller {

	@Autowired
	private MemberService ms;
	
	@Autowired
	private com.oracle.springProject01.service.lhjService.MemberService es;

	@RequestMapping(value = "/chat/chat2")
	public ModelAndView chat2(HttpServletRequest request, Model model ,int bt_num, int bc_num, int p_num) throws Exception {
		System.out.println("Pmj_Controller chat Start...");
		String m_id = (String) request.getSession().getAttribute("sessionID");
		System.out.println("sessionID->"+m_id);
		PmjChatVO pmjChatVO = ms.detail(bt_num, bc_num, p_num);
		model.addAttribute("pmjChatVO",pmjChatVO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat/chat2");

		return mv;
	}
	
	// 채팅

	@RequestMapping(value = "/chat/chat")
	public ModelAndView chat(HttpServletRequest request, Model model, Lhj_MemberVO lhj_MemberVO) throws Exception {
		System.out.println("Pmj_Controller chat Start...");
		String m_id = (String) request.getSession().getAttribute("sessionID");
		// chatting
		lhj_MemberVO = es.selectMypage(m_id);
		model.addAttribute(lhj_MemberVO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat/chat");

		return mv;
	}

	// 관리자랑 대화하기
	@RequestMapping("/chat/user")
	public String user() {
		System.out.println("Pmj_Controller userchat start");
		return "chat/user";
	}

	@RequestMapping(value = "/chat/admin")
	public String admin(Model model, HttpServletRequest request) throws Exception {
		System.out.println("PmjController chaton Start ...");
		System.out.println("sessionID: " + (String) request.getSession().getAttribute("sessionID"));
		PmjChatVO pmjChatVO = ms.selectChat((String) request.getSession().getAttribute("sessionID"));
		String sessionNAME = pmjChatVO.getM_name();
		System.out.println(" sessionNAME:" + sessionNAME);
		model.addAttribute("sessionNAME", sessionNAME);
		model.addAttribute("pmjChatVO", pmjChatVO);
		return "chat/admin";
	}

	// 숨기기 기능 해놓은것

	@RequestMapping(value = "/chat/chat_addon") 
	public String chaton( Model  model, HttpServletRequest request) throws Exception{
			  System.out.println("PmjController chaton Start ..."); 
			  //String sessionNAME =(String) request.getSession().getAttribute("sessionNAME");
			  
			  //System.out.println("sessionNAME: " + sessionNAME);
			 System.out.println("sessionID: " + (String)
			  request.getSession().getAttribute("sessionID")); 
			 PmjChatVO pmjChatVO = ms.selectChat((String) request.getSession().getAttribute("sessionID"));
			  String m_name = pmjChatVO.getM_name(); System.out.println(" m_name:"+m_name);
			  //System.out.println(" sessionNAME->"+sessionNAME);
			  model.addAttribute("m_name", m_name); 
			  model.addAttribute("pmjChatVO", pmjChatVO); 
			  return "/chat/chat_addon"; 
			}

}
// 화상통화
/*
 * @RequestMapping(value = "/chat/web") public String web() {
 * System.out.println("/main/web Start..."); return "chat/web"; }
 */

// 화면공유
/*
 * @RequestMapping(value = "/chat/web2") public String web2() {
 * System.out.println("/main/web2 Start..."); return "chat/web2"; }
 */

// @RequestMapping("/chat/admin")
// public String admin( Model model, HttpServletRequest request, String m_name)
// throws Exception {
// System.out.println("Pmj_Controller admin start");
// System.out.println("sessionID:"+
// (String)request.getSession().getAttribute("sessionID"));
// PmjChatVO pmjChatVO = ms.selectChat((String)
// request.getSession().getAttribute("sessionID"));
// String m_name = pmjChatVO.getM_name();
// System.out.println("m_name"+m_name);
// model.addAttribute("m_name",m_name);
// model.addAttribute("pmjChatVO",pmjChatVO);
// return "chat/admin";
// }
