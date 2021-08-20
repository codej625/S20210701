package com.oracle.springProject01.dao.ljwDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.springProject01.model.AttachmentFile;
import com.oracle.springProject01.model.Member;
import com.oracle.springProject01.model.MemberVo;

@Repository("LjwDao")
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession session;

	@Override
	public List<Member> memberList(Member member) {
		System.out.println("MemberDaoImpl Start memberList...");
		List<Member> memberList = null;
		try {
			memberList = session.selectList("ljwMemberList", member);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl listMember Exception->" + e.getMessage());
		}
		return memberList;
	}

	@Override
	public int total() {
		int tot = 0;
		System.out.println("MemberDaoImpl Start total...");
		try {
			// session -> Mapper ID total 호출
			tot = session.selectOne("ljwTotal");
			System.out.println("MemberDaoImpl Start total...");
		} catch (Exception e) {
			System.out.println("MemberDaoImpl total Exception->" + e.getMessage());
		}
		return tot;
	}

	@Override
	public List<AttachmentFile> check(AttachmentFile attachmentFile) {
		List<AttachmentFile> check = null;
		System.out.println("MemberDaoImpl check test2...");
		try {
			check = session.selectList("ljwCheck", attachmentFile);
		} catch (Exception e) {
			System.out.println("AttachmentFileDaoImpl check Exception->" + e.getMessage());
		}
		return check;
	}

	@Override
	public int user_delete(String m_id) {
		int delete = 0;
		System.out.println("MemberDaoImpl user_delete Start");
		try {
			delete = session.update("ljwDelete", m_id);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl user_delete Exception->" + e.getMessage());
		}
		return delete;
	}

	@Override
	public List<Member> auth_listMember(Member member) {
		System.out.println("MemberDaoImpl auth_listMember Start");
		List<Member> auth_listMember = null;
		try {
			auth_listMember = session.selectList("auth_listMember", member);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl auth_listMember Exception->" + e.getMessage());
		}
		return auth_listMember;
	}

	@Override
	public int a_total() {
		System.out.println("MemberDaoImpl a_total Start");
		int a_total = 0;
		try {
			a_total = session.selectOne("ljwA_TotalCnt");
		} catch (Exception e) {
			System.out.println("MemberDaoImpl a_total Exception->" + e.getMessage());
		}
		return a_total;
	}

	@Override
	public MemberVo authorityList(String m_id) {
		System.out.println("MemberDaoImpl authorityList Start");
		MemberVo authorityList = null;
		try {
			authorityList = session.selectOne("ljwA_List", m_id);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl authorityList Exception->" + e.getMessage());
		}
		return authorityList;
	}

	@Override
	public int authority(MemberVo member) {
		int authority = 0;
		System.out.println("MemberDaoImpl authority Start");
		try {
			authority = session.update("ljw_authority", member);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl authority Exception->" + e.getMessage());
		}
		return authority;
	}
}
