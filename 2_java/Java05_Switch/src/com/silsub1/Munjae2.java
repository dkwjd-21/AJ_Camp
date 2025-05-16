package com.silsub1;

import java.util.Scanner;

public class Munjae2 {
	
	Scanner sc = new Scanner(System.in);
	
	// 키보드로 정수 3개를 입력 받아 가장 큰 수를 찾아 출력 
	public void maxOfNum()
	{
		int a, b, c;
		System.out.println("정수 a 입력: ");
		a = sc.nextInt();
		System.out.println("정수 b 입력: ");
		b = sc.nextInt();
		System.out.println("정수 c 입력: ");
		c = sc.nextInt();
		
		if(a>b && a>c)
		{
			System.out.println("가장 큰 수는 a : " + a);
		}
		else
		{
			if(b>c)
			{
				System.out.println("가장 큰 수는 b : " + b);
			}
			else
			{
				System.out.println("가장 큰 수는 c : " + c);
			}
		}
	}
	
	// 사용자의 id와 pw를 키보드로 입력 받아
	// 정해진 관리자 id, pw와 일치하는지 확인
	// 관리자(admin, 1234) 
	/*
	 * ID, PW 두 개 모두 일치하면 "로그인 성공"이라고 출력
	 * ID만 맞으면 "비밀번호가 틀렸습니다." 출력
	 * ID가 틀리면 "존재하지 않는 사용자입니다." 출력
	 * 
	 * */
	public void login()
	{
		String id;
		int pw;
		
		System.out.println("아이디를 입력하세요: ");
		id = sc.next();
		System.out.println("비밀번호를 입력하세요: ");
		pw = sc.nextInt();
		
		if(id.equals("admin"))
		{
			if(pw==1234)
			{
				System.out.println("로그인 성공");
			}
			else
			{
				System.out.println("비밀번호가 틀렸습니다.");
			}			
		}
		else
		{
			System.out.println("존재하지 않는 사용자입니다.");
		}
		
	}
	
	// 암호체크
	// 키보드로 3자리 정수를 입력 받아 각 자리 수를 분해한다.
	// 모두 홀수면 -> "code A" 출력
	// 모두 짝수면 -> "code B" 출력
	// 첫 번째 자리가 홀수, 나머지 짝수 -> "code C" 출력
	// 위 조건 모두 해당하지 않으면 - "nomal code" 출력
	public void codeCheck()
	{
		int num;
		
		System.out.println("세 자리 수 정수를 입력하세요: ");
		num = sc.nextInt();
		
		if(num>=100)
		{
			int n1, n2, n3;
			// 1번째 자리 수
			n1 = num%10;
			// 2번째 자리 수
			n2 = (num-n1)/10%10;
			// 3번째 자리 수
			n3 = num/100;
			
			if(n1%2==1 && n2%2==1 && n3%2==1)
			{
				// 모두 홀수 
				System.out.println("code A");
			}
			else if(n1%2==0 && n2%2==0 && n3%2==0)
			{
				// 모두 짝수
				System.out.println("code B");
			}
			else if(n1%2==1 && n2%2==0 && n3%2==0)
			{
				// 첫 번째 자리가 홀수, 나머지 짝수
				System.out.println("code C");
			}
			else
			{
				System.out.println("nomal code");
			}
		}
		else
		{
			System.out.println("반드시 세 자리 수 정수를 입력하세요");
		}
	}
}
