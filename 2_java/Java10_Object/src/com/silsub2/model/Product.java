package com.silsub2.model;

public class Product {
	private String pName;
	private int price;
	private String brand;
	
	public Product() {}
	
	// pName
	public void setPName(String pName) {
		this.pName = pName;
	}
	public String getPName() {
		return pName;
	}
	// price
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	// brand
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBrand() {
		return brand;
	}
	
	// information
	public String information() {
		return "pName: "+pName+"\nprice: "+price+"\nbrand: "+brand;
	}
}
