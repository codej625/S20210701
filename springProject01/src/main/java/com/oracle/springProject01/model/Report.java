package com.oracle.springProject01.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Report {
	// Report
	private int r_num; // 신고 번호 PK
	private String m_id; // 아이디 FK
	private int r_count; // 누적 횟수
	private String r_content; // 신고 내용
	private String r_result; // 신고 결과

	// 조회용
	private String search;
	private String keyword;
	private String pageNum;
	private int start;
	private int end;
	
	private String[] r_numArray;
	private String[] m_idArray;
}
