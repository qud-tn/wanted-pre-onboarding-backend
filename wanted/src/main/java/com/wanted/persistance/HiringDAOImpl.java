package com.wanted.persistance;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wanted.domain.HiringDTO;

@Repository
public class HiringDAOImpl implements HiringDAO {

	@Autowired
	private SqlSession sqlsession;
	
	private final String NAMESPACE="com.wanted.mapper.HiringMapper";
	
	@Override
	public Integer insertHiring(HiringDTO rdto) throws Exception {
		return sqlsession.insert(NAMESPACE+".insertHiring", rdto);
	}

	@Override
	public Integer updateHiring(HiringDTO rdto) throws Exception {
		return sqlsession.update(NAMESPACE+".updateHiring",rdto);
	}

	@Override
	public Integer deleteHiring(Integer hiring_id) throws Exception {
		return sqlsession.delete(NAMESPACE+".deleteHiring",hiring_id);
	}

	@Override
	public HiringDTO selectHiring(Integer hiring_id) throws Exception {
		return sqlsession.selectOne(NAMESPACE+".selectHiring",hiring_id);
	}

	@Override
	public List<HiringDTO> selectHiringList(String syntax) throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectHiringList", syntax);
	}

	@Override
	public List<Integer> selectHiring_idList(String companyId) throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectHiring_idList", companyId);
	}

}
