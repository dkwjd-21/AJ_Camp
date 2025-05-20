package com.test.singleton;

public class Singleton {
	// 클래스의 객체를 하나만 생성해서 사용하는 패턴 
	
	private static Singleton one;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		// 해당 메소드가 호출이 될 때 Singleton 객체를 생성해서
		// one에 저장
		// 단, 첫 호출시에만
		if(one == null) {
			one = new Singleton();
		}
		return one;
	}
	
	// 결합도가 높아짐 
	public void prn() {
		System.out.println("Singleton 클래스의 일반 메소드");
		System.out.println(this);
	}
}
