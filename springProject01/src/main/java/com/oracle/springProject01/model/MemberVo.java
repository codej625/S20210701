package com.oracle.springProject01.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVo {
	private String m_id;
	private String m_meetingauth;
	private String m_masterauth;

	private String[] m_idArray;
}
