package com.oracle.springProject01.dao.cheDao;

import java.util.List;

import com.oracle.springProject01.model.ChePostVO;

public interface MainDao {
	List<ChePostVO> bestListPost(ChePostVO post);
}
