package com.oracle.springProject01.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AttachmentFileVO {
	private String m_id;
	private int f_num;
	private String f_orgname;
	private String f_newname;
	private String f_regdate;
	private String f_del;
	private List<MultipartFile> files;

	// tset용 나중에 삭제 예정
	private String test;
}
