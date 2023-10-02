package com.wanted.controller;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.domain.RecruitDTO;
import com.wanted.service.RecruitService;

@RestController
@RequestMapping(value="/*")
public class RecruitRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RecruitRestController.class);
	
	@Autowired
	private RecruitService rService;
	
	@PostMapping(value="/recruits")
	public ResponseEntity<String> postRecruit(@RequestBody RecruitDTO rdto) throws Exception {
		Integer result= rService.saveRecruit(rdto);
		
		logger.debug("DTO :"+result);
		
		if(result==1) {
			return ResponseEntity.ok("채용 공고 등록 성공");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("채용 공고 등록 실패");
		}
	}

	@PutMapping(value="/recruits/{recruit_id}")
	public ResponseEntity<String> putRecruit(@PathVariable("recruit_id") Integer recruit_id
			, @RequestBody RecruitDTO rdto) throws Exception {
		
		rdto.setRecruit_id(recruit_id);
		
		Integer result = rService.editRecruit(rdto);
		
		logger.debug("DTO :"+result);
		
		if(result==1) {
			return ResponseEntity.ok("채용 공고 수정 성공");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("채용 공고 수정 실패");
		}
	}

	@DeleteMapping(value="/recruits/{recruit_id}")
	public ResponseEntity<String> deleteRecruit(@PathVariable("recruit_id") Integer recruit_id) throws Exception {
		Integer result = rService.removeRecruit(recruit_id);
		
		logger.debug("DTO :"+result);
		
		if(result==1) {
			return ResponseEntity.ok("채용 공고 삭제 성공");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("채용 공고 삭제 실패");
		}
	}

	@GetMapping(value="/recruits/{recruit_id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getRecruit(@PathVariable("recruit_id") Integer recruit_id) throws Exception {
		HashMap<String, Object> result = rService.findRecruit(recruit_id);
		
		logger.debug("HashMap :"+result);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String resultJSON = objectMapper.writeValueAsString(result);
		
		if(result!=null) {
			return ResponseEntity.ok(resultJSON);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("잘못된 요청입니다");
		}
	}

	@GetMapping(value="/recruits")
	public ResponseEntity<String> searchRecruits(String syntax) throws Exception {
		List<RecruitDTO> result = rService.searchRecruits(syntax);
		
		logger.debug("List.size() :"+result.size());
		
		ObjectMapper objectMapper = new ObjectMapper();
		String resultJSON = objectMapper.writeValueAsString(result);
		
		if(!result.isEmpty()) {
			return ResponseEntity.ok(resultJSON);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("검색 결과가 없습니다");
		}
	}
	
}
