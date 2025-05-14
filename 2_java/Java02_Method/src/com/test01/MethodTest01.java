package com.test01;

public class MethodTest01 {

	public static void main(String[] args) {
		// static method 실행
		// 클래스명.메서드명();
		
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		MethodTest01.defaultMethod();
		privateMethod();
		
		// nonStartMethod 실행
		// 클래스명 변수명 = new 클래스명();
		// 변수명.메서드명();
		MethodTest01 mt = new MethodTest01();
		mt.NonStaticMethod();
	}
	
	// 접근제한자
	
	// public : 어디서나 누구나 접근, 참조 가능하다. (+) +test1();
	public static void publicMethod()
	{
		System.out.println("pulbic method");
	}
	
	// protected (#) 
	// 상속일 경우 상속된 곳에서, 상속이 아닐 경우 같은 패키지 안에서 접근, 참조 가능하다.
	protected static void protectedMethod()
	{
		System.out.println("protected method");
	}
	
	// default : 앞에 아무것도 없음!!
	// 같은 패키지 안에서 접근, 참조 가능하다
	static void defaultMethod()
	{
		System.out.println("default");
	}
	
	// private (-)
	// 현재 클래스 안에서만 접근, 참조 가능하다 
	private static void privateMethod()
	{
		System.out.println("private method");
	}
	
	public void NonStaticMethod()
	{
		System.out.println("NonStaticMethod");
	}
}
