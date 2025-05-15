package com.test01;

import java.util.Scanner;

public class SwitchTest01 {
	/*switch(조건)
	 * {
	 * 		case 값1:
	 * 		case 값2:
	 * }
	 * */
	
	public void test1()
	{
		int no = 1;
		
		switch(no)
		{
			case 1: 
				System.out.println("1 입니다.");
				return;		// 메소드 종료 
			case 2: 
				System.out.println("2 입니다.");
				break;
			case 3: 
				System.out.println("3 입니다.");
				break;
			default:
				System.out.println("다른 숫자입니다.");
		}
		
		char ch = 'a';
		
		switch(ch)
		{
			case 'a':
				System.out.println("a입니다.");
				break;
			case 'b':
				System.out.println("b입니다.");
				break;
			case 'c':
				System.out.println("c입니다.");
				break;
			default:
				System.out.println("다른 영어입니다.");
		}
				
	}
	
	public void test2()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("month 입력: ");
		String month = sc.next();
		
		switch(month)
		{
			case "1": 
			case "3":
			case "5":
			case "7":
			case "8":
			case "10":
			case "12":
				System.out.print("31일까지 있는 달입니다.");
				break;	
				
			case "2":
				System.out.print("28or29일까지 있는 달입니다.");
				break;
			
			case "4":		
			case "6":		
			case "9":
			case "11":
				System.out.print("30일까지 있는 달입니다.");
				break;
			
			default: System.out.print("1~12 범위 내로 입력해야 합니다. ");
		}
	}
	
	
}
