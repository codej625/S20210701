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
	
	@RequestMapping(value = "main/main")
	public String mainGetForm(HttpServletRequest request, ChePostVO post1, ChePostVO post2, Model model) {
		System.out.println("Che_Controller mainForm Start...");
		
		int total = 5;
		int bt_num1 = 1;
		int bt_num2 = 2;
		
		String currentPage = null;
		MainPaging mg = new MainPaging(total, currentPage);
		post1.setStart(mg.getStart());
		post1.setEnd(mg.getEnd());
		post1.setBt_num(bt_num1);
		System.out.println("Che_Controller mainGetForm bt_num -> " + post1.getBt_num());
		
		post2.setStart(mg.getStart());
		post2.setEnd(mg.getEnd());
		post2.setBt_num(bt_num2);
		System.out.println("Che_Controller mainGetForm bt_num -> " + post2.getBt_num());
		
//		게시물 리스트
		List<ChePostVO> bestList1 = ms.bestListPost(post1);
		System.out.println("Che_Controller mainGetForm bestList1 listPost.size()->"+bestList1.size());
		List<ChePostVO> bestList2 = ms.bestListPost(post2);
		System.out.println("Che_Controller mainGetForm bestList2 listPost.size()->"+bestList2.size());
		
		model.addAttribute("total", 5);
		model.addAttribute("bt_num1",bt_num1);
		model.addAttribute("bt_num2",bt_num2);
		model.addAttribute("bestList1",bestList1);
		model.addAttribute("bestList2",bestList2);
		
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
