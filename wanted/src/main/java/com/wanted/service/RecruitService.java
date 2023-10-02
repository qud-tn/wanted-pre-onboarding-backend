package com.wanted.service;

import java.util.HashMap;
import java.util.List;

import com.wanted.domain.RecruitDTO;

public interface RecruitService {

	public Integer saveRecruit(RecruitDTO rdto) throws Exception;

	public Integer editRecruit(RecruitDTO rdto) throws Exception;

	public Integer removeRecruit(Integer recruit_id) throws Exception;

	public HashMap<String, Object> findRecruit(Integer recruit_id) throws Exception;

	public List<RecruitDTO> searchRecruits(String syntax) throws Exception;

}
