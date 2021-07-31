package com.oracle.springProject01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.springProject01.model.Member;
import com.oracle.springProject01.service.ljwService.MemberService;
import com.oracle.springProject01.service.paging.LjwPaging;

@Controller
public class Ljw_Controller {

	@Autowired
	private MemberService ms;

	@RequestMapping(value = "/admin/index")
	public String test() {
		System.out.println("Ljw_Controller test Start...");

		return "admin/index";
	}

//	@RequestMapping(value = "/main/category")
//	public String test() {
//		System.out.println("Ljw_Controller test Start...");
//		return "main/category";
//	}

	@RequestMapping(value = "/admin/table")
	public String list(Member member, String currentPage, Model model) {
		System.out.println("EmpController list Start...");
		int total = ms.total();
		System.out.println("EmpController total=>" + total);
		System.out.println("currentPage=>" + currentPage);

		LjwPaging pg = new LjwPaging(total, currentPage);
		member.setStart(pg.getStart());
		member.setEnd(pg.getEnd());
		List<Member> listMember = ms.listMember(member);
		System.out.println("Ljw_Controller list listMember.size()=>" + listMember.size());
		model.addAttribute("listMember", listMember);
		model.addAttribute("total", total);
		model.addAttribute("pg", pg);

		return "admin/table";
	}

	@RequestMapping(value = "/admin/masterauth")
	public String masterauth1() {

		System.out.println("Ljw_Controller masterauth Start...");

		return "admin/masterauth";
	}

	@PostMapping(value = "/admin/update")
	public String masterauth(String m_id, Model model) {
		int tot = 0;
		System.out.println("Ljw_Controller masterauth Start...");
		tot = ms.masterauth(m_id);
		model.addAttribute("num", tot);
		return "forward:/admin/index";
	}
}
