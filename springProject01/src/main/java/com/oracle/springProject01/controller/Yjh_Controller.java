package com.oracle.springProject01.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.springProject01.dao.member.Member;
import com.oracle.springProject01.model.Post;
import com.oracle.springProject01.service.paging.Paging;
import com.oracle.springProject01.service.yjhService.BoardCategoryService;
import com.oracle.springProject01.service.yjhService.MemberService;
import com.oracle.springProject01.service.yjhService.PostService;

@Controller
public class Yjh_Controller {

	@Autowired
	private PostService ps;

	@Autowired
	private BoardCategoryService bcs;

	@Autowired
	private MemberService ms;

//	겟방식 게시물 리스트 불러오기
	@GetMapping(value = "/post/category")
	public String categoryGet(Post post, String currentPage, Model model) {
		System.out.println("Yjh_Controller categoryGet Start...");
//		게시물 갯수
		int total = ps.total();
		System.out.println("Yjh_Controller categoryGet total->" + total);
//		페이징 처리
		Paging pg = new Paging(total, currentPage);
		post.setStart(pg.getStart());
		post.setEnd(pg.getEnd());
//		게시물 리스트
		List<Post> listPost = ps.listPost(post);
		System.out.println("Yjh_Controller String list() listPost.size()->" + listPost.size());
		model.addAttribute("total", total);
		model.addAttribute("listPost", listPost);
		model.addAttribute("pg", pg);
		return "post/category";
	}

//	포스트방식 게시물 리스트 불러오기
	@PostMapping(value = "/post/category")
	public String categoryPost(Post post, String currentPage, Model model) {
		System.out.println("Yjh_Controller categoryPost Start...");
//		게시물 갯수
		int total = ps.total();
		System.out.println("Yjh_Controller categoryGet total->" + total);
//		페이징 처리
		Paging pg = new Paging(total, currentPage);
		post.setStart(pg.getStart());
		post.setEnd(pg.getEnd());
//		게시물 리스트
		List<Post> listPost = ps.listPost(post);
		System.out.println("Yjh_Controller String list() listPost.size()->" + listPost.size());
		model.addAttribute("total", total);
		model.addAttribute("listPost", listPost);
		model.addAttribute("pg", pg);
		return "post/category";
	}

//	모임/클래스 개설하기 버튼
	@RequestMapping(value = "/post/add")
	public String add() {
		System.out.println("Yjh_Controller void add() start...");
		return "post/add";
	}

//	게시물 작성  폼
	@GetMapping(value = "/post/register")
	public String register(HttpServletRequest request, Member member, int bt_num, Model model) {
		System.out.println("Yjh_Controller String register Start...");
//		List<Member> listMember = ms.listMember(member);
//		model.addAttribute("member",member);
//		게시물번호
		int p_num = 0;
//		페이지넘
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null)
			pageNum = "1";
		model.addAttribute("p_num", p_num);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("bt_num", bt_num);
		System.out.println("bt_num->" + bt_num);
		return "post/register";
	}

//	게시물 작성
	@PostMapping(value = "/post/insert")
	public String postInsert(Post post, Model model) {
		System.out.println("Yjh_Controller String postInsert start...");
		System.out.println("post.p_cost: " + post.getP_cost());
		System.out.println(post.getP_starttime());
//		post.setP_cost(Integer.parseInt(p_cost));
		int result = ps.postInsert(post);
		System.out.println("Yjh_Controller postInsert result->" + result);
		if (result > 0) {
			return "forward:category";
		} else {
			model.addAttribute("msg", "바보");
			return "forward:add";
		}
//			return "redirect:category";
//			return "forward:category";
	}

}
