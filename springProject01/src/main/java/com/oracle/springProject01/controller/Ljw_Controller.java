package com.oracle.springProject01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ljw_Controller {
<<<<<<< HEAD
	@RequestMapping(value = "/main/join")
	public String test() {
		System.out.println("Ljw_Controller test Start...");
		return "main/join";
=======
	@RequestMapping(value = "/main/category")
	public String test() {
		System.out.println("Ljw_Controller test Start...");
		return "main/category";
>>>>>>> 7de17e9b3e4a98ce20c0a522dfecb812985ad758
	}

}
