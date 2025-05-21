package com.test02.model;

public class Person {
	// 필드
	private String name;
	private int age;
	private int wealth;
	
	// 생성자
	public Person() { }
	public Person(String name, int age, int wealth) {
		this.name = name;
		this.age = age;
		this.wealth = wealth;
	}
	
	// set & get
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setWealth(int wealth) {
		this.wealth = wealth;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getWealth() {
		return wealth;
	}
	
	// info
	public String info() {
		String str = "이름 : "+name+"\n나이 : "+age+"\n재산 : "+wealth;
		return str;
	}
}
