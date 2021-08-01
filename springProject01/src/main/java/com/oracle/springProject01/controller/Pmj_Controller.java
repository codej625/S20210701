package com.oracle.springProject01.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import com.oracle.springProject01.service.chatting.Pmj_MemberService;



@Controller
public class Pmj_Controller {
		
	  //화상통화
	@RequestMapping(value = "/chat/web")
	public String web() {
		System.out.println("/main/web Start...");
		return "chat/web";
	}
	//화면공유
	@RequestMapping(value = "/chat/web2")
	public String web2() {
		System.out.println("/main/web2 Start...");
		return "chat/web2";
	}
	//채팅
	
	  @RequestMapping(value = "/chat/chat")
	  public ModelAndView chat(Model model) throws Exception {
	  System.out.println("Pmj_Controller chat Start..."); 
	  //chatting 
	  ModelAndView  mv = new ModelAndView(); 
	  mv.setViewName("chat/chat");  	  
	
	 	return mv;}
	  
	  @RequestMapping("/chat/chat3")
	    public String viewChatPage() {
		  System.out.println("Pmj_Controller chat3 Start..."); 
	        return "chat/chat3";
	    }
	  
	
	


		
	
		
	
		
	
		

}
