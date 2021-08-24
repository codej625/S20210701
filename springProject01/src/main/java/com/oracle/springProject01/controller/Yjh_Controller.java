package com.oracle.springProject01.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.springProject01.model.Lhj_MemberVO;
import com.oracle.springProject01.model.Member;
import com.oracle.springProject01.model.Post;
import com.oracle.springProject01.model.RecentPost;
import com.oracle.springProject01.model.Reply;
import com.oracle.springProject01.service.cheService.MainService;
import com.oracle.springProject01.service.lhjService.MemberService;
import com.oracle.springProject01.service.paging.Paging;
import com.oracle.springProject01.service.yjhService.BoardCategoryService;
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

   @Autowired
   private MainService mas;
   
   @Autowired
   private com.oracle.springProject01.service.yjhService.MemberService ys;
   
//   게시물 리스트 불러오기
   @RequestMapping(value = "/post/category", method = { RequestMethod.GET, RequestMethod.POST })
   public String categoryGet(HttpServletRequest request,Integer bt_num, Integer bc_num, String keyword, String currentPage, Model model, Member lhj_MemberVO) {
      System.out.println("Yjh_Controller categoryGet Start...");
      String sessionID =  (String) request.getSession().getAttribute("sessionID");
      lhj_MemberVO.setM_id(sessionID);
      lhj_MemberVO = ys.id(lhj_MemberVO);
      int total = 0;
//      유형번호만 눌렀을때 카테고리값을 0으로
      if (bc_num == null)
         bc_num = 0;
//      게시물 갯수를 가져오기
      total = ps.total(bt_num, bc_num,keyword);
      System.out.println("Yjh_Controller categoryGet total->" + total);
//      페이징 처리
      Paging pg = new Paging(total, currentPage);
      Post post = new Post();
      post.setBt_num(bt_num);
      post.setBc_num(bc_num);
      post.setKeyword(keyword);
      post.setStart(pg.getStart());
      post.setEnd(pg.getEnd());
//      게시물 리스트
      List<Post> listPost = ps.listPost(post);
//      for(Post post1 : listPost ) {
//         System.out.println("Yjh_Controller categoryGet post1.getP_title()->"+post1.getP_title());
//         System.out.println("Yjh_Controller categoryGet post1.getP_title()->"+post1.getP_img());
//      }
      System.out.println("Yjh_Controller String list() listPost.size()->" + listPost.size());
      model.addAttribute("sessionID",sessionID);
      model.addAttribute("lhj_MemberVO", lhj_MemberVO);
      model.addAttribute("total", total);
      model.addAttribute("listPost", listPost);
      model.addAttribute("pg", pg);
      model.addAttribute("bt_num", bt_num);
      model.addAttribute("bc_num", bc_num);
      return "post/category";
   }

//	모임/클래스 개설하기 버튼
	@RequestMapping(value = "/post/add")
	public String add(HttpServletRequest request, Model model, Lhj_MemberVO lhj_MemberVO) {
		System.out.println("Yjh_Controller void add() start...");
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
		
		lhj_MemberVO = ms.selectMypage(sessionID);
		System.out.println("lhj_MemberVO.getM_meetingauth()->" + lhj_MemberVO.getM_meetingauth());
		model.addAttribute(lhj_MemberVO);
		model.addAttribute("sessionID",sessionID);
		return "post/add";
	}

//   게시물 작성  폼
   @GetMapping(value = "/post/register")
   public String register(HttpServletRequest request, int bt_num, Model model, Member lhj_MemberVO) {
      System.out.println("Yjh_Controller String register Start...");
//      섹션아이디
      String sessionID = (String) request.getSession().getAttribute("sessionID");
//      섹션아이디의 정보가져오기
      Post post = ps.registerMember(sessionID);
      lhj_MemberVO.setM_id(sessionID);
      lhj_MemberVO = ys.id(lhj_MemberVO);
//      게시물번호
      int p_num = 0;
//      페이지넘
      String pageNum = request.getParameter("pageNum");
      if (pageNum == null)
         pageNum = "1";
      model.addAttribute("p_num", p_num);
      model.addAttribute("pageNum", pageNum);
      model.addAttribute("sessionID", sessionID);
      model.addAttribute("post", post);
      model.addAttribute("bt_num", bt_num);
      model.addAttribute("lhj_MemberVO", lhj_MemberVO);
      System.out.println("bt_num->" + bt_num);
      return "post/register";
   }

//   게시물 작성
   @PostMapping(value = "/post/insert")
//   public String postInsert(Post post, Model model)  {
   public String postInsert(HttpServletRequest request, MultipartFile p_img, Model model) throws IOException {
      System.out.println("Yjh_Controller String postInsert start...");
//      태그를 배열로 받아서 저장해주기
      String[] p_tag = request.getParameterValues("p_tag");
//      태그 받은걸  (a b)a 띄어쓰기 b 이런식으로  변경해서 p_tagStr로  다시 받아주기
      String p_tagStr = "";
      for (int i = 0; i < p_tag.length; i++) {
         System.out.println("p_tag name->" + p_tag[i]);
         p_tagStr = p_tagStr + p_tag[i] + " ";
      }
      System.out.println("Yjh_Controller p_tagStr->" + p_tagStr);
      Post post = new Post();
      post.setBt_num(Integer.parseInt(request.getParameter("bt_num")));
      post.setBc_num(Integer.parseInt(request.getParameter("bc_num")));
      post.setP_num(Integer.parseInt(request.getParameter("p_num")));
      post.setP_title(request.getParameter("p_title"));
      post.setM_id(request.getParameter("m_id"));
      post.setP_intro(request.getParameter("p_intro"));
      post.setP_info(request.getParameter("p_info"));
      post.setP_gname(request.getParameter("p_gname"));
      post.setP_capa(Integer.parseInt(request.getParameter("p_capa")));
      post.setP_cstatus(request.getParameter("p_cstatus"));
      post.setP_metstart(request.getParameter("p_metstart"));
      post.setP_metend(request.getParameter("p_metend"));
      post.setP_appstart(request.getParameter("p_appstart"));
      post.setP_append(request.getParameter("p_append"));
      post.setP_loc(request.getParameter("p_loc"));
      post.setP_cost(request.getParameter("p_cost"));
      post.setP_starttime(request.getParameter("p_starttime"));
      post.setP_endtime(request.getParameter("p_endtime"));
      post.setP_tag(p_tagStr);
      post.setP_bankname(request.getParameter("p_bankname"));
      post.setP_accountnumber(request.getParameter("p_accountnumber"));
      System.out.println("post.getP_cstatus->" + post.getP_cstatus());
      System.out.println("post.p_cost: " + post.getP_cost());
      System.out.println("post.P_starttime: " + post.getP_starttime());
//      uploadPath = 파일경로지정
      String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
      System.out.println("originalName : " + p_img.getOriginalFilename());
      System.out.println("size : " + p_img.getSize());
      System.out.println("contentType : " + p_img.getContentType());
      System.out.println("uploadPath : " + uploadPath);
      String savedName = uploadFile(p_img.getOriginalFilename(), p_img.getBytes(), uploadPath);
//      파일이름  post에 저장
      post.setP_img(savedName);
      System.out.println("saveName : " + savedName);
      System.out.println("Yjh_Controller post.getP_img->" + post.getP_img());
      System.out.println("Yjh_Controller post.getP_title()->" + post.getP_title());
//      게시물 저장
      int result = ps.postInsert(post);
      System.out.println("Yjh_Controller postInsert result->" + result);
      if (result > 0) {
         return "forward:/post/category";
      } else {
         model.addAttribute("msg", "바보");
         return "forward:/add";
      }
   }

//   파일업로드
   private String uploadFile(String originalName, byte[] fileData, String uploadPath) throws IOException {
      System.out.println("UploadController String uploadFile start...");
//      UUID = 범용 고유 식별자는 소프트웨어 구축에 쓰이는 식별자 표준으로, 개방 소프트웨어 재단이 분산 컴퓨팅 환경의 일부로 표준화하였다
      UUID uid = UUID.randomUUID();
//      requestPath = requestPath + "/resources/image";
      System.out.println("uploadPath->" + uploadPath);
//      Directory 생성
      File fileDirectory = new File(uploadPath);
//      fileDirectory 가 없으면 만들어준다
      if (!fileDirectory.exists()) {
//         mkdirs = make directory의 약자
         fileDirectory.mkdirs();
         System.out.println("업로드용 폴더 생성 : " + uploadPath);
      }
      String savedName = uid.toString() + "_" + originalName;

      // savedName을 DB 에다가 원하는 Table에 원하는 항목에 저장
      File target = new File(uploadPath, savedName);
      FileCopyUtils.copy(fileData, target); // org.springframework.util.FileCopyUtils

      return savedName;
   }

//	게시물 보기
	@RequestMapping(value = "/post/postListDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String postListDetail(Integer bt_num, Integer bc_num, Integer p_num, String pm_id, RecentPost rpost, Model model, HttpServletRequest request, Member lhj_MemberVO) {
		System.out.println("Yjh_Controller String postListDetail start...");

//		섹션아이디
		String sessionID =  (String) request.getSession().getAttribute("sessionID");
	    lhj_MemberVO.setM_id(sessionID);
	    lhj_MemberVO = ys.id(lhj_MemberVO);

		String m_id = sessionID;
//		게시물을 신청 했는지 안했는지 확인
		int result1 = ps.regInfoCheck(m_id,bt_num, bc_num, p_num);
		System.out.println("postListDetail regInfoCheck result1->"+result1);
//		게시물을 찜 했는지 안했는지 확인
		int result2 = ps.bookmarkCheck(m_id,bt_num, bc_num, p_num);
		System.out.println("postListDetail regInfoCheck result1->"+result1);
//		조회수 증가해주기
		int result = ps.postHit(bt_num, bc_num, p_num);
//		게시물 상세정보
		Post post = ps.postListDetail(bt_num, bc_num, p_num);
		System.out.println("Yjh_Controller postListDetail post->" + post);
//		댓글 리스트
		List<Reply> replyList = rs.postReplyList(bt_num, bc_num, p_num);
		System.out.println("Controller postReplyList done");
//		Reply reply = rs.postReplyList(bt_num, bc_num, p_num);
		int r_num = 0, r_rate = 0, r_indent = 0, r_group = 0, r_level = 0;
		
		// 최근 본 게시물(로그인 시에만 구현)
		System.out.println("m_id -> " + m_id);
		if(m_id != null) {
			rpost.setBt_num(post.getBt_num());
			System.out.println("rpost.setBt_num" + rpost.getBt_num());
			rpost.setBc_num(post.getBc_num());
			System.out.println("rpost.setBt_num" + rpost.getBc_num());
			rpost.setP_num(post.getP_num());
			System.out.println("rpost.setBt_num" + rpost.getP_num());
			rpost.setM_id(m_id);
			rpost.setP_title(post.getP_title());
			mas.insertRecentPost(rpost);
		}
		
		model.addAttribute("post", post);
		model.addAttribute("sessionID",sessionID);
		model.addAttribute("r_num",r_num);
		model.addAttribute("r_rate",r_rate);
		model.addAttribute("r_indent",r_indent);
		model.addAttribute("r_group",r_group);
		model.addAttribute("r_level",r_level);
		model.addAttribute("result",result1);
		model.addAttribute("result2",result2);	
		model.addAttribute("reply",replyList);
		model.addAttribute("lhj_MemberVO", lhj_MemberVO);
		return "post/contents";
	}

//   선택한 게시물 내용 수정 뷰단
   @RequestMapping(value = "/post/postListUpdateView", method = { RequestMethod.GET, RequestMethod.POST })
   public String postListUpdateView(Integer bt_num, Integer bc_num, Integer p_num, Model model) {
      System.out.println("Yjh_Controller String postListUpdateView strat...");
      System.out.println("Yjh_Controller postListUpdateView bt_num->" + bt_num);
      System.out.println("Yjh_Controller postListUpdateView bc_num->" + bc_num);
      System.out.println("Yjh_Controller postListUpdateView p_num->" + p_num);
      Post post = ps.postListDetail(bt_num, bc_num, p_num);
      model.addAttribute("post", post);
      return "post/updateContents";
   }

//   게시물 수정하기
   @RequestMapping(value = "/post/postListUpdate", method = { RequestMethod.GET, RequestMethod.POST })
   public String postListUpdate(HttpServletRequest request, MultipartFile p_img, Model model, Member lhj_MemberVO) throws IOException {
      System.out.println("Yjh_Controller String postListUpdate start...");
      String sessionID = (String) request.getSession().getAttribute("sessionID");
      lhj_MemberVO.setM_id(sessionID);
      lhj_MemberVO = ys.id(lhj_MemberVO);
//    태그를 배열로 받아서 저장해주기
      String[] p_tag = request.getParameterValues("p_tag");
//    태그 받은걸  (a b)a 띄어쓰기 b 이런식으로  변경해서 p_tagStr로  다시 받아주기
      String p_tagStr = "";
      for (int i = 0; i < p_tag.length; i++) {
    	  System.out.println("p_tag name->" + p_tag[i]);
    	  p_tagStr = p_tagStr + p_tag[i] + " ";
      }
      System.out.println("Yjh_Controller p_tagStr->" + p_tagStr);
      Post post = new Post();
      post.setBt_num(Integer.parseInt(request.getParameter("bt_num")));
      post.setBc_num(Integer.parseInt(request.getParameter("bc_num")));
      post.setP_num(Integer.parseInt(request.getParameter("p_num")));
      post.setP_title(request.getParameter("p_title"));
      post.setM_id(request.getParameter("m_id"));
      post.setP_intro(request.getParameter("p_intro"));
      post.setP_info(request.getParameter("p_info"));
      System.out.println("p_info");
      System.out.println(request.getParameter("p_info"));
      post.setP_gname(request.getParameter("p_gname"));
      post.setP_capa(Integer.parseInt(request.getParameter("p_capa")));
      post.setP_cstatus(request.getParameter("p_cstatus"));
      post.setP_metstart(request.getParameter("p_metstart"));
      post.setP_metend(request.getParameter("p_metend"));
      post.setP_appstart(request.getParameter("p_appstart"));
      post.setP_append(request.getParameter("p_append"));
      post.setP_loc(request.getParameter("p_loc"));
      post.setP_cost(request.getParameter("p_cost"));
      post.setP_starttime(request.getParameter("p_starttime"));
      post.setP_endtime(request.getParameter("p_endtime"));
      post.setP_tag(p_tagStr);
      post.setP_bankname(request.getParameter("p_bankname"));
      post.setP_accountnumber(request.getParameter("p_accountnumber"));
      System.out.println("post.getP_cstatus->" + post.getP_cstatus());
      System.out.println("post.p_cost: " + post.getP_cost());
      System.out.println("post.P_starttime: " + post.getP_starttime());
//    파일이미지 업로드 변경을 했을떄 수행
      if(p_img.getSize()>0){
//        uploadPath = 파일경로지정
          String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
          System.out.println("originalName : " + p_img.getOriginalFilename());
          System.out.println("size : " + p_img.getSize());
          System.out.println("contentType : " + p_img.getContentType());
          System.out.println("uploadPath : " + uploadPath);
          String savedName = uploadFile(p_img.getOriginalFilename(), p_img.getBytes(), uploadPath);
//          파일이름  post에 저장
          post.setP_img(savedName);
          System.out.println("saveName : " + savedName);    	  
      }else {
//    	    파일 업로드 안했을떄 기본 이미지 이름 가져오기
    	  post.setP_img(request.getParameter("old_p_img"));
      }
      System.out.println("Yjh_Controller post.getP_img->" + post.getP_img());
      System.out.println("Yjh_Controller post.getP_title()->" + post.getP_title());
      int result = ps.postListUpdate(post);
      System.out.println("Yjh_Controller String postListUpdate result->" + result);
      model.addAttribute("post", post);
      model.addAttribute("lhj_MemberVO", lhj_MemberVO);
      return "forward:/post/postListDetail";
   }

//   게시물 삭제하기
   @RequestMapping(value = "/post/postDelete", method = { RequestMethod.GET, RequestMethod.POST })
   public String postDelete(Integer bt_num, Integer bc_num, Integer p_num, String m_id) {
      System.out.println("Yjh_Controller String postDelete start...");
      System.out.println("Yjh_Controller postDelete bt_num->" + bt_num);
      System.out.println("Yjh_Controller postDelete bc_num->" + bc_num);
      System.out.println("Yjh_Controller postDelete p_num->" + p_num);
      System.out.println("Yjh_Controller postDelete m_id->" + m_id);
      int result = ps.postDelete(bt_num, bc_num, p_num);
      System.out.println("Yjh_Controller String postDelete result->" + result);
      return "redirect:/main/main";
   }

//   댓글 작성
   @RequestMapping(value = "/reply/replyInsert", method = { RequestMethod.GET, RequestMethod.POST })
   public String replyInsert(Reply reply, Model model) {
      System.out.println("Yjh_Controller String replyInsert start...");
      System.out.println("Yjh_Controller replyInsert reply.getBt_num()->" + reply.getBt_num());
      System.out.println("Yjh_Controller replyInsert reply.getBc_num()->" + reply.getBc_num());
      System.out.println("Yjh_Controller replyInsert reply.getP_num()->" + reply.getP_num());
      System.out.println("Yjh_Controller replyInsert reply.getR_num()->" + reply.getR_num());
      System.out.println("Yjh_Controller replyInsert reply.getgetPm_id()->" + reply.getPm_id());
      int result = rs.replyInsert(reply);
      System.out.println("Yjh_Controller postInsert result->" + result);
      if (result > 0) {
//         model.addAttribute("reply",reply);
         return "forward:/post/postListDetail";
      } else {
         model.addAttribute("msg", "바보");
         return "forward:add";
      }
   }

//   댓글 삭제
   @RequestMapping(value = "/reply/replyDelete", method = { RequestMethod.GET, RequestMethod.POST })
   public String replyDelete(Integer bt_num, Integer bc_num, Integer p_num, Integer r_num,
         HttpServletRequest request) {
      System.out.println("Yjh_Controller replyDelete strat...");
      System.out.println("Yjh_Controller replyDelete bt_num->" + bt_num);
      System.out.println("Yjh_Controller replyDelete bc_num->" + bc_num);
      System.out.println("Yjh_Controller replyDelete p_num->" + p_num);
      System.out.println("Yjh_Controller replyDelete r_num->" + r_num);
      int result = rs.replyDelete(bt_num, bc_num, p_num, r_num);
      return "forward:/post/postListDetail";
   }

//   대댓글 등록
   @RequestMapping(value = "/reply/replyReplyInsert", method = { RequestMethod.GET, RequestMethod.POST })
   public String replyReplyInsert(Reply reply, HttpServletRequest request) {
      System.out.println("Yjh_Controller replyReplyInsert start...");
      System.out.println("Yjh_Controller replyDelete reply.getR_level->" + reply.getR_level());
      System.out.println("Yjh_Controller replyDelete getR_indent()->" + reply.getR_indent());
      System.out.println("Yjh_Controller replyDelete getR_group()->" + reply.getR_group());
      int result = rs.replyReplyInsert(reply);
      return "forward:/post/postListDetail";
   }

//   게시물 신청하기 보여주는 곳
   @RequestMapping(value = "post/postRegInfoApplication", method = { RequestMethod.GET, RequestMethod.POST })
   public String postRegInfoApplication(Integer bt_num, Integer bc_num, Integer p_num, Model model, Member lhj_MemberVO,
         HttpServletRequest request) {
      System.out.println("Yjh_Controller postRegInfoApplication start...");
//      섹션아이디
      String sessionID = (String) request.getSession().getAttribute("sessionID");
      lhj_MemberVO.setM_id(sessionID);
      lhj_MemberVO = ys.id(lhj_MemberVO);
//      게시물 리스트
      Post post = ps.postListDetail(bt_num, bc_num, p_num);
//      로그인 아이디 정보
      Post postMemberDetail = ps.registerMember(sessionID);
      model.addAttribute("post", post);
      model.addAttribute("member", postMemberDetail);
      model.addAttribute("lhj_MemberVO", lhj_MemberVO);
      return "post/applicationContents";
   }

//   게시물 신청하기
   @RequestMapping(value = "post/postRegInfoInsert", method = { RequestMethod.GET, RequestMethod.POST })
   public String postRegInfoInsert(Integer bt_num, Integer bc_num, Integer p_num, String p_cstatus, Model model,
         HttpServletRequest request) {
      System.out.println("Yjh_Controller postRegInfoInsert start...");
//      섹션아이디
      String sessionID = (String) request.getSession().getAttribute("sessionID");
      String m_id = sessionID;
//      게시물 신청하기
      System.out.println("Yjh_Controller postRegInfoInsert p_cstatus->" + p_cstatus);
      int post = ps.postRegInfoInsert(m_id, bt_num, bc_num, p_num, p_cstatus);
      System.out.println("Yjh_Controller postRegInfoInsert result->" + post);
      if (post > 0) {
//         게시물 신청하면 p_capa값 마이너스 해주기
         int postUpdate = ps.postCapaMinusUpdate(bt_num, bc_num, p_num);
         System.out.println("Yjh_Controller postCapaMinusUpdate result->" + postUpdate);
         return "forward:/post/postListDetail";
      }
      return "forward:/post/applicationContents";
   }

//   게시물 취소하기
   @RequestMapping(value = "post/postRegInfoDelete", method = { RequestMethod.GET, RequestMethod.POST })
   public String postRegInfoDelete(Integer bt_num, Integer bc_num, Integer p_num, Model model,
         HttpServletRequest request) {
      System.out.println("Yjh_Controller postRegInfoDelete start...");
//      섹션아이디
      String sessionID = (String) request.getSession().getAttribute("sessionID");
      String m_id = sessionID;
//      게시물 신청 취소하기
      int post = ps.postRegInfoDelete(m_id, bt_num, bc_num, p_num);
      System.out.println("Yjh_Controller postRegInfoInsert result->" + post);
      if (post > 0) {
//         게시물 취소하면 p_capa값 플러스 해주기
         int postUpdate = ps.postCapaPlusUpdate(bt_num, bc_num, p_num);
         System.out.println("Yjh_Controller postCapaPlusUpdate result->" + postUpdate);
         return "forward:/post/postListDetail";
      }
      return "forward:/post/applicationContents";
   }

//   게시물 찜하기
   @RequestMapping(value = "post/postBookmarkInsert", method = { RequestMethod.GET, RequestMethod.POST })
   public String postBookmarkInsert(Integer bt_num, Integer bc_num, Integer p_num, Model model,
         HttpServletRequest request) {
      System.out.println("Yjh_Controller postBookmarkInsert start...");
//      섹션아이디
      String sessionID = (String) request.getSession().getAttribute("sessionID");
      String m_id = sessionID;
//      게시물 찜하기
      int post = ps.postBookmarkInsert(m_id, bt_num, bc_num, p_num);
      System.out.println("Yjh_Controller postBookmarkInsert result->" + post);
      return "forward:/post/postListDetail";
   }

//   게시물 찜 취소하기
   @RequestMapping(value = "post/postBookmarkDelete", method = { RequestMethod.GET, RequestMethod.POST })
   public String postBookmarkDelete(Integer bt_num, Integer bc_num, Integer p_num, Model model,
         HttpServletRequest request) {
      System.out.println("Yjh_Controller postBookmarkDelete start...");
//      섹션아이디
      String sessionID = (String) request.getSession().getAttribute("sessionID");
      String m_id = sessionID;
//      게시물 찜 취소하기
      int post = ps.postBookmarkDelete(m_id, bt_num, bc_num, p_num);
      System.out.println("Yjh_Controller postBookmarkDelete result->" + post);
      return "forward:/post/postListDetail";
   }

//   결제확인 ajax
   @RequestMapping(value = "post/payments/complete", method = { RequestMethod.GET, RequestMethod.POST })
   @ResponseBody
   public String paymentsComplete(String imp_uid) {
      System.out.println(imp_uid);
//      Post post = ps.postBookmarkDelete(m_id,bt_num, bc_num, p_num);
      return "ok!!!";
   }
   
//	// 결제확인 ajax
//	 @RequestMapping(value = "post/payments/complete", method = { RequestMethod.GET, RequestMethod.POST })
//	 @ResponseBody
//	 public List<Post> paymentsCompletes(Reply reply) {
//	    System.out.println(imp_uid);
//	    
//	    List<Post> listPost = ps.listPost(post);
//	//    Post post = ps.postBookmarkDelete(m_id,bt_num, bc_num, p_num);
//	    return listPost;
//	 }
   

}