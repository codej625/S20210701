package com.oracle.springProject01.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PmjChatVO {
    	//member
    	private String m_id;
    	private String m_pw;
    	private String m_name;
    	private String m_tel;
    	private String m_area;
    	private String m_field;
    	private String m_regdate;
    	private int m_rate;
    	private String m_withdrawal;
    	private String m_meetingauth;
    	private String m_masterauth;
    	private int m_point;
	
	    //post
		private int bt_num;
		private int bc_num;
		private int p_num;
		private String p_title;
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
		
}
