package com.oracle.springProject01.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AttachmentFile {
	private int f_num;
	private String f_orgname;
	private String f_newname;
	private String f_regdate;
	private String f_del;
	private List<MultipartFile> files;

//	Member
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
	private String m_img;
	private String m_meetingfile;
	private String m_masterfile;
	private String m_mail;
	private String m_certification;
}
