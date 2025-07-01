package com.fastcampus.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.api.dto.UserRequestDTO;

@RestController
@RequestMapping("/api/get")
public class GetAPIController {

	@GetMapping(path = "/hello") // === http://localhost:포트번호/api/get/hello
	public String getHello() {
		return "get Hello API";
	}
	
	// 예전에 쓰던 방식
	@RequestMapping(path = "/hi", method = RequestMethod.GET) // === http://localhost:포트번호/api/get/hi
	public String hi() {
		return "hi";
	}
	
	// http://localhost:포트번호/api/get/path-variable/{name}
	@GetMapping("/path-variable/{name}")
	public String pathVariable(@PathVariable(name = "name") String name) {
		System.out.println("@PathVariable : " + name);
		return name;
	}
	
	// http://localhost:포트번호/api/get/query-param?user=steve&email=test@test.com&age=26
	// Map 으로 받을 경우 무엇을 받을지 모름 => 직관적이지 않음
	@GetMapping(path = "query-param")
	public String queryParam(@RequestParam Map<String, String> queryParam) {
		
		StringBuilder sb = new StringBuilder();
		
		queryParam.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue() + "\n");
			
			sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	// RequestParam 어노테이션을 사용하여 넘겨받을 파라미터를 지정
	// Map 으로 받는 것보다 더 직관적임
	// 하지만 이렇게 하는것도 넘겨받을 값이 많아 질 경우 @RequestParam을 계속 붙여야하므로 불편함
	// => DTO(Data Transfer Object)를 만들어서 매핑해준다
	@GetMapping("query-param02")
	public String queryParam02(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
		System.out.println(name);
		System.out.println(email);
		System.out.println(age);
		
		return name + " " + email + " " + age;
	}
	
	// @RequestParam을 붙이지 않아도 스프링부트에서 판단한다
	// 객체의 변수와 이름을 매칭한다
	@GetMapping("query-param03")
	public String queryParam03(UserRequestDTO userRequestDTO) {
		System.out.println(userRequestDTO.getName());
		System.out.println(userRequestDTO.getEmail());
		System.out.println(userRequestDTO.getAge());
		
		return userRequestDTO.toString();
	}
}
