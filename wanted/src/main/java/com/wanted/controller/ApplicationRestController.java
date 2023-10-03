package com.wanted.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wanted.domain.ApplicationDTO;
import com.wanted.service.ApplicationService;

@RestController
@RequestMapping(value="/*")
public class ApplicationRestController {
	@Autowired
	private ApplicationService aService;
	
	@PostMapping(value="/applications" )
	public ResponseEntity<String> postApplication(@RequestBody ApplicationDTO adto) throws Exception{
		Integer result= aService.uploadApplication(adto);
		
		if(result==1) {
			return ResponseEntity.status(HttpStatus.OK).body("지원 완료");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("지원 중 오류 발생");
		}
	}
}
