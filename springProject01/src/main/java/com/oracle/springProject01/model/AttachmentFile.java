package com.oracle.springProject01.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AttachmentFile {
	private String m_id;
	private int f_num;
	private String f_orgname;
	private String f_newname;
	private String f_regdate;
	private String f_del;

	// tset용 나중에 삭제 예정
	private String test;
}
