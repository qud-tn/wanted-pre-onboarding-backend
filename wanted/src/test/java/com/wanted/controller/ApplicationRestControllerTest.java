package com.wanted.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.domain.ApplicationDTO;
import com.wanted.domain.HiringDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ApplicationRestControllerTest {
	
private static final Logger logger = LoggerFactory.getLogger(HiringRestControllerTest.class);
	
	private MockMvc mockMvc;

	@Autowired
	private ApplicationRestController applicationRestController;

	ApplicationDTO adto = new ApplicationDTO();

	@Before
	public void setup() {
		logger.debug("ApplicationRestController: " + applicationRestController);
		this.mockMvc = MockMvcBuilders.standaloneSetup(applicationRestController).build();
	}
	
	
	@Test
	public void testCreateApplication() throws Exception {
		adto.setHiring_id(2);
		adto.setMember_id("test");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonRequestBody = objectMapper.writeValueAsString(adto);
		
		mockMvc.perform(post("/applications")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonRequestBody))
				.andDo(print())
				.andExpect(status().isOk());
	}

}
