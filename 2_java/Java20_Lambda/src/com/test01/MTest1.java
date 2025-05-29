package com.test01;

public class MTest1 {
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hi");
			}
		};
		
		// 람다식 (상속 없이 사용 가능)
		Runnable r2 = () -> System.out.println("Hello");
		
		r.run();
		r2.run();
		
		/* ===================================================== */
		Test01 test01_0 = new Test01() {
			@Override
			public void prn() {
				System.out.println("test01_0");
			}
		};
		test01_0.prn();		
		
		// () -> {code;};
		Test01 test01_1 = () -> {System.out.println("test01");};
		test01_1.prn();		
		
		// (param) -> code; 
		Test02 test02_1 = (int n) -> System.out.println("input no: "+n);
		test02_1.prn(1);
		
		// 매개변수의 타입은 대부분 짐작 가능하여 생략하는 경우가 많음 
		Test02 test02_2 = (n) -> System.out.println("input no : "+n);
		test02_2.prn(2);
		
		Test02 test02_3 = n -> System.out.println("input no : "+n);
		test02_3.prn(3);
		
		// (param) -> {code; return;}
		Test03 test03 = n -> n+n;
		System.out.println(test03.prn(4));
		test03 = n -> {
			System.out.println(n+"입력");
			return n+n;
		};
		System.out.println(test03.prn(4));
		
		// (param, param) -> {code; return;}
		Test04 test04 = (n, m) -> {	// 매개변수 2개 이상일 때는 반드시 괄호처리
			System.out.println("n: "+n+", m: "+m);
			return n*m;
		};
		System.out.println(test04.prn(5, 5));
	}
}
