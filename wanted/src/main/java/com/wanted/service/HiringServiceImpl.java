package com.wanted.service;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanted.domain.HiringDTO;
import com.wanted.persistance.HiringDAO;

@Service
public class HiringServiceImpl implements HiringService{

	@Autowired
	private HiringDAO hdao;

	@Override
	public Integer saveHiring(HiringDTO rdto) throws Exception {
		return hdao.insertHiring(rdto);
	}

	@Override
	public Integer editHiring(HiringDTO rdto) throws Exception {
		return hdao.updateHiring(rdto);
	}

	@Override
	public Integer removeHiring(Integer Hiring_id) throws Exception {
		return hdao.deleteHiring(Hiring_id);
	}

	@Override
	public HashMap<String, Object> findHiring(Integer Hiring_id) throws Exception {
		HiringDTO HiringDTO=hdao.selectHiring(Hiring_id);
		HashMap<String, Object> hiringMap= HiringDTO.toHashMap();
		
		String companyId= HiringDTO.getCompany_id();
		List<Integer> hiring_idList= hdao.selectHiring_idList(companyId);
		
		hiringMap.put("hiringList", hiring_idList);
		
		return hiringMap;
	}
	
	@Override
	public List<HiringDTO> searchHirings(String syntax) throws Exception {
		return hdao.selectHiringList(syntax);
	}
	
}
