package com.fastcampus.api.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PutRequestDTO {
	private String name;
	private int age;
	private List<CarDTO> carList;

	
	public PutRequestDTO() {
		super();
	}


	public PutRequestDTO(String name, int age, List<CarDTO> carList) {
		super();
		this.name = name;
		this.age = age;
		this.carList = carList;
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


	public List<CarDTO> getCarList() {
		return carList;
	}


	public void setCarList(List<CarDTO> carList) {
		this.carList = carList;
	}


	@Override
	public String toString() {
		return "PutRequestDTO [name=" + name + ", age=" + age + ", carList=" + carList + "]";
	}
	
	
}
