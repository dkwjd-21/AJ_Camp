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
				for(int j=0;j>=a+i;j--)
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
}
