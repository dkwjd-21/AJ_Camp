package com.test02;


public class Test {
	
	public void test01(int n)
	{
		// 1. 입력받은 수가 5의 배수이면 "5의 배수입니다" 출력
		if(n%5 == 0)
		{
			System.out.println("5의 배수입니다.");
		}
		else
		{
			System.out.println("5의 배수가 아닙니다.");
		}
	}
	
	public void test02(int n)
	{
		// 2. 입력받은 수가 2의 배수이면서 3의 배수이면 "2와 3의 배수입니다" 출력
		// 아니라면, "2와 3의 배수가 아닙니다" 출력
		if(n%2 == 0 && n%3 == 0)
		{
			System.out.println("2와 3의 배수입니다.");
		}
		else
		{
			System.out.println("2와 3의 배수가 아닙니다.");
		}
	}
	
	public void test03(char ch)
	{
		// 3. 입력받은 문자가 소문자라면 "소문자입니다.", 대문자라면 "대문자입니다" 출력
		if(ch>='a' && ch<='z')
		{
			System.out.println("소문자입니다.");
		}
		else if(ch>='A' && ch<='Z')
		{
			System.out.println("대문자입니다.");
		}
		
		/*if(Character.isUpperCase(ch))
		 * {
		 * 		System.out.println("대문자입니다.");
		 * }
		 * else if(Character.isLowerCase(ch))
		 * {
		 * 		System.out.println("소문자입니다.");
		 * }
		 * */
		
		
	}
}
