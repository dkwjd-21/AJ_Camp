package com.test01;

import java.util.Scanner;

public class IfTest02 {
	Scanner sc = new Scanner(System.in);
	
	public void testElseIf1()
	{
		int no = 10;
		
		// ----------------------------------------------
		if(no!=0)
		{
			// 0 아니면 양수 음수 출력
			if(no>0)
			{
				System.out.println("양수입니다.");
			}
			else
			{
				System.out.println("양수입니다.");
			}
		}
		// ----------------------------------------------
		
		int i=10, j=20;
		if(i>j)
		{
			System.out.println("i가 j보다 크다.");
		}
		else if (i==j)
		{
			System.out.println("i와 j는 같다.");
		}
		else
		{
			System.out.println("i가 j보다 작다.");
		}
			
	}
	
	public void testElseIf2()
	{
		// 정수 하나를 입력 받아서 등급을 나누어 점수와 등급을 출력
		// 90A 
		// 90미만 80이상 B
		// 80미만 70이상 C
		// 70미만 60이상 D
		// 60 미만 F
		
		System.out.println("점수: ");
		int score = sc.nextInt();
		char grade = ' ';
		
		if(score>=90)
		{
			grade = 'A';
		}
		else if(score>=80)
		{
			grade = 'B';
		}
		else if(score>=70)
		{
			grade = 'C';
		}
		else if(score>=60)
		{
			grade = 'D';
		}
		else
		{
			grade = 'F';
		}
			
		System.out.printf("당신의 점수는 %d, 등급은 %c입니다.", score, grade);		
	}
	
	public void testElseIf3()
	{
		// testElseIf2에서 
		// 각 등급별 중간 점수 이상의 경우에는 등급에 +라는 문자를 추가하여 출력
		System.out.println("점수: ");
		int score = sc.nextInt();
		String grade = " ";
		
		if(score>=90)
		{
			grade = "A";
			if(score>=95)
			{
				grade += "+";
			}			
		}
		else if(score>=80)
		{
			grade = "B";
			if(score>=85)
			{
				grade += "+";
			}	
		}
		else if(score>=70)
		{
			grade = "C";
			if(score>=75)
			{
				grade += "+";
			}	
		}
		else if(score>=60)
		{
			grade = "D";
			if(score>=65)
			{
				grade += "+";
			}	
		}
		else
		{
			grade = "F";
		}
		
		/*
		 * if(score%10>=5)
		 * {
		 * 		grade += "+";
		 * }
		 * */
			
		System.out.printf("당신의 점수는 %d, 등급은 %s입니다.", score, grade);	
	}
}
