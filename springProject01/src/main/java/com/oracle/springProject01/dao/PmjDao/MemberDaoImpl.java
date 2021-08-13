package com.oracle.springProject01.dao.PmjDao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.springProject01.model.Lhj_MemberVO;
import com.oracle.springProject01.model.PmjChatVO;
@Repository("PmjDao")
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private	SqlSession	session;

	@Override
	public PmjChatVO selectchat(String m_name) {
		System.out.println("dao pmjmember memberDaoImpl selectchat Start");
		PmjChatVO pmjChatVO = new PmjChatVO();
		pmjChatVO.setM_name(m_name);
		try {
			pmjChatVO= session.selectOne("mj_selectChat",m_name);
			System.out.println("PmjDaoImpl selectchat getname->"+pmjChatVO.getM_name());
		} catch (Exception e) {
			System.out.println("Dao pmjmember memberDaoImpl selectChat error -> " + e.getMessage());
		}
		return pmjChatVO;
	}		
	
}
