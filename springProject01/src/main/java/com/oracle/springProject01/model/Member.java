package com.oracle.springProject01.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member {
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
	
	// 조회용
	private String search;   private String keyword;
	private String pageNum;  
	private int start; 		 private int end;
}
