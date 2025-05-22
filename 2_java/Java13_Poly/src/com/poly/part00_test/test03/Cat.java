package com.poly.part00_test.test03;

public class Cat implements Animal {

	@Override
	public void bark() {
		// TODO Auto-generated method stub
		System.out.println("야옹야옹");
	}

	@Override
	public void eat(String str) {
		// TODO Auto-generated method stub
		System.out.println(str + " 먹는다.");
	}
	
}
