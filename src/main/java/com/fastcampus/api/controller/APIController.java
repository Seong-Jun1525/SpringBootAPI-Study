package com.fastcampus.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.api.dto.UserDTO;

@RestController // 해당 Class 는 REST API 를 처리하는 Controller
@RequestMapping("/api") // @RequestMapping URI를 지정해주는 Annotation
public class APIController {

	@GetMapping("/hello")
	public String hello() {
		return "hello String Boot";
	}
	
	// Text
	@GetMapping("/text")
	public String text(@RequestParam("account") String account) {
		return account;
	}
	
	// JSON
	// Request -> Object Mapper를 통해서 Object 로 변환 -> Method -> Object -> Object Mapper 를 통해서 JSON 으로 변환 -> Response
	@PostMapping("/json")
	public UserDTO json(@RequestBody UserDTO userDTO) {
		return userDTO;
	}
	
	// 가장 명확하게 응답을 반환하는 법
	// PUT 같은 경우 생성할 경우 201을 반환하게 되어 있음
	// => 그럼 201에 대한 응답을 할 수 있는 방법은 아래와 같다
	@PutMapping("/json-put")
	public ResponseEntity<UserDTO> put(@RequestBody UserDTO userDTO) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
	}
}
