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
import com.oracle.springProject01.model.Reply;
import com.oracle.springProject01.service.paging.Paging;
import com.oracle.springProject01.service.yjhService.BoardCategoryService;
import com.oracle.springProject01.service.yjhService.MemberService;
import com.oracle.springProject01.service.yjhService.PostService;
import com.oracle.springProject01.service.yjhService.ReplyService;

@Controller
public class Yjh_Controller {

	@Autowired
	private PostService ps;

	@Autowired
	private BoardCategoryService bcs;

	@Autowired
	private MemberService ms;
	
	@Autowired
	private ReplyService rs;

	@GetMapping(value = "/main/main")
	public String maingogo() {
		return "main/main";
	}

//	겟방식 게시물 리스트 불러오기
	@RequestMapping(value = "/post/category", method = { RequestMethod.GET, RequestMethod.POST })
	public String categoryGet(Integer bt_num, Integer bc_num, Post post, String currentPage, Model model) {
		System.out.println("Yjh_Controller categoryGet Start...");
		int total = 0;
//		유형번호만 눌렀을때 카테고리값을 0으로
		if (bc_num == null)
			bc_num = 0;
//		게시물 갯수를 가져오기
		total = ps.total(bt_num, bc_num);
		System.out.println("Yjh_Controller categoryGet total->" + total);
//		페이징 처리
		Paging pg = new Paging(total, currentPage);
		post.setStart(pg.getStart());
		post.setEnd(pg.getEnd());
//		게시물 리스트
		List<Post> listPost = ps.listPost(post);
		for(Post post1 : listPost ) {
			System.out.println("Yjh_Controller categoryGet post1.getP_title()->"+post1.getP_title());
		}
		System.out.println("Yjh_Controller String list() listPost.size()->" + listPost.size());
		model.addAttribute("total", total);
		model.addAttribute("listPost", listPost);
		model.addAttribute("pg", pg);
		model.addAttribute("bt_num", bt_num);
		model.addAttribute("bc_num", bc_num);
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
	public String register(HttpServletRequest request, int bt_num, Model model) {
		System.out.println("Yjh_Controller String register Start...");
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
		int result = ps.postInsert(post);
		System.out.println("Yjh_Controller postInsert result->" + result);
		if (result > 0) {
			return "forward:/post/category";
		} else {
			model.addAttribute("msg", "바보");
			return "forward:add";
		}
	}

//	게시물 보기
	@RequestMapping(value = "/post/postListDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String postListDetail(Integer bt_num, Integer bc_num, Integer p_num, Model model) {
		System.out.println("Yjh_Controller String postListDetail start...");
//		게시물 리스트
		Post post = ps.postListDetail(bt_num, bc_num, p_num);
		System.out.println("Yjh_Controller postListDetail post->" + post);
//		댓글 리스트
		List<Reply> replyList = rs.postReplyList(bt_num, bc_num, p_num);
		System.out.println("Controller postReplyList done");
//		Reply reply = rs.postReplyList(bt_num, bc_num, p_num);
		int r_num = 0, r_rate = 0, r_indent = 0, r_group = 0;
		model.addAttribute("r_num",r_num);
		model.addAttribute("r_rate",r_rate);
		model.addAttribute("r_indent",r_indent);
		model.addAttribute("r_group",r_group);
		model.addAttribute("post", post);	
		model.addAttribute("reply",replyList);
		return "post/contents";
	}
	
//	선택한 게시물 내용 수정 뷰단
	@RequestMapping(value = "/post/postListUpdateView", method = { RequestMethod.GET, RequestMethod.POST })
	public String postListUpdateView(Integer bt_num, Integer bc_num, Integer p_num, Model model) {
		System.out.println("Yjh_Controller String postListUpdateView strat...");
		System.out.println("Yjh_Controller postListUpdateView bt_num->"+bt_num);
		System.out.println("Yjh_Controller postListUpdateView bc_num->"+bc_num);
		System.out.println("Yjh_Controller postListUpdateView p_num->"+p_num);
		Post post = ps.postListDetail(bt_num, bc_num, p_num);
		model.addAttribute("post",post);
		return "post/updateContents";
	}
	
//	게시물 수정하기
	@RequestMapping(value = "/post/postListUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public String postListUpdate(Post post, Model model) {
		System.out.println("Yjh_Controller String postListUpdate start...");
		System.out.println("Yjh_Controller String postListUpdate post.getP_cost()->"+post.getP_cost());
		System.out.println("Yjh_Controller String postListUpdate post.getBt_num()->"+post.getBt_num());
		System.out.println("Yjh_Controller String postListUpdate post.getBc_num()->"+post.getBc_num());
		System.out.println("Yjh_Controller String postListUpdate post.getP_num()->"+post.getP_num());
		int result = ps.postListUpdate(post);
		System.out.println("Yjh_Controller String postListUpdate result->"+result);
		model.addAttribute("post",post);
		return "forward:/post/postListDetail";
	}
	
//	게시물 삭제하기
	@RequestMapping(value = "/post/postDelete", method = { RequestMethod.GET, RequestMethod.POST })
	public String postDelete(Integer bt_num, Integer bc_num, Integer p_num) {
		System.out.println("Yjh_Controller String postDelete start...");
		System.out.println("Yjh_Controller postDelete bt_num->"+bt_num);
		System.out.println("Yjh_Controller postDelete bc_num->"+bc_num);
		System.out.println("Yjh_Controller postDelete p_num->"+p_num);
		int result = ps.postDelete(bt_num, bc_num, p_num);
		System.out.println("Yjh_Controller String postDelete result->"+result);
		return "redirect:/main/main";
	}
	
//	댓글 작성
	@RequestMapping(value = "/reply/replyInsert", method = { RequestMethod.GET, RequestMethod.POST })
	public String replyInsert(Reply reply, Model model) {
		System.out.println("Yjh_Controller String replyInsert start...");
		int result = rs.replyInsert(reply);
		System.out.println("Yjh_Controller postInsert result->" + result);
		if (result > 0) {
//			model.addAttribute("reply",reply);
			return "forward:/post/postListDetail";
		} else {
			model.addAttribute("msg", "바보");
			return "forward:add";
		}
	}

}
