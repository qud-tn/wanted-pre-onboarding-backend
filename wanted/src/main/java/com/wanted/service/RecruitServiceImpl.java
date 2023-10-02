package com.wanted.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.wanted.domain.RecruitDTO;
import com.wanted.persistance.RecruitDAO;

@Service
public class RecruitServiceImpl implements RecruitService{

	@Inject
	private RecruitDAO rdao;

	@Override
	public Integer saveRecruit(RecruitDTO rdto) throws Exception {
		return rdao.insertRecruit(rdto);
	}

	@Override
	public Integer editRecruit(RecruitDTO rdto) throws Exception {
		return rdao.updateRecruit(rdto);
	}

	@Override
	public Integer removeRecruit(Integer recruit_id) throws Exception {
		return rdao.deleteRecruit(recruit_id);
	}

	@Override
	public HashMap<String, Object> findRecruit(Integer recruit_id) throws Exception {
		RecruitDTO recruitDTO=rdao.selectRecruit(recruit_id);
		HashMap<String, Object> recruitMap= recruitDTO.toHashMap();
		
		String companyId= recruitDTO.getCompany_id();
		List<Integer> recruit_idList= rdao.selectRecruit_idList(companyId);
		
		recruitMap.put("RecruitList", recruit_idList);
		
		return recruitMap;
	}
	
	@Override
	public List<RecruitDTO> searchRecruits(String syntax) throws Exception {
		return rdao.selectRecruitList(syntax);
	}
	
}
