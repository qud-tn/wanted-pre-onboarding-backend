package com.wanted.persistance;

import java.util.List;

import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wanted.domain.RecruitDTO;

@Repository
public class RecruitDAOImpl implements RecruitDAO {

	@Autowired
	private SqlSession sqlsession;
	
	private final String NAMESPACE="com.wanted.mapper.RecruitMapper";
	
	@Override
	public Integer insertRecruit(RecruitDTO rdto) throws Exception {
		return sqlsession.insert(NAMESPACE+".insertRecruit", rdto);
	}

	@Override
	public Integer updateRecruit(RecruitDTO rdto) throws Exception {
		return sqlsession.update(NAMESPACE+".updateRecruit",rdto);
	}

	@Override
	public Integer deleteRecruit(Integer recruit_id) throws Exception {
		return sqlsession.delete(NAMESPACE+".deleteRecruit",recruit_id);
	}

	@Override
	public RecruitDTO selectRecruit(Integer recruit_id) throws Exception {
		return sqlsession.selectOne(NAMESPACE+".selectRecruit",recruit_id);
	}

	@Override
	public List<RecruitDTO> selectRecruitList(String syntax) throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectRecruitList", syntax);
	}

	@Override
	public List<Integer> selectRecruit_idList(String companyId) throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectRecruit_idList", companyId);
	}

}
