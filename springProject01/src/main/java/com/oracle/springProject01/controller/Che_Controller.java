package com.oracle.springProject01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Che_Controller {
	@RequestMapping(value = "main/main")
	public String mainForm() {
		System.out.println("Che_Controller mainForm Start...");
		return "main/main";
	}
	
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
}
