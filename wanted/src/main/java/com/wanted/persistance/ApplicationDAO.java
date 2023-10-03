package com.wanted.persistance;

import com.wanted.domain.ApplicationDTO;

public interface ApplicationDAO {

	public Integer insertApplication(ApplicationDTO adto) throws Exception;

}
