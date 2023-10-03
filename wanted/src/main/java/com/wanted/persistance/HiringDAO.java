package com.wanted.persistance;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wanted.domain.HiringDTO;

@Repository
public interface HiringDAO {

	public Integer insertHiring(HiringDTO rdto) throws Exception;

	public Integer updateHiring(HiringDTO rdto) throws Exception;

	public Integer deleteHiring(Integer hiring_id) throws Exception;

	public HiringDTO selectHiring(Integer hiring_id) throws Exception;

	public List<HiringDTO> selectHiringList(String syntax) throws Exception;
	
	public List<Integer> selectHiring_idList(String companyId) throws Exception;

}
