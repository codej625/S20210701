package com.oracle.springProject01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Pmj_Controller {
	@RequestMapping(value = "/main/join")
	public String join() {
		System.out.println("/main/join Start...");
		return "main/join";
	}
}
