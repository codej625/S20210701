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
import com.oracle.springProject01.model.Report;
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

	// 개설 권한 인증 요청 리스트
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

	// 권한 인증
	@PostMapping(value = "/admin/authority")
	public String authority(MemberVo memberVo, Model model) {
		System.out.println("Ljw_Controller authority Start");
		int update = 0;

		if ((memberVo != null)) {
			// 두개의 필드 속에 값이 없어야 실행 가능한 조건
			if (memberVo.getM_meetingauth() == null && memberVo.getM_masterauth() == null) {
				for (String m_id : memberVo.getM_idArray()) {
					// 배열에서 m_id를 하나씩 set
					memberVo.setM_id(m_id);
					// m_id null check
					if (memberVo.getM_id() != null) {
						// m_id value check
						System.out.println("member.getM_id()->" + memberVo.getM_id());
						memberVo = ms.authorityList(memberVo);
						update = ms.authority(memberVo);
						model.addAttribute("result", update);
					}
				}
			} else {
				// 개별적으로 가져오는 값을 처리하는 로직
				for (String m_id : memberVo.getM_idArray()) {
					memberVo.setM_id(m_id);
					if (memberVo.getM_id() != null) {
						if (memberVo.getM_masterauth() == null) {
							memberVo = ms.authorityList(memberVo);
							memberVo.setM_masterauth("M");
							memberVo.setM_meetingauth("N");
							update = ms.authority2(memberVo);
						} else if (memberVo.getM_meetingauth() == null) {
							memberVo = ms.authorityList(memberVo);
							memberVo.setM_meetingauth("M");
							memberVo.setM_masterauth("N");
							update = ms.authority2(memberVo);
						}
						model.addAttribute("result", update);
					}
				}
			}
		}
		return "forward:/admin/admin_main";
	}

	// 신고 기능
	@PostMapping(value = "/admin/report")
	public String report(Report report) {
		System.out.println("Ljw_Controller report Start");
		if (report != null) {
			ms.report(report);
		}
		return "member/mypage";
	}
}
