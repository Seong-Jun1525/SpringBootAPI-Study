package com.fastcampus.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeleteAPIController {

	// Delete Method 는 많은 데이터를 받지 않는다 (받을 필요가 없음)
	
	/** 오류발생
	 java.lang.IllegalArgumentException: 
	 	Name for argument of type [java.lang.String] not specified, and parameter name information not available via reflection.
		Ensure that the compiler uses the '-parameters' flag.
		
		=> @PathVariable("userId") 로 userId 명시로 해결!!
	 */
	@DeleteMapping("/delete/{userId}")
	public void deleteTest(@PathVariable("userId") String userId, @RequestParam(value = "account") String account) {
	    System.out.println(userId);
	    System.out.println(account);
	    
	    // Delete -> 자체가 리소스 삭제
	    // 그렇기 때문에 리소스가 없는 상태이더라도 200 상태코드 반환 => 멱등성!
	}
}
