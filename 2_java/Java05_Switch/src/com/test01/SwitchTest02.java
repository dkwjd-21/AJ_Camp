package com.test01;

import java.util.Scanner;

public class SwitchTest02 {
	
	Scanner sc = new Scanner(System.in);
	
	public void test1()
	{
		// 정수 두 개와 연산기호를 문자로 입력받아
		// 입력받은 연산기호에 해당하는 계산을 하고 출력
		// 3 4 + -> 3+4
		
		System.out.print("정수 A를 입력하세요.");
		int a = sc.nextInt();
		System.out.print("정수 B를 입력하세요.");
		int b = sc.nextInt();
		System.out.print("연산 기호(+, -, *, /, %)를 입력하세요.");
		char ch = sc.next().charAt(0);
		
		int res;
		
		switch(ch)
		{
			case '+' : 
				res = a+b;
				break;
			case '-' : 
				res = a-b;
				break;
			case '*' : 
				res = a*b;
				break;
			case '/' : 
				res = a/b;
				break;
			case '%' : 
				res = a%b;
				break;
			default : 
				System.out.print("연산기호를 정확히 입력해주세요.");
				res = 0;
		}
		
		System.out.println(a + "" + ch+ "" + b + "=" + res);
	}
}
