package com.test01;
import java.util.Scanner;

public class Variable02 {
	// class 안에는 메서드 선언과 변수 선언만 가능하다! 
	// 선언된 메서드와 변수의 개수는 상관없다. 단, 이름이 달라야 한다. (같은 블럭 안에서) 
	// 다른 블럭 안에서는 이름이 같아도 상관없음. 
	public void t() {int num;}
	public void t1() {int num;}
	public void t2() {}
	public void t3() {}
	int num; 
	int num1; 
	int num2; 
	
	// main 함수
	public static void main(String args[])
	{
		// 준비
		Variable02 test = new Variable02();	
		// 실행 
		test.test1();
	}	
	
	// method 
	public void test1()
	{
		// 콘솔창에 키보드로 값 입력받기
		// Scanner 클래스
		
		// 다른 패키지의 클래스 사용 
		// 1. java.util.Scanner sc = new java.util.Scanner();
		
		// 2. import java.util.Scanner;
		Scanner sc = new Scanner(System.in);
		
		// 실행
		// sc.nextInt();
		System.out.println("이름 입력하세요: ");
		// nextLine() : 공백 포함 문자열을 받아오는 메서드 
		// next() : 공백 미포함 문자열을 받아오는 메서드 
		String name = sc.nextLine();		// 입력한 값이 name에 대입됨 
		System.out.println("이름: " + name);
	
		// 타입별로 받아올 수 있는 메서드가 존재
		System.out.println("나이 입력하세요: ");
		int age = sc.nextInt();
		System.out.println("나이: " + age);
		
		
		// char로 받고 싶을 때는 변환이 필요함!! string으로만 입력받을 수 있음. 
		// 문자는 문자열로 받아 charAt(index) 이용하여 받는다. 
		String val = sc.nextLine();
		char gender = "A".charAt(0);
		char gender2 = val.charAt(0);
		
		// BufferedReader
	}
}
