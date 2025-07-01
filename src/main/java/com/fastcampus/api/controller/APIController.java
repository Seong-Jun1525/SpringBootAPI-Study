package com.fastcampus.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 Class 는 REST API 를 처리하는 Controller
@RequestMapping("/api") // @RequestMapping URI를 지정해주는 Annotation
public class APIController {

	@GetMapping("/hello")
	public String hello() {
		return "hello String Boot";
	}
}
