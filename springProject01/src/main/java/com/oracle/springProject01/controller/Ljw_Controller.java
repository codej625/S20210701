package com.oracle.springProject01.controller;

import java.io.File;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.springProject01.model.AttachmentFile;
import com.oracle.springProject01.model.AttachmentFileVO;
import com.oracle.springProject01.model.Lhj_MemberVO;
import com.oracle.springProject01.model.Member;
import com.oracle.springProject01.service.ljwService.MemberService;
import com.oracle.springProject01.service.paging.LjwPaging;

@Controller
public class Ljw_Controller {

	@Autowired
	private MemberService ms;

	@Autowired
	private JavaMailSender mailSender;

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

	@RequestMapping(value = "/admin/test")
	public String test2() {
		System.out.println("Ljw_Controller masterauth Start...");
		return "admin/test";
	}

	@PostMapping(value = "/admin/upload")
	public String upload(AttachmentFileVO attachmentFileVO, Model model) throws Exception {
		System.out.println("Ljw_Controller upload Start...");
//======첨부파일을 로컬에 저장===================================================================

//======MultipartFile 객체로 파일을 받아서 for문으로 하나씩 빼서 저장===================================
		for (MultipartFile file : attachmentFileVO.getFiles()) {
			String originalfileName = file.getOriginalFilename();

//==========C:/Image/ + 원본 파일이름으로 저장===================================================
			File dest = new File("C:/Images/" + originalfileName);
			file.transferTo(dest);
			System.out.println(attachmentFileVO.getFiles());
//==========VO로 받은 files 갯수 확인용 Message==================================================
			System.out.println("files->" + attachmentFileVO.getFiles().size());
		}

//======데이터 값을 DB에 저장하기 위해 DTO 단위로 Service로 보냄========================================
		List<AttachmentFileVO> f = ms.test(attachmentFileVO);

		System.out.println("files->" + attachmentFileVO.getFiles().size());
//======List를 Model 객체에 에 담아서 return=====================================================
		model.addAttribute("f", f);
		return "admin/index";
	}

//	@RequestMapping(value = "/admin/test10")
//	public String check(AttachmentFile attachmentFile, Model model) {
//		System.out.println("Test2 Controller list Start...");
//		attachmentFile.setTest("aaaaaa@aaaaaa.com");
//		List<AttachmentFile> check = ms.check(attachmentFile);
//		System.out.println("값 넘어왔음?->" + check);
//		model.addAttribute("check", check);
//
//		return "admin/test10";
//	}
	
//	@RequestMapping(value = "/admin/mailTransport", method = RequestMethod.POST)
//	@ResponseBody
//	public String mailTransport(HttpServletRequest request, Model model, Lhj_MemberVO lhj_MemberVO) {
//		System.out.println("Mail Sending Start...");
////======받는 사람 이메일
//		String tomail = lhj_MemberVO.getM_id();
//		System.out.println(tomail);
//		String setfrom = "dkwksla@gmail.com";
//		String title = "인증번호 입니다.";
//		try {
//			MimeMessage message = mailSender.createMimeMessage();
//			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
////==========보내는 사람			
//			messageHelper.setFrom(setfrom);
////==========받는 사람
//			messageHelper.setTo(tomail);
////==========메일 제목			
//			messageHelper.setSubject(title);
////==========랜덤 인증번호 만들기
//			String tempPassword = (int) (Math.random() * 999999) + 1 + "";
//			lhj_MemberVO.setM_mail(tempPassword);
//			messageHelper.setText("인증번호 : " + tempPassword);
//			System.out.println("인증번호 : " + tempPassword);
//			mailSender.send(message);
////==========정상 전달시 메세지
//			System.out.println("Mail Sending End...");
//			ms.mail(lhj_MemberVO);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println("전송 실패");
//		}
//		return "null";
//	}

}
