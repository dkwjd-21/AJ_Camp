package com.silsub1;

// 거래자 - 이름, 도시
public class Trader {
	private String name;
	private String city;
	
	public Trader() {}
	public Trader(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "(Trader) " + name + ", " + city;
	}
	
	
	
}
