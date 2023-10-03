package com.wanted.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.domain.HiringDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ComponentScan(basePackages = "com.wanted.controller")
public class HiringRestControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(HiringRestControllerTest.class);
	
	private MockMvc mockMvc;

	@Autowired
	private HiringRestController hiringRestController;

	HiringDTO hdto = new HiringDTO();

	@Before
	public void setup() {
		logger.debug("HiringRestController: " + hiringRestController);
		this.mockMvc = MockMvcBuilders.standaloneSetup(hiringRestController).build();
	}

//	@Test
	public void testPostHiring() throws Exception {
		hdto.setCompany_id("네이버");
		hdto.setContent("테스트2");
		hdto.setReward("20000");
		hdto.setSkill("Java");
		hdto.setTitle("자바 개발자");

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonRequestBody = objectMapper.writeValueAsString(hdto);

		mockMvc.perform(post("/hirings")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonRequestBody))
				.andDo(print())
				.andExpect(status().isOk());
	}

//	@Test
	public void testPutHiring() throws Exception {
	    int hiringId = 1;
	    hdto.setCompany_id("네이버");
	    hdto.setContent("테스트 수정");
	    hdto.setReward("1000");
	    hdto.setSkill("JavaScript");
	    hdto.setTitle("프론트 개발자");

	    ObjectMapper objectMapper = new ObjectMapper();
	    String jsonRequestBody = objectMapper.writeValueAsString(hdto);

	    mockMvc.perform(put("/hiring/{hiring_id}", hiringId)
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(jsonRequestBody))
	            .andDo(print())
	            .andExpect(status().isOk());
	}

//	@Test
	public void testDeleteHiring() throws Exception {
		int hiringId = 1;
		
		mockMvc.perform(delete("/hiring/{hiring_id}", hiringId))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

//	@Test
	public void testGetHiring() throws Exception {
		int hiringId = 2;
		
		mockMvc.perform(get("/hiring/{hiring_id}", hiringId))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

	@Test
	public void testSearchHirings() throws Exception {
		String syntax="네";
		
		 mockMvc.perform(get("/hirings")
				.param("syntax", syntax)
				.contentType(MediaType.APPLICATION_JSON))
		 		.andDo(print())
		  		.andExpect(status().isOk());
	    
	}

}
