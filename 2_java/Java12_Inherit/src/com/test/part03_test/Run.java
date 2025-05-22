package com.test.part03_test;

public class Run {

	public static void main(String[] args) {
		Car c1 = new SUV("하얀");
		c1.accelPedal();
		
		System.out.println(c1.toString());
		
		Object obj = new SUV();
	}

}
