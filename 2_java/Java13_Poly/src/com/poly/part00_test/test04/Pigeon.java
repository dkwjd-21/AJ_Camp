package com.poly.part00_test.test04;

public class Pigeon extends Animal implements Bird{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("파닥");
	}

	@Override
	public void bark() {
		// TODO Auto-generated method stub
		System.out.println("구구구");
	}

}
