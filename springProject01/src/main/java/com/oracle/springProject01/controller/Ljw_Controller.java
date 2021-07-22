package com.oracle.springProject01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ljw_Controller {
	@RequestMapping(value = "/login/login")
	public String test() {
		System.out.println("Ljw_Controller test Start...");
		return "login/login";
	}

}
