package com.wanted.service;

import java.util.HashMap;
import java.util.List;

import com.wanted.domain.HiringDTO;

public interface HiringService {

	public Integer saveHiring(HiringDTO rdto) throws Exception;

	public Integer editHiring(HiringDTO rdto) throws Exception;

	public Integer removeHiring(Integer hiring_id) throws Exception;

	public HashMap<String, Object> findHiring(Integer hiring_id) throws Exception;

	public List<HiringDTO> searchHirings(String syntax) throws Exception;

}
