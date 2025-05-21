package com.test.part01_ingeritTest.after.model;

import java.util.Date;

public class SmartPhone extends Computer {
	private String mobileAgency;
	public SmartPhone() {}
	public SmartPhone(String brand, String productNumber, String productCode, String productName, int price, Date date,
			String cpu, int hdd, int ram, String os, String mobileAgency) {
		super(brand, productNumber, productCode, productName, price, date, cpu, hdd, ram, os);
		this.mobileAgency = mobileAgency;
	}
	public String getMobileAgency() {
		return mobileAgency;
	}
	public void setMobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}
	@Override
	public String toString() {
		return super.toString()+"mobileAgency=" + mobileAgency;
	} 
	
	
	
}
