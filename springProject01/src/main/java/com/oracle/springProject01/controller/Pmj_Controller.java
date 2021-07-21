package com.oracle.springProject01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Pmj_Controller {
	@RequestMapping(value = "test2")
	public String test() {
		System.out.println("Pmj_Controller test Start...");
		return "test2";
	}
}
