package com.test.chap05_method.test02;

public class Run {

	public static void main(String[] args) {
		// ctrl + space : 자동완성
		
		MethodTest mt = new MethodTest();
		
		// 1. 매개변수X 반환값X
		mt.method1();
		// 2. 매개변수X 반환값O
		String str = mt.method2();
		System.out.println(str);
		// 3. 매개변수O 반환값X
		mt.method3(10, 20);
		// 4. 매개변수O 반환값O
		mt.method4(20, 30);
		
		mt.method3(mt.method4(20, 30), mt.method4(10, 20));
		
		// static 메소드 실행
		StaticMethodTest.staticMethod1();
		System.out.println("res: "+StaticMethodTest.staticMethod2());
		StaticMethodTest.staticMehotd3("유리");
		System.out.println(StaticMethodTest.staticMethod4("유리"));
	}

}
