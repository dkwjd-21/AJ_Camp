package com.test01;

import java.util.Scanner;

public class WhileTest01 {
	
	
	
	public static void main(String[] args)
	{
		testWhile5();
	}
	
	public static void testWhile1()
	{
		int i = 1;
		while(i<10)
		{
			System.out.println(i + "번째 반복중");
			i += 2;
		}
		System.out.println("while 종류 후 i 값 = " + i);
	}
	
	public static void testWhile2()
	{
		Scanner sc = new Scanner(System.in);
		// 문자열을 입력 받아 인덱스별로 문자 출력
		System.out.println("문자열을 입력하세요.");
		String str = sc.next();
		
		int i=0;
		while(i<str.length())
		{
			char ch = str.charAt(i);
			System.out.println(i+1 + ":" +ch);
			i++;
		}
	}	
	
	public static void testWhile3()
	{
		// 1부터 입력받은 수까지 정수들의 합
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		int input = sc.nextInt();
		int sum = 0;
		int i = 1;
		
		while(i<=input)
		{
			sum += i;
			i++;
		}
		
		System.out.println("1부터 "+ input+"까지의 합은 "+ sum);
		
	}
	
	public static void testWhile4()
	{
//		int i=1;
//		while(true)
//		{
//			System.out.println(i);
//			i++;
//			
//			if(i==10)
//			{
//				break;
//			}
//		}
		
		// 키보드로 숫자를 입력 받는다.
		// 4가 입력될때까지
		// 4를 제외한 나머지 숫자를 입력받으면 계속 반복하며 숫자를 입력받는다. 
		int input = 0;
		
		while(input!=4)
		{
			System.out.println("4를 입력해주세요.");
			input = new Scanner(System.in).nextInt();
		}
		
		System.out.println("4가 입력되었습니다!");
		
		while(true)
		{
			System.out.print("문자열 입력(1, 2, 3, 4, 5)");
			String tmp = new Scanner(System.in).next();
			
			// equals() : 문자열 비교하는 함수
			// String은 참조형 변수여서 == 으로 비교하면 안됨!! 
			if(tmp.equals("4"))
			{
				System.out.println("4입력! 종료!");
				break;
			}
		}
	}
	
	public static void testWhile5()
	{
		int no1 = 1;
		while(no1<10)
		{
			int no2 = 10;
			while(no2<15)
			{
				System.out.println("no1: " + no1 + " no2: " + no2);
				no2++;
			}
			
			System.out.println(" ");
			no1++;
		}
		
		System.out.println("---------------------------------");
		// 구구단 2~9단 출력
		no1 = 2;
		while(no1<10)
		{
			int no2 = 1;
			while(no2<10)
			{
				System.out.println(no1 + "*" + no2 + "=" + no1*no2 );
				no2++;
			}
			System.out.println(" ");
			no1++;
		}
	}
	
}
