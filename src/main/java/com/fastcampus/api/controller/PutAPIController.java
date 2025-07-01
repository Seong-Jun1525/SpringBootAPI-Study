package com.fastcampus.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.api.dto.PutRequestDTO;

@RestController
@RequestMapping("/api")
public class PutAPIController {
	
	@PutMapping("/put/{userId}")
	public PutRequestDTO putTest(@RequestBody PutRequestDTO putRequestDTO, @PathVariable(name = "userId") Long id) {
		System.out.println(putRequestDTO.toString());
		System.out.println("id : " + id);
		
		// RestController인 경우 Object 자체를 반환하면
		// 스프링부트 자체에서 Object 를 Object Mapper 를 통해서 JSON으로 변환해줌
		return putRequestDTO;
	}
}
