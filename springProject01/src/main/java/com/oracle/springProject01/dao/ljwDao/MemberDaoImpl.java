package com.oracle.springProject01.dao.ljwDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.springProject01.model.AttachmentFile;
import com.oracle.springProject01.model.Member;
import com.oracle.springProject01.model.MemberVo;
import com.oracle.springProject01.model.Report;

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
		System.out.println("MemberDaoImpl check test2...");
		List<AttachmentFile> check = null;

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
	public MemberVo authorityList(MemberVo member) {
		System.out.println("MemberDaoImpl authorityList Start");
		MemberVo result = null;

		System.out.println("member m_id->" + member.getM_id());

		try {
			result = session.selectOne("ljwA_List", member);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl authorityList Exception->" + e.getMessage());
		}

		return result;
	}

	@Override
	public int authority(MemberVo memberVo) {
		System.out.println("MemberDaoImpl authority Start");
		int authority = 0;

		try {
			authority = session.update("ljw_authority", memberVo);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl authority Exception->" + e.getMessage());
		}

		return authority;
	}

	@Override
	public int report(Report report) {
		System.out.println("MemberDaoImpl authority Start");
		int result = 0;
		try {
			result = session.insert("ljw_report", report);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl report Exception->" + e.getMessage());
		}

		return result;
	}

	@Override
	public int report_total() {
		System.out.println("MemberDaoImpl report_total Start");
		int result = 0;
		try {
			result = session.selectOne("ljw_reportTotal");
		} catch (Exception e) {
			System.out.println("MemberDaoImpl report_total Exception->" + e.getMessage());
		}
		return result;
	}

	@Override
	public List<Report> report_list(Report report) {
		System.out.println("MemberDaoImpl report_list Start");
		List<Report> report_list = null;
		try {
			report_list = session.selectList("ljw_reportList", report);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl report_list Exception->" + e.getMessage());
		}
		return report_list;
	}

	@Override
	public int report_y(Report report) {
		System.out.println("MemberDaoImpl report_y Start");
		int report_y = 0;
		try {
			report_y = session.update("ljw_report_y", report);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl report_y Exception->" + e.getMessage());
		}
		return report_y;
	}

	@Override
	public Report report_select(Report report) {
		System.out.println("MemberDaoImpl report_select Start");
		try {
			report = session.selectOne("ljw_report_select", report);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl report_select Exception->" + e.getMessage());
		}
		return report;
	}

}
