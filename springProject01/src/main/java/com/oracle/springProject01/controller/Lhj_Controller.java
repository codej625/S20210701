package com.oracle.springProject01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lhj_Controller {
	
//	@Autowired
//	public Lhj_Controller()

	@RequestMapping(value = "/login/loginForm")
	public String loginForm() {
		System.out.println("Lhj_Controller test Start...");
		return "login/loginForm";
	}
	
	
	
	
}
