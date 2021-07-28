package com.oracle.springProject01.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.springProject01.model.ChePostVO;
import com.oracle.springProject01.service.cheService.MainService;
import com.oracle.springProject01.service.paging.MainPaging;

@Controller
public class Che_Controller {
	@Autowired
	private MainService ms;
	
	/*
	@RequestMapping(value = "main/main")
	public String mainForm() {
		System.out.println("Che_Controller mainForm Start...");
		return "main/main";
	}
	*/
	
	@RequestMapping(value = "main/main")
	public String mainGetForm(HttpServletRequest request, ChePostVO post, Model model) {
		System.out.println("Che_Controller mainForm Start...");
		
		int total = 5;
		String currentPage = null;
		MainPaging mg = new MainPaging(total, currentPage);
		post.setStart(mg.getStart());
		post.setEnd(mg.getEnd());
		int bt_num = 1;
		post.setBt_num(bt_num);
		System.out.println("Che_Controller mainGetForm bt_num -> " + post.getBt_num());
		
//		게시물 리스트
		List<ChePostVO> bestList = ms.bestListPost(post);
		
		System.out.println("Che_Controller mainGetForm listPost.size()->"+bestList.size());
		model.addAttribute("total", 5);
		model.addAttribute("bestList",bestList);
		model.addAttribute("bt_num",bt_num);
		return "main/main";
	}
	
	/*
	@RequestMapping(value = "member/login")
	public String loginForm() {
		System.out.println("Che_Controller loginForm Start...");
		return "member/login";
	}
	
	@RequestMapping(value = "member/join")
	public String joinForm() {
		System.out.println("Che_Controller joinForm Start...");
		return "member/join";
	}
	
	@RequestMapping(value = "member/mypage")
	public String mypageForm() {
		System.out.println("Che_Controller mypageForm Start...");
		return "member/mypage";
	}
	
	@RequestMapping(value = "board/category")
	public String categoryForm() {
		System.out.println("Che_Controller categoryForm Start...");
		return "board/category";
	}
	
	@RequestMapping(value = "board/register")
	public String registerForm() {
		System.out.println("Che_Controller registerForm Start...");
		return "board/register";
	}
	
	@RequestMapping(value = "test")
	public String test() {
		System.out.println("Che_Controller test Start...");
		return "test";
	}*/
}
