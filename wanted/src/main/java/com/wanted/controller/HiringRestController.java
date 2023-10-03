package com.wanted.controller;


import java.util.HashMap;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.domain.HiringDTO;
import com.wanted.service.HiringService;

@RestController
@RequestMapping(value="/*")
public class HiringRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(HiringRestController.class);
	
	@Autowired
	private HiringService hService;
	
	@PostMapping(value="/hirings")
	public ResponseEntity<String> postHiring(@RequestBody HiringDTO rdto) throws Exception {
		Integer result= hService.saveHiring(rdto);
		
		logger.debug("DTO :"+result);
		
		if(result==1) {
			return ResponseEntity.ok("채용 공고 등록 성공");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("채용 공고 등록 실패");
		}
	}

	@PutMapping(value="/hiring/{hiring_id}")
	public ResponseEntity<String> putHiring(@PathVariable("hiring_id") Integer hiring_id
			, @RequestBody HiringDTO rdto) throws Exception {
		
		rdto.setHiring_id(hiring_id);
		
		Integer result = hService.editHiring(rdto);
		
		logger.debug("DTO :"+result);
		
		if(result==1) {
			return ResponseEntity.ok("채용 공고 수정 성공");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("채용 공고 수정 실패");
		}
	}

	@DeleteMapping(value="/hiring/{hiring_id}")
	public ResponseEntity<String> deleteHiring(@PathVariable("hiring_id") Integer hiring_id) throws Exception {
		Integer result = hService.removeHiring(hiring_id);
		
		logger.debug("DTO :"+result);
		
		if(result==1) {
			return ResponseEntity.ok("채용 공고 삭제 성공");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("채용 공고 삭제 실패");
		}
	}

	@GetMapping(value="/hiring/{hiring_id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getHiring(@PathVariable("hiring_id") Integer hiring_id) throws Exception {
		HashMap<String, Object> result = hService.findHiring(hiring_id);
		
		logger.debug("HashMap :"+result);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String resultJSON = objectMapper.writeValueAsString(result);
		
		if(result!=null) {
			return ResponseEntity.ok(resultJSON);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("잘못된 요청입니다");
		}
	}

	@GetMapping(value="/hirings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> searchHirings(String syntax) throws Exception {
		List<HiringDTO> result = hService.searchHirings(syntax);
		
		logger.debug("List.size() :"+result.size());
		
		ObjectMapper objectMapper = new ObjectMapper();
		String resultJSON = objectMapper.writeValueAsString(result);
		
		if(!result.isEmpty()) {
			return ResponseEntity.ok(resultJSON);
		}else {
			return ResponseEntity.ok("검색 결과가 없습니다");
		}
	}
	
}
