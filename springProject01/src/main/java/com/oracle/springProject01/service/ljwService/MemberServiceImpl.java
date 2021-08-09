package com.oracle.springProject01.service.ljwService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.springProject01.dao.ljwDao.MemberDao;
import com.oracle.springProject01.model.AttachmentFile;
import com.oracle.springProject01.model.AttachmentFileVO;
import com.oracle.springProject01.model.Member;

@Service("LjwService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao md;

	@Override
	public List<Member> listMember(Member member) {
		List<Member> memberList = null;
		System.out.println("MemberServiceImpl Start listMember...");
		memberList = md.listMember(member);
		System.out.println("MemberServiceImpl listMember.size()->" + memberList);
		return memberList;
	}

	@Override
	public int total() {
		System.out.println("MemberServiceImpl Start total...");
		int totCnt = md.total();
		System.out.println("MemberServiceImpl total totCnt->" + totCnt);
		return totCnt;
	}

	@Override
	public int masterauth(String m_id) {
		System.out.println("MemberServiceImpl Start total...");
		int update = md.masterauth(m_id);
		System.out.println("MemberServiceImpl masterauth update->" + update);
		return update;
	}

	@Override
	public List<AttachmentFileVO> test(AttachmentFileVO attachmentFileVO) {
		System.out.println("MemberServiceImpl Start test...");
		List<AttachmentFileVO> list = null;

//======날짜를 입력하기 위한 SimpleDateFormat, Calendar 객체 생성==========================
		SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar time = Calendar.getInstance();
		String date = Format.format(time.getTime());

//======List에서 꺼낸 files, m_id, f_orgname f_newname, f_regdate를  DTO 단위로 옮길 계획==		
		AttachmentFileVO attachmentFileTest = new AttachmentFileVO();

//======for문으로 VO의 List로 저장되어있는 field를 을 하나씩 꺼내서 저장=========================
		for (int i = 0; i <= attachmentFileVO.getFiles().size(); i++) {

//==========for문을 돌려서 VO속에 List를 순서대로 가져와 String으로 변환후 name이라는 변수에 저장=====	
			String name = attachmentFileVO.getFiles().get(i).toString();
			attachmentFileVO.setF_orgname(name);

//==========로컬에 저장된 이름과 DB에 저장된 이름이 같지 않게 하기위해  random숫자를 붙임==============
			attachmentFileVO.setF_newname(name + Math.random() + 1);
			attachmentFileVO.setM_id(attachmentFileVO.getM_id().toString());
			attachmentFileVO.setF_regdate(date);

//==========원래 attachmentFileVO 통채로 DAO로 보내서 처리하려다 실패 하였음===================	
//			System.out.println(attachmentFileVO.getF_orgname());
//			System.out.println(attachmentFileVO.getF_newname());
//			System.out.println(attachmentFileVO.getM_id());
//			System.out.println(attachmentFileVO.getF_regdate());
//			DB에 값을 저장하기 위해 DTO단위로 DAO에 보냄
//			list = md.test(attachmentFileVO.toString());

//==========위에서 만들어 놓은 AttachmentFileVO에 DTO 단위로 옮기기 위해 Set==================
			attachmentFileTest.setF_orgname(attachmentFileVO.getF_orgname());
			attachmentFileTest.setF_newname(attachmentFileVO.getF_newname());
			attachmentFileTest.setM_id(attachmentFileVO.getM_id());
			attachmentFileTest.setF_regdate(attachmentFileVO.getF_regdate());
			md.test2(attachmentFileTest);

//================================================================================	
		}
		return list;
	}

	@Override
	public List<AttachmentFile> check(AttachmentFile attachmentFile) {
		System.out.println("AttachmentFileServiceImpl Start check...");
		List<AttachmentFile> check = null;
		check = md.check(attachmentFile);
		return check;
	}

}