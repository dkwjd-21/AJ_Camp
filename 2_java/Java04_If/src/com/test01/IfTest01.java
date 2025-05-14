package com.test01;

import java.util.Scanner;

public class IfTest01 {
	
	// 필드, 멤버변수, 전역변수
	Scanner sc = new Scanner(System.in);
	
	public void testIf()
	{
		// 단독 if문 
		// 조건식의 결과가 참이면 {} 안에 코드 실행
		// 조건식의 결과가 거짓이면 {} 안에 있는 코드를 무시하고 건너뛰기. 
		
		int num = 10;
		
		// 짝수인지 확인
		if(num%2 == 0)
		{
			System.out.println("입력하신 숫자는 짝수입니다.");
		}
		
		if(num%2 != 0)
		{
			System.out.println("입력하신 숫자는 홀수입니다.");
		}
		
		System.out.println("프로그램 종료");
	}
	
	public void testIfElse()
	{
		// else : 조건식을 사용X. 
		// if의 조건식이 거짓이면 무조건 else의 {} 안의 코드가 실행된다.
		
		int num = 10;
		
		if(num%2 == 0)
		{
			System.out.println("짝수입니다.");
		}
		else
		{
			System.out.println("홀수입니다.");
		}
	}
	
	public void testIfElse2()
	{
		// 정수 하나 입력 받아 
		// 50 보다 큰 수 일 때 -> 짝수인지 홀수인지 출력 
		// 50 보다 작은 수라면 "작다" 라고 출력
		
		System.out.println("정수를 입력하세요.");
		int num = sc.nextInt();
		if(num>=50)
		{
			System.out.println("크다");
			if(num%2 == 0)
			{
				System.out.println("짝수");
			}
			else
			{
				System.out.println("홀수");
			}
		}
		else
		{
			System.out.println("작다");
		}
		
		// 위 if문을 삼항연산자로 작성해보자
		String str = (num>=50)?  (num%2 == 0)? "크다 짝수": "크다 홀수": "작다";
		System.out.println("str: " + str);
	}
	
	public void testIfElse3()
	{
		// 정수 하나를 입력 받아
		// 양수인지 음수인지 출력
		// 단, 0이면 "0입니다" 라고 출력
		// else문
		
		System.out.println("정수를 입력하세요.");
		int num = sc.nextInt();
		
		if(num>0)
		{
			System.out.println("양수입니다.");
		}
		else if(num<0)
		{
			System.out.println("음수입니다.");
		}
		else
		{
			System.out.println("0 입니다.");
		}
	}
	
	public void testIfElse4()
	{
		// 정수 두 개를 입력 받는다.
		// 입력 받은 두 숫자의 산술연산을 처리하여 출력한다. + - / * %
		// 단, 두 수 모두 반드시 1부터 100사이의 값이어야 한다.
		// 둘 중 하나라도 범위에 속하지 않은 수라면 
		// "값은 1부터 100사이어야 합니다" 
		// if else로 처리 (중첩X) 
		
		System.out.println("정수 A를 입력하세요.");
		int A = sc.nextInt();
		System.out.println("정수 B를 입력하세요.");
		int B = sc.nextInt();
		
		if( (A>=1 && A<=100) && (B>=1 && B<=100) )
		{
			System.out.println("A+B=" + (A+B));
			System.out.println("A-B=" + (A-B));
			System.out.println("A*B=" + (A*B));
			System.out.println("A/B=" + (A/B));
			System.out.println("A%B=" + (A%B));
		}
		else
		{
			System.out.println("1부터 100사이의 값을 입력해주세요.");
		}
		
	}
}
