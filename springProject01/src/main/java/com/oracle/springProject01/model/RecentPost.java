package com.oracle.springProject01.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecentPost {
	private int bt_num;
	private int bc_num;
	private int p_num;
	private String m_id;
	private int rp_cnt;
	private String rp_date;
	private String p_title;
	private String p_img;
	
	private int start;
	private int end;
}
