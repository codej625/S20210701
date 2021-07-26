package com.oracle.springProject01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.springProject01.model.Post;
import com.oracle.springProject01.service.paging.Paging;
import com.oracle.springProject01.service.yjhService.BoardCategoryService;
import com.oracle.springProject01.service.yjhService.PostService;

@Controller
public class Yjh_Controller {

	@Autowired
	private PostService ps;
	
	@Autowired
	private BoardCategoryService bcs;

	@GetMapping(value = "/post/category")
	public String list(Post post, String currentPage, Model model) {
		System.out.println("Yjh_Controller String list() Start...");
//		게시물 갯수
		int total = ps.total();
		System.out.println("Yjh_Controller String list() total->"+total);
//		페이징 처리
		Paging pg = new Paging(total, currentPage);
		post.setStart(pg.getStart());
		post.setEnd(pg.getEnd());
//		게시물 리스트
		List<Post> listPost = ps.listPost(post);
		System.out.println("Yjh_Controller String list() listPost.size()->"+listPost.size());
		model.addAttribute("total",total);
		model.addAttribute("listPost",listPost);
		model.addAttribute("pg",pg);
		return "post/category";
	}
	
//	개설하기 버튼
	@RequestMapping(value = "/post/add")
	public String add() {
		System.out.println("Yjh_Controller void add() start...");
		return "post/add";
	}
	
//	게시물 작성
	@GetMapping(value = "/post/register")
	public String register(int bt_num) {
		System.out.println("Yjh_Controller list Start...");
		
		return "post/register";
	}
//	@RequestMapping(value = "/main/main")
//	public String test() {
//		System.out.println("Yjh_Controller main/main Start...");
//		
//		return "main/main";
//	}

}
