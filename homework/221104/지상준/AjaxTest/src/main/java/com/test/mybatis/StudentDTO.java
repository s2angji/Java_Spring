package com.test.mybatis;

public class StudentDTO {
	String name;
	int age;
	String birth;
	
	
	
	public StudentDTO() {
		this.name = "";
		this.age = 0;
		this.birth = "";
	}

	public StudentDTO(String name, int age, String birth) {
		this.name = name;
		this.age = age;
		this.birth = birth;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
}
