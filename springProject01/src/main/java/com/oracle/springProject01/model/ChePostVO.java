package com.oracle.springProject01.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChePostVO {
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
	private int p_cost;
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
	
//	조회용
	private String pageNum;
	private int start;
	private int end;

}