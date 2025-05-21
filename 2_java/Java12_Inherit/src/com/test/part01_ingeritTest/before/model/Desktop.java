package com.test.part01_ingeritTest.before.model;

import java.sql.Date;

public class Desktop {
	// 필드
	private String brand;			// 제조사
	private String productNumber;	// 상품번호
	private String productCode;		// 상품코드
	private String productName;		// 상품명
	private String cpu;						//cpu
	private int hdd;						//hdd
	private int ram;						//ram
	private String os;						//os
	private int price;				// 가격
	private Date date;				// 제조일
	private boolean AllInOne;				//AllInOne
	
	// 생성자 (기본, 매개변수)
	public Desktop() { }
	public Desktop(String brand, String productNumber, String productCode,
					  String productName, String cpu, int hdd, int ram, String os,
					  int price, Date date, boolean AllInOne) {
		this.brand = brand;
		this.productNumber = productNumber;
		this.productCode = productCode;
		this.productName = productName;
		this.cpu = cpu;
		this.hdd = hdd;
		this.ram = ram;
		this.os = os;		
		this.price = price;
		this.date = date;
		this.AllInOne = AllInOne;
	}
	
	// get & set
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public void setHdd(int hdd) {
		this.hdd = hdd;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public void setOs(String os) {
		this.os = os;
	}	
	public void setPrice(int price) {
		this.price = price;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setAllInOne(boolean AllInOne) {
		this.AllInOne = AllInOne;
	}
	
	
	public String getBrand() {
		return brand;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public String getProductCode() {
		return productCode;
	}
	public String getProductName() {
		return productName;
	}
	public String getCpu() {
		return cpu;
	}
	public int getHdd() {
		return hdd;
	}
	public int getRam() {
		return ram;
	}
	public String getOs() {
		return os;
	}	
	public int getPrice() {
		return price;
	}
	public Date getDate() {
		return date;
	}
	public boolean getAllInOne() {
		return AllInOne;
	}
	
	
	// prn() : 필드값 출력
	public void prn() {
		System.out.println(brand+", "+productNumber+", "+productCode+", "+productName+", "
						   +cpu+", "+hdd+", "+ram+", "+os
						   +price+", "+date+", "+AllInOne);
	}
}
