package com.fastcampus.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fastcampus.api.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class FirstProjectApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("Hello Test");
		
		// Text JSON -> Object
		// Object -> Text JSON
		
		// Controller 에서 JSON 혹은 Text 요청 받을 시 Object 로 변환
		// Object 를 응답 시 JSON 혹은 Text 로 변환
		
		var objectMapper = new ObjectMapper();
		
		// object -> text
		// object mapper 는 get method 를 참조한다 => Getter 필요!!
		// 여기서 주의할 점은 object mapper 는 get method 를 참조하므로
		// 내가 작성한 클래스 가 object mapper 에 사용될 경우 메서드명에서 get 을 빼줘야한다
		
		var user = new UserDTO("홍길동", 10, "010-1234-1234", "fastcampus");
		
		var text = objectMapper.writeValueAsString(user);
		
		System.out.println(text);
		
		// text -> object
		// object mapper 는 동작하기 위해서 기본생성자가 필수이다
		var objectUser = objectMapper.readValue(text, UserDTO.class);
		System.out.println(objectUser);
		
		
	}

}
