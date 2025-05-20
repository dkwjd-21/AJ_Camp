package com.test.chap05_method.test02;

public class MethodTest {
	// 매개변수, 반환값에 따른 메소드 구분
	
	// 1. 매개변수X 반환값X
	public void method1() {
		System.out.println("method1 : 매개변수와 반환값이 없는 메소드");
		// return;
	}
	
	// 2. 매개변수X 반환값O
	public String method2() {
		return "method 2: 매개변수 없고 반환값 있는 메소드";
	}
	
	// 3. 매개변수O 반환값X
	public void method3(int num1, int num2) {
		int sum = num1 + num2;
		System.out.println("method 3 : 매개변수 있고 반환값 없는 메소드 [ sum : "+sum+" ]");
		// return;
	}
	
	// 4. 매개변수O 반환값O
	public int method4(int num1, int num2) {
		System.out.println("method 4 : 매개변수 있고 반환값 있는 메소드");
		return num1+num2;
	}
}
