package com.fastcampus.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.api.dto.UserDTO;

@Controller
public class PageController {

	@GetMapping("/")
	public String main() {
		return "index.html";
	}
	
	// @ResponseEntity를 사용하여 JSON을 응답할 수 있음
	
	// @ResponseBody를 사용하여 JSON을 응답할 수도 있음
	@ResponseBody
	@GetMapping("/user")
	public UserDTO userDTO() {
		var userDTO = new UserDTO("김길동", 10, "010-1234-1234", null);
		// var : 타입 추론 가능
		return userDTO;
	}
}
