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
	
	// 메인화면
	@RequestMapping(value = "main/main")
	public String mainGetForm(HttpServletRequest request, Post post, Model model) {
		System.out.println("********* Che_Controller mainForm Start *********");
		
		int total = 5;
		int bt_num1 = 1;
		int bt_num2 = 2;
		
		List<Post> bestList1 = null;
		List<Post> bestList2 = null;
		
		String currentPage = null;
		MainPaging mg = new MainPaging(total, currentPage);
		post.setStart(mg.getStart());
		post.setEnd(mg.getEnd());
		post.setBt_num(bt_num1);
		System.out.println("Che_Controller mainGetForm bt_num1 -> " + post.getBt_num());
		bestList1 = ms.bestListPost(post);
		System.out.println("Che_Controller mainGetForm bestList1 listPost.size()->"+bestList1.size());
		
		post.setStart(mg.getStart());
		post.setEnd(mg.getEnd());
		post.setBt_num(bt_num2);
		System.out.println("Che_Controller mainGetForm bt_num2 -> " + post.getBt_num());
		bestList2 = ms.bestListPost(post);
		System.out.println("Che_Controller mainGetForm bestList2 listPost.size()->"+bestList2.size());

		model.addAttribute("bt_num1", bt_num1);
		System.out.println("Che_Controller mainGetForm bt_num1 -> " + post.getBt_num());
		model.addAttribute("bt_num2", bt_num2);
		System.out.println("Che_Controller mainGetForm bt_num2 -> " + post.getBt_num());
		model.addAttribute("bestList1",bestList1);
		model.addAttribute("bestList2",bestList2);
		
		return "main/main";
	}
	
	// 검색
	@GetMapping("/post/category/search")
	public String mainSearch(@RequestParam(value="keyword") String keyword, String currentPage, Post post, Model model) {
		System.out.println("********* Che_Controller mainSearch start *********");
		
		int total = 0;
		total = ms.searchTotal(keyword);
		Paging pg = new Paging(total, currentPage);
		
		System.out.println("Che_Controller mainSearch keyword -> " + keyword);
		post.setKeyword(keyword);
		post.setStart(pg.getStart());
		post.setEnd(pg.getEnd());
		List<Post> listPost = ms.searchPost(post);
		model.addAttribute("listPost", listPost);
		
		return "post/category";
	}
	
	// 출석체크
	@RequestMapping(value = "main/check")
	public String checkEvent() {
		System.out.println("********* Che_Controller checkEvent start *********");
		
		
		
		return "main/check";
	}
	
}
