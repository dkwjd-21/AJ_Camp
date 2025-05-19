package com.arrayPractice1;

import java.util.Scanner;

public class ArraySample {
	public void test1()
	{
		int[] arr = new int[10];
		
		// (int)(Math.random()*100)+1
		int sum = 0;
		
		System.out.println("arr: ");
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = (int)(Math.random()*100)+1;
			System.out.print(arr[i] +" ");
			sum += arr[i];
		}	
		
		System.out.println("\nsum: "+ sum);
	}

	public void test2()
	{
		int arr[] = new int[10];
		int Max=0, Min = 100;
		
		System.out.println("arr: ");
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = (int)(Math.random()*100)+1;
			System.out.print(arr[i] +" ");
			
			if(arr[i]>Max)
			{
				Max = arr[i];
			}
			else if(arr[i]<Min)
			{
				Min = arr[i];
			}
		}
		
		System.out.println("\nMax: "+ Max + "\nMin: "+Min);
	}
	
	public void test3()
	{
		byte arr[] = new byte[10];		
		int sum = 0;
		
		System.out.println("arr: ");
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = (byte)(Math.random()*Byte.MAX_VALUE);
			System.out.print(arr[i] +" ");
			
			if(arr[i]%2 == 0)
			{
				sum += arr[i];
			}
		}
		System.out.println("\nsum: "+sum);
	}
	
	public void test4()
	{
		// 숫자로 된 문자열 입력받기. substring()
		// 각 자리의 숫자들의 합 구하기 (Integer 클래스)  
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열 입력: ");
		String str = sc.next();
		
		int sum = 0;
		
		for(int i=0;i<str.length();i++)
		{
			sum += Integer.parseInt(str.substring(i, i+1));
			System.out.println(str.substring(i, i+1));
		}
		System.out.println("sum: "+sum);
	}
	
	public void test5()
	{
		// 숫자로 된 문자열 입력받기. substring()
		// 각 자리의 숫자들의 합 구하기 (Integer 클래스)  
		Scanner sc = new Scanner(System.in);
				
		System.out.println("문자열 입력: ");
		String str = sc.next();
				
		int sum = 0;
				
		for(int i=0;i<str.length();i++)
		{
			sum += Character.getNumericValue(str.charAt(i));
			System.out.println(str.charAt(i));
		}
		System.out.println("sum: "+sum);	
	}
}
