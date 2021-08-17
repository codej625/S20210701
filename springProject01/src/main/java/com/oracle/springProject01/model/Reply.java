package com.oracle.springProject01.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Reply {
	private int bt_num;
	private int bc_num;
	private int p_num;
	private int r_num;
	private String m_id;
	private int r_rate;
	private int r_indent;
	private int r_group;
	private String r_info;
	private Date r_writedate;
	private String r_openclose;
	private int r_level;

//	게시물 작성한 맴버 조회용
	private String m_name;
	private String m_tel;
	private String m_img;
	
//	댓글평점 아이디 저장용
	private String pm_id;
	
//	닉네임 테이블 저장용
	private int nt_num;
	
//	페이징 조회용
	private String search;
	private String keyword;
	private String pageNum;
	private int start;
	private int end;
}
