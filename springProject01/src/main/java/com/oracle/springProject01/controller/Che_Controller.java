package com.oracle.springProject01.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.springProject01.model.ChePostVO;
import com.oracle.springProject01.model.Post;
import com.oracle.springProject01.service.cheService.MainService;
import com.oracle.springProject01.service.paging.MainPaging;
import com.oracle.springProject01.service.paging.Paging;
import com.oracle.springProject01.service.yjhService.PostService;

@Controller
public class Che_Controller {
	@Autowired
	private MainService ms;
	@Autowired
	private PostService ps;
	
	@RequestMapping(value = "main/main")
	public String mainGetForm(HttpServletRequest request, ChePostVO post1, ChePostVO post2, Model model) {
		System.out.println("Che_Controller mainForm Start...");
		
		int total = 5;
		int bt_num1 = 1;
		int bt_num2 = 2;
		
		List<ChePostVO> bestList1 = null;
		List<ChePostVO> bestList2 = null;
		
		String currentPage = null;
		MainPaging mg = new MainPaging(total, currentPage);
		post1.setStart(mg.getStart());
		post1.setEnd(mg.getEnd());
		post1.setBt_num(bt_num1);
		System.out.println("Che_Controller mainGetForm bt_num1 -> " + post1.getBt_num());
		bestList1 = ms.bestListPost(post1);
		System.out.println("Che_Controller mainGetForm bestList1 listPost.size()->"+bestList1.size());
		
		post2.setStart(mg.getStart());
		post2.setEnd(mg.getEnd());
		post2.setBt_num(bt_num2);
		System.out.println("Che_Controller mainGetForm bt_num2 -> " + post2.getBt_num());
		bestList2 = ms.bestListPost(post2);
		System.out.println("Che_Controller mainGetForm bestList2 listPost.size()->"+bestList2.size());

		model.addAttribute("bt_num1",post1.getBt_num());
		System.out.println("Che_Controller mainGetForm bt_num1 -> " + post1.getBt_num());
		model.addAttribute("bt_num2",post2.getBt_num());
		System.out.println("Che_Controller mainGetForm bt_num2 -> " + post2.getBt_num());
		model.addAttribute("bestList1",bestList1);
		model.addAttribute("bestList2",bestList2);
		
		return "main/main";
	}
	/*
	@GetMapping(value = "/post/category")
	public String list(HttpServletRequest request, Post post, String currentPage, Model model) {
		System.out.println("Yjh_Controller String list() Start...");
//		게시물 갯수
		int total = ps.total();
		int bt_num = Integer.parseInt(request.getParameter("bt_num"));
		int bc_num = Integer.parseInt(request.getParameter("bc_num"));
		
		System.out.println("Yjh_Controller String list() total->"+total);
		System.out.println("Yjh_Controller currentPage -> " + currentPage);
//		페이징 처리
		Paging pg = new Paging(total, currentPage);
		post.setStart(pg.getStart());
		post.setEnd(pg.getEnd());
		post.setBt_num(bt_num);
		post.setBt_num(bc_num);
		
//		게시물 리스트
		List<Post> listPost = ps.listPost(post);
		System.out.println("Yjh_Controller String list() listPost.size()->"+listPost.size());
		model.addAttribute("total",total);
		model.addAttribute("listPost",listPost);
		model.addAttribute("pg",pg);
		model.addAttribute("bt_num",bt_num);
		model.addAttribute("bc_num",bc_num);
		return "post/category";
	}
	@GetMapping("/post/category/search")
	public String mainSearch(@RequestParam(value="keyword") String keyword, Post post, Model model) {
		System.out.println("Che_Controller mainSearch keyword -> " + keyword);
		
		List<Post> listPost = ms.searchPost(keyword);
		model.addAttribute("listPost", listPost);
		
		return "post/category";
	}*/
}
