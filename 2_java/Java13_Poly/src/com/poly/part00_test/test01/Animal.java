package com.poly.part00_test.test01;

// 추상 클래스 선언을 해야 추상 메서드를 가질 수 있다. 
public abstract class Animal 
{
	// 추상 메소드는 상속받는 class가 반드시 구현. 
	public abstract void bark() {
		
	}
	
	public void eat(String str) {
		System.out.println(str+" 먹는다.");
	}
}
