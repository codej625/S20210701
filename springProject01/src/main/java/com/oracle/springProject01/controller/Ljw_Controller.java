package com.oracle.springProject01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.springProject01.model.Member;
import com.oracle.springProject01.model.MemberVo;
import com.oracle.springProject01.service.ljwService.MemberService;
import com.oracle.springProject01.service.paging.LjwPaging;

@Controller
public class Ljw_Controller {

	@Autowired
	private MemberService ms;

	// admin_main page 접속
	@RequestMapping(value = "/admin/admin_main")
	public String admin_main() {
		System.out.println("Ljw_Controller admin_main Start");
		return "admin/admin_main";
	}

	// user_list page 접속
	@RequestMapping(value = "/admin/user_list")
	public String user_list(Member member, String currentPage, Model model) {
		System.out.println("Ljw_Controller user_list Start");

		int total = ms.total();
		System.out.println("Ljw_Controller total=>" + total);

		System.out.println("currentPage=>" + currentPage);
		LjwPaging pg = new LjwPaging(total, currentPage);
		member.setStart(pg.getStart());
		member.setEnd(pg.getEnd());
		List<Member> user_list = ms.memberList(member);

		model.addAttribute("user_list", user_list);
		model.addAttribute("total", total);
		model.addAttribute("pg", pg);

		return "admin/user_list";
	}

	// 회원 권한 해제
	@RequestMapping(value = "/admin/user_delete", method = RequestMethod.POST)
	public String user_delete(String[] m_idArray, Model model) {
		System.out.println("Ljw_Controller user_delete Start");
		int delete = 0;
		String m_id = "";

		if (m_idArray != null) {
			for (int i = 0; i < m_idArray.length; i++) {
				m_id = m_idArray[i];
			}
			delete = ms.user_delete(m_id);
			System.out.println("ok");
			model.addAttribute("result", delete);
			return "forward:/admin/admin_main";
		} else if (m_idArray == null) {
			System.out.println("error");
			m_id = "입력 된 값이 없습니다.";
			model.addAttribute("value", m_id);
		}
		return "forward:/admin/user_list";
	}

	@RequestMapping(value = "/admin/authority_list")
	public String authority_list(Member member, String currentPage, Model model) {
		System.out.println("Ljw_Controller authority_list Start");
		int a_total = ms.a_total();
		System.out.println("EmpController total=>" + a_total);
		System.out.println("currentPage=>" + currentPage);

		LjwPaging pg = new LjwPaging(a_total, currentPage);
		member.setStart(pg.getStart());
		member.setEnd(pg.getEnd());
		List<Member> auth_listMember = ms.auth_listMember(member);
		System.out.println("Ljw_Controller auth_listMember.size()=>" + auth_listMember.size());
		model.addAttribute("auth_listMember", auth_listMember);
		model.addAttribute("total", a_total);
		model.addAttribute("pg", pg);

		return "admin/authority_list";
	}

	@PostMapping(value = "/admin/authority")
	public String authority(String[] m_idArray, Model model) {
		System.out.println("Ljw_Controller authority Start");
		MemberVo member = new MemberVo();
		for (String m_id : m_idArray) {
			System.out.println(m_id);
			member = ms.authorityList(m_id);
			System.out.println("member.getM_id()->" + member.getM_id());
			ms.authority(member);
		}
		return "/admin/admin_main";
	}
}
