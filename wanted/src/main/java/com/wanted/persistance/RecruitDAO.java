package com.wanted.persistance;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wanted.domain.RecruitDTO;

@Repository
public interface RecruitDAO {

	public Integer insertRecruit(RecruitDTO rdto) throws Exception;

	public Integer updateRecruit(RecruitDTO rdto) throws Exception;

	public Integer deleteRecruit(Integer recruit_id) throws Exception;

	public RecruitDTO selectRecruit(Integer recruit_id) throws Exception;

	public List<RecruitDTO> selectRecruitList(String syntax) throws Exception;
	
	public List<Integer> selectRecruit_idList(String companyId) throws Exception;

}
