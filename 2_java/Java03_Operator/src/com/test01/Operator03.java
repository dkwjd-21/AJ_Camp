package com.test01;

import java.util.Scanner;

public class Operator03 {
	public static void main(String[] args)
	{
		Operator03 op = new Operator03();
		
		op.test2();
	}
	
	// && and : 그리고, ~이면서 
	// || or : 또는, ~이거나
	// 논리값 && 논리값, 논리값 || 논리값 => 결과값도 논리값 
	
	public void test1()
	{
		// 정수 하나 키보드로 입력받아 1~100 사이의 숫자인지 확인
		
		// 스캐너 설정
		Scanner sc = new Scanner(System.in);
		
		// System.out.println("정수 하나 입력: ");
		// int num = sc.nextInt();
		
		// System.out.println("1부터 100사이인지 확인: " + (num >= 1 && num <= 100));
		
		// 영어 문자 (char) 하나 입력 받아 영문 대문자인지 확인
		System.out.println("영어 문자를 입력하세요: ");
		String str = sc.nextLine();
		char ch = str.charAt(0);
		System.out.println("대문자?(ch>='A' && ch<='Z') : " + (ch>='A' && ch<='Z'));
		System.out.println("대문자?(Character.isUpperCase(ch)) " + Character.isUpperCase(ch));
		
		System.out.println("계속 하시려면 y 혹은 Y를 입력하세요: ");
		char ch2 = sc.next().charAt(0);
		System.out.println("확인: " + (ch2=='y' || ch2=='Y'));
		
	}
	
	public void test2()
	{
		// 논리값 && 논리값 : 앞의 논리값이 false면 뒤를 실행 안한다.
		// 논리값 || 논리값 : 앞의 논리값이 true면 뒤를 실행 안한다. 
		
		int num = 10;
		// 노란 줄 뜨는거 : 죽은 코드 = 실행될 일이 없음. 
		int res = (false && ++num>0)? num:num;
		System.out.println("&&에서 num : " + num);		
		res = (true || ++num>0)? num:num;
		System.out.println("||에서 num : " + num);
	}
	
	
	
}
