package com.oracle.springProject01.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@GetMapping(value = "/main/main")
	public String maingogo() {
		return "main/main";
	}

//	겟방식 게시물 리스트 불러오기
	@RequestMapping(value = "/post/category", method= {RequestMethod.GET, RequestMethod.POST})
	public String categoryGet(Integer bt_num, Integer bc_num, Post post, String currentPage, Model model) {
		System.out.println("Yjh_Controller categoryGet Start...");
		int total = 0;
//		유형번호만 눌렀을때 카테고리값을 0으로
		if(bc_num == null) bc_num = 0;
//		게시물 갯수를 가져오기
		total = ps.total(bt_num,bc_num);
		System.out.println("Yjh_Controller categoryGet total->" + total);
//		페이징 처리
		Paging pg = new Paging(total, currentPage);
		post.setStart(pg.getStart());
		post.setEnd(pg.getEnd());
//		게시물 리스트
		List<Post> listPost = ps.listPost(post);
//		for(Post post1 : listPost ) {
//			System.out.println("Yjh_Controller categoryGet post1.getP_title()->"+post1.getP_title());
//		}
		System.out.println("Yjh_Controller String list() listPost.size()->" + listPost.size());
		model.addAttribute("total", total);
		model.addAttribute("listPost", listPost);
		model.addAttribute("pg", pg);
		model.addAttribute("bt_num",bt_num);
		model.addAttribute("bc_num",bc_num);
		return "post/category";
	}

////	포스트방식 게시물 리스트 불러오기
//	@PostMapping(value = "/post/category")
//	public String categoryPost(Post post, String currentPage, Model model) {
//		System.out.println("Yjh_Controller categoryPost Start...");
////		게시물 갯수
//		int total = ps.total();
//		System.out.println("Yjh_Controller categoryGet total->" + total);
////		페이징 처리
//		Paging pg = new Paging(total, currentPage);
//		post.setStart(pg.getStart());
//		post.setEnd(pg.getEnd());
////		게시물 리스트
//		List<Post> listPost = ps.listPost(post);
//		System.out.println("Yjh_Controller String list() listPost.size()->" + listPost.size());
//		model.addAttribute("total", total);
//		model.addAttribute("listPost", listPost);
//		model.addAttribute("pg", pg);
//		return "post/category";
//	}

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
			return "forward:/post/category";
		} else {
			model.addAttribute("msg", "바보");
			return "forward:add";
		}
//			return "redirect:category";
//			return "forward:category";
	}

}
