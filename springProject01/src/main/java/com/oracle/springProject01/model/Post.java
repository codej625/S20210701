package com.oracle.springProject01.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Post {
	private int bt_num;
	private int bc_num;
	private int p_num;
	private String p_title;
	private String m_id;
	private String p_intro;
	private String p_img;
	private String p_info;
	private String p_attach;
	private String p_gname;
	private int p_capa;
	private String p_cost;
	private String P_appstart;
	private String P_append;
	private String p_choice;
	private String p_overcapa;
	private String p_loc;
	private String P_tag;
	private String p_metstart;
	private String p_metend;
	private String p_starttime;
	private String p_endtime;
	private String p_writedate;
	private int p_hit;
	private String p_cstatus;
	private String p_bankname;
	private String p_accountnumber;
	
//	게시물 작성한 맴버 조회용
	private String m_name;
	private String m_tel;
	private String m_img;
	
//	신청내역 조회용
	private String ri_pstatus;
	
//	북마크 조회용
	private String b_time;
	private String b_reg;
	
//	페이징 조회용
	private String search;
	private String keyword;
	private String pageNum;
	private int start;
	private int end;

}
