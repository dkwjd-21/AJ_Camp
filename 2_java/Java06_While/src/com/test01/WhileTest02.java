package com.test01;

import java.util.Scanner;

public class WhileTest02 {

	public static void main(String[] args) {
		testDoWhile3();
	}
	
	public static void testDoWhile1()
	{
		int i =1;
		do {
			System.out.println(i);
			i++;
		}while(i<=10);
		System.out.println("반복문 종료 후 i:" + i);
		
		// 이 시점에서 i =11
		do {
			System.out.println(i);
			i--;
		}while(i>=1);
		System.out.println("반복문 종료 후 i:" + i);
		
	}
	
	public static void testDoWhile2()
	{
		// 키보드로 영어 문자열값을 입력 받아 출력하는 걸 반복.
		// 단, exit 입력할 때까지
		// do while을 이용해서
		Scanner sc = new Scanner(System.in);
		String str = "";
		
		do {
			System.out.println("문자열: ");
			str = sc.next();
			System.out.println("str: " + str);
		}while(!str.equals("exit"));
			
		System.out.println("exit 입력 완료!! >< ");
	}
	
	public static void testDoWhile3()
	{
		Scanner sc = new Scanner(System.in);
		String str = "";
		
		// testDowhile2와 동일하게 동작하도록 구성
		do {
			System.out.println("문자열을 입력하세요! : ");
			str = sc.next();
			
			if(str.equals("exit"))
			{
				break;
			}
		}while(true);
		
		System.out.println("exit 입력 완료!! >< ");			
	}
}
