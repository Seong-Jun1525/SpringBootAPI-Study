package com.fastcampus.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequestDTO {
	private String account;
	private String email;
	private String address;
	private String password;
	
	/**
	 * 만약 JSON 객체의 key 값이 snake case 로 되어 있다면 다음과 같은 방법으로 해결할 수 있다.
	 * 
	 * @JsonProperty
	 * - 키값을 매칭시킬 수 있다.
	 * - 하나하나 전부 작성해줘야 하는 단점이 있다.
	 * 
	 * 개발을 하다보면 표기법이 아닌 경우도 있다.
	 * 예를들면 약어.. 이런 경우에 사용할 수 있다.
	 */
	@JsonProperty("phone_number")
	private String phoneNumber; // snake case (단어의 구분을 _로 하는 표기법)
	
	public PostRequestDTO() {
		super();
	}

	public PostRequestDTO(String account, String email, String address, String password, String phoneNumber) {
		super();
		this.account = account;
		this.email = email;
		this.address = address;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "PostRequestDTO [account=" + account + ", email=" + email + ", address=" + address + ", password="
				+ password + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
