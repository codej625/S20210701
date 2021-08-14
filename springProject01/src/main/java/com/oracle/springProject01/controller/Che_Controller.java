package com.oracle.springProject01.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.springProject01.model.RecentPost;
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
	public String mainGetForm(HttpServletRequest request, RecentPost rpost, Post post, Model model) {
		System.out.println("********* Che_Controller mainForm Start *********");
		
		int best_total = 5;
		int bt_num1 = 1;
		int bt_num2 = 2;
		int rp_total = 0;
		
		// 모임/클래스 Best5
		List<Post> bestList1 = null;
		List<Post> bestList2 = null;
		List<RecentPost> listRpost = null;
		List<Post> listPost = null;
		
		// 모임 Best5
		String currentPage = null;
		MainPaging mg = new MainPaging(best_total, currentPage);
		post.setStart(mg.getStart());
		post.setEnd(mg.getEnd());
		post.setBt_num(bt_num1);
		bestList1 = ms.bestListPost(post);
		System.out.println("Che_Controller mainGetForm bestList1 listPost.size()->"+bestList1.size());
		//클래스 Best5
		post.setStart(mg.getStart());
		post.setEnd(mg.getEnd());
		post.setBt_num(bt_num2);
		bestList2 = ms.bestListPost(post);
		System.out.println("Che_Controller mainGetForm bestList2 listPost.size()->"+bestList2.size());
		
		String m_id = (String) request.getSession().getAttribute("sessionID");
		System.out.println("Che_Controller recentPostList m_id -> " + m_id);
		
		if(m_id != null) {
			rp_total = ms.cntRecentPost(m_id);
			System.out.println("Che_Controller recentPostList total -> " + rp_total);
			Paging pg = new Paging(rp_total, currentPage);
			
			rpost.setM_id(m_id);
			System.out.println("Che_Controller recentPostList m_id -> " + rpost.getM_id());
			rpost.setStart(pg.getStart());
			rpost.setEnd(pg.getEnd());
			listRpost = ms.recentPostList(rpost);
			
			System.out.println("Che_Controller recentPostList listRpost size -> " + listRpost.size());
			model.addAttribute("size", listRpost.size());
			model.addAttribute("listRpost", listRpost);
		}
		
		model.addAttribute("bt_num1", bt_num1);
		model.addAttribute("bt_num2", bt_num2);
		model.addAttribute("bestList1",bestList1);
		model.addAttribute("bestList2",bestList2);
		
		return "main/main";
	}
	
	// 검색
	@GetMapping(value = "/post/category/search")
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
	
	/*
	@GetMapping(value = "main/aside")
	public String recentPostList(HttpServletRequest request, RecentPost rpost, Post post, Model model, String currentPage) {
		System.out.println("********* Che_Controller recentPostList start *********");
		
		List<RecentPost> listRpost = null;
		
		
		String m_id = (String) request.getSession().getAttribute("sessionID");
		System.out.println("Che_Controller recentPostList m_id -> " + m_id);
		int rp_total = 0;
		rp_total = ms.cntRecentPost(m_id);
		System.out.println("Che_Controller recentPostList total -> " + rp_total);
		Paging pg = new Paging(rp_total, currentPage);
		
		rpost.setM_id(m_id);
		System.out.println("Che_Controller recentPostList m_id -> " + rpost.getM_id());
		rpost.setStart(pg.getStart());
		rpost.setEnd(pg.getEnd());
		listRpost = ms.recentPostList(rpost);
		System.out.println("Che_Controller recentPostList listRpost size -> " + listRpost.size());
		model.addAttribute("listRpost", listRpost);
		
		return "main/aside";
	}
	*/
}
