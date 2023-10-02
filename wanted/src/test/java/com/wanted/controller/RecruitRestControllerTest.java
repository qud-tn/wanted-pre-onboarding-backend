package com.wanted.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.controller.RecruitRestController;
import com.wanted.domain.RecruitDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ComponentScan(basePackages = "com.wanted.controller")
public class RecruitRestControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(RecruitRestControllerTest.class);
	
	private MockMvc mockMvc;

	@Autowired
	private RecruitRestController recruitRestController;

	RecruitDTO rdto = new RecruitDTO();

	@Before
	public void setup() {
		logger.debug("RecruitRestController: " + recruitRestController);
		this.mockMvc = MockMvcBuilders.standaloneSetup(recruitRestController).build();
	}

//	@Test
	public void testPostRecruit() throws Exception {
		rdto.setCompany_id("네이버");
		rdto.setContent("테스트2");
		rdto.setReward("20000");
		rdto.setSkill("Java");
		rdto.setTitle("자바 개발자");

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonRequestBody = objectMapper.writeValueAsString(rdto);

		mockMvc.perform(post("/recruits")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonRequestBody))
				.andDo(print())
				.andExpect(status().isOk());
	}

//	@Test
	public void testPutRecruit() throws Exception {
	    int recruitId = 1;
	    rdto.setCompany_id("네이버");
	    rdto.setContent("테스트 수정");
	    rdto.setReward("1000");
	    rdto.setSkill("JavaScript");
	    rdto.setTitle("프론트 개발자");

	    ObjectMapper objectMapper = new ObjectMapper();
	    String jsonRequestBody = objectMapper.writeValueAsString(rdto);

	    mockMvc.perform(put("/recruits/{recruit_id}", recruitId)
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(jsonRequestBody))
	            .andDo(print())
	            .andExpect(status().isOk());
	}

//	@Test
	public void testDeleteRecruit() throws Exception {
		int recruitId = 1;
		
		mockMvc.perform(delete("/recruits/{recruit_id}", recruitId))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

	@Test
	public void testGetRecruit() throws Exception {
		int recruitId = 2;
		
		mockMvc.perform(get("/recruits/{recruit_id}", recruitId))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

	@Test
	public void testSearchRecruits() throws Exception {
		String syntax="네";
		
		 mockMvc.perform(get("/recruits")
				.param("syntax", syntax)
				.contentType(MediaType.APPLICATION_JSON))
		  		.andExpect(status().isOk());
	    
	}

}
