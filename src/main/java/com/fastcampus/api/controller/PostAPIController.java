package com.fastcampus.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.api.dto.PostRequestDTO;

@RestController
@RequestMapping("/api")
public class PostAPIController {
	
	@PostMapping("/post")
	public void post(@RequestBody Map<String, Object> requestData) {
		requestData.entrySet().forEach(entry -> {
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
		});
	}
	
	@PostMapping("/post2")
	public void post2(@RequestBody PostRequestDTO postRequestDTO) {
		System.out.println(postRequestDTO.toString());
	}
}
