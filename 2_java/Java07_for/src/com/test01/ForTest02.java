package com.test01;

import java.util.Scanner;

public class ForTest02 {

	public static void main(String[] args) {
		testFor4_T();
	}
	
	public static void testFor1()
	{
		for(int i=0; i<10; i++)
		{
			System.out.println(i+" : ");
			for(int j=0;j<10;j++)
			{
				System.out.println(j+" ");
			}
			System.out.println();
		}
	}
	
	public static void testFor2()
	{
		// 구구단 (2~9)
		for(int i=2; i<10;i++)
		{
			for(int j=1;j<10;j++)
			{
				System.out.println(i+"*"+j+"="+(i*j));
			}
			System.out.println("=============================");
		}
	}

	public static void testFor3()
	{
		for(int i=0;i<5;i++)
		{
			// System.out.println("@");
			/* @@@@@
			 * @@@@@
			 * @@@@@
			 * @@@@@
			 * @@@@@
			 * */
			for(int j=0;j<5;j++)
			{	
				System.out.print("@");
			}
			System.out.println();
		}
		System.out.println();
		
		int no = 1;
		/* 12345
		 * 678910
		 * 1112131415
		 * 1617181920
		 * 2122232425
		 * */
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(no++ + " ");
			}
			System.out.println();
		}
	}

	public static void testFor4()
	{
		/* 1@@@@ 
		 * @2@@@
		 * @@3@@
		 * @@@4@
		 * @@@@5
		 * 
		 * 1@@@@@
		 * @2@@@@
		 * @@3@@@
		 * @@@4@@
		 * @@@@5@
		 * @@@@@6
		 * 
		 * 한줄에 @문자를 입력된 줄의 수와 칸수 만큼 출력하자. 
		 * 숫자 두개 입력 : 줄 & 칸 
		 * */
		
		for(int i =1;i<=5;i++)
		{
			for(int j=1;j<i;j++)
			{
				System.out.print("@");
			}
			System.out.print(i);
			for(int j=0;j<5-i;j++)
			{
				System.out.print("@");
			}
			System.out.println();
		}
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 줄? : ");
		int for_i = sc.nextInt();
		System.out.println("몇 칸? : ");
		int for_j = sc.nextInt();
		
		for(int i =1;i<=for_i;i++)
		{
			for(int j=1;j<i;j++)
			{
				System.out.print("@");
			}
			System.out.print(i);
			
			for(int j=0;j<for_j-i;j++)
			{
				System.out.print("@");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void testFor4_T()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("줄 수 : ");
		int row = sc.nextInt();
		System.out.print("칸 수 : ");
		int col = sc.nextInt();
		
		for(int r=0; r<row; r++)
		{
			for(int c=0;c<col;c++)
			{
				if(r==c)
				{
					System.out.print(r+1);
				}
				else
				{
					System.out.print("@");
				}
			}
			System.out.println();
		}
	}
}
