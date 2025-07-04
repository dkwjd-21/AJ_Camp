package com.test04;

public class Address {
	private String name;
	private String addr;
	private String phone;
	
	public Address() {}

	
	
	public Address(String name, String addr, String phone) {
		super();
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
//		System.out.println("setName call!");
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
//		System.out.println("setAddr call!");
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
//		System.out.println("setPhone call!");
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}
	
	
}
