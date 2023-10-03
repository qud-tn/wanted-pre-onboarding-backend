package com.wanted.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanted.domain.ApplicationDTO;
import com.wanted.persistance.ApplicationDAO;

@Service
public class ApplicationServiceImpl implements ApplicationService{

	@Autowired
	private ApplicationDAO adao;
	
	@Override
	public Integer uploadApplication(ApplicationDTO adto) throws Exception {
		return adao.insertApplication(adto);
	}

}
