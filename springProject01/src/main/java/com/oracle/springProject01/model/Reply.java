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

//	게시물 작성한 맴버 조회용
	private String m_name;
	private String m_tel;
	
//	페이징 조회용
	private String search;
	private String keyword;
	private String pageNum;
	private int start;
	private int end;
}
