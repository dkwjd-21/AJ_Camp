package com.test01;

import java.util.Scanner;

public class ForTest01 {	

	public static void main(String[] args) {
		testFor5();
	}

	public static void testFor1()
	{
		// 출력문을 반복하여 실행
		int i =0;
		while(i<10)
		{
			System.out.println(i);
			i++;
		}
		
		for(int no=0; no<10; no++)
		{
			System.out.println("no: "+no);
		}
		
		System.out.println("=======================");
		// 역순으로
		for(int no=9; no>0; no--)
		{
			System.out.println("no: "+no);
		}
	}
	
	public static void testFor2()
	{
		// 증감식
		for(int i=0;i<10;i+=2)
		{
			System.out.println("i: "+i);
		}
		System.out.println(" ");
		
		for(int i=0, j=10; i<10 && j>0; i++, j--)
		{
			System.out.println("i: "+i + " / j: " + j);
		}
		System.out.println(" ");
		
		for(char ch='a';ch<='z';ch++)
		{
			System.out.println("ch: " + ch);
		}		
	}
	
	public static void testFor3()
	{
		int i = 0;
		for(;;)
		{
			// while(true)와 같음
			System.out.println(i);
			i++;
			if(i==10)
			{
				break;
			}			
		}
	}
	
	public static void testFor4()
	{
		Scanner sc = new Scanner(System.in);
		// 정수 하나를 입력 받아 입력받은 수의 구구단을 출력
		// 단, 1~9 사이의 수가 아닌 경우 "반드시 1~9 사이의 양수 입력해야 합니다" 출력
		System.out.println("1~9 사이의 양수를 입력하세요: ");
		int index = sc.nextInt();
		
		if(index>=1 && index<=9)
		{
			for(int i=1; i<10; i++)
			{
				System.out.println(index + "*"+i+"="+(index*i));
			}
		}
		else
		{
			System.out.println("반드시 1~9 사이의 양수를 입력해야 합니다.");
		}
	}
	
	public static void testFor5()
	{
		// 1~100 사이의 숫자 중 1부터 임의의 난수까지의 합을 구하여 출력
		
		// Math.random() : 0~1 사이의 값 (double)
		// System.out.println(Math.random());
		
		// Math.random() : 0~1 사이의 값 * 100
		// System.out.println(Math.random()*100);
		
		// Math.random() : 0~1 사이의 값 * 100
		// System.out.println((int)(Math.random()*100)+1);
		int ran = (int)(Math.random()*100)+1;
		System.out.println("random: " + ran);
		
		int sum = 0;
		
		for(int i=1; i<=ran; i++)
		{
			sum += i;
		}
		System.out.println("1부터 "+ ran+"까지의 합은 "+sum);
	}
}
