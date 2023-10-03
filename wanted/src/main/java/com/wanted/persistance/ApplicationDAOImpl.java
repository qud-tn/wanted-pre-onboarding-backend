package com.wanted.persistance;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wanted.domain.ApplicationDTO;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO {

	@Autowired
	private SqlSession sqlsession;
	
	private final String NAMESPACE="com.wanted.mapper.ApplicationMapper";
	
	@Override
	public Integer insertApplication(ApplicationDTO adto) throws Exception {
		return sqlsession.insert(NAMESPACE+".insertApplication",adto);
	}

}
