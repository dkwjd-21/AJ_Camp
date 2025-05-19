package com.silsub1;

import java.util.Scanner;

public class example {
	Scanner sc = new Scanner(System.in);
	
	public void printStar1()
	{
		System.out.println("정수를 입력하세요: ");
		int a = sc.nextInt();
		
		if(a>0)
		{
			for(int i=1;i<=a;i++)
			{
				for(int j=1;j<=i;j++)
				{
					if(i==j)
					{
						System.out.print(i);
					}
					else
					{
						System.out.print("*");
					}
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("양수를 입력해주세요.");
		}
	}

	public void printStar2()
	{
		System.out.println("정수를 입력하세요: ");
		int a = sc.nextInt();
		
		if(a>0)
		{
			for(int i=1;i<=a;i++)
			{
				for(int j=1;j<=i;j++)
				{
					System.out.print("*");
				}
				System.out.println();
			}
		}
		else if(a<0)
		{
			for(int i=0;i>a;i--)
			{
				// i : 0 -1 -2 -3 -4 
				for(int j=a-i;j<0;j++)
				{
					// j : a a-1 a-2 a-3 a-4 (양수여야됨)  
					System.out.print("*");
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("출력 기능이 없습니다.");
		}
	}

	public void countInputCharacter()
	{
		// 문자열 입력
		System.out.println("문자열 입력: ");
		String str = sc.next();
		
		// 문자 1개 입력 
		System.out.println("문자 입력: ");
		char ch = sc.next().charAt(0);
		
		// toCharArray() : string을 char 배열로 바꾸는 함수
		// char carr[] = str.toCharArray();
		
		
		int cnt = 0;
		
		for(int i=0;i<str.length();i++)
		{
			if((str.charAt(i)>='A'&&str.charAt(i)<='Z')||(str.charAt(i)>='a'&&str.charAt(i)<='z'))
			{
				if(str.charAt(i)==ch)
				{
					cnt++;
				}
			}
			else
			{
				System.out.println("영문자가 아닙니다.");
				cnt = 0;
				break;
			}
				
		}	
		
		if(cnt>0)
		{
			System.out.println("포함된 갯수 : " + cnt +"개");
		}
		
		
		
	}
}
