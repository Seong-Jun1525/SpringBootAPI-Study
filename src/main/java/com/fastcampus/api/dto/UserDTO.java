package com.fastcampus.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

// 응답할 때 null 값들을 포함하지 않는 어노테이션
// 개발 할 때 JSON 규격서 같은 곳에 명시를 해줘야 한다
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
	private String name;
	private int age;
	private String phoneNumber;
	private String address;
	
	
	public UserDTO() {
		super();
	}


	public UserDTO(String name, int age, String phoneNumber, String address) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	
}
