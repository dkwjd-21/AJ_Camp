package com.poly.part00_test.test04;

public class Cat extends Animal{

	@Override
	public void bark() {
		// TODO Auto-generated method stub
		System.out.println("야옹야옹");
	}
	
	public void eat(String str) {
		System.out.println("고양이가 ");
		super.eat(str);
	}

}
