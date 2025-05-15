package com.practice;

import java.util.Scanner;

public class Example {
	Scanner sc = new Scanner(System.in);
	
	public void sample1()
	{
		System.out.println("국어 점수를 입력하세요 : ");
		int kor = sc.nextInt();
		
		System.out.println("영어 점수를 입력하세요 : ");
		int eng = sc.nextInt();
		
		System.out.println("수학 점수를 입력하세요 : ");
		int math = sc.nextInt();
		
		int sum = kor+eng+math;
		double avg = sum / 3.0;
		
		if(kor>=40 && eng>=40 && math>=40 && avg>=60)
		{
			System.out.println("평균 : "+ avg + " [합격]");
		else
		{
			System.out.println("평균 : "+ avg + " [불합격]");
		}
	}
	
	public void sample2()
	{
		System.out.println("이름을 입력하세요(ex.송아정): ");
		String name = sc.nextLine();
		System.out.println("학년을 입력하세요(ex.4): ");
		int grade = sc.nextInt();
		System.out.println("반을 입력하세요(ex.3): ");
		int classNum = sc.nextInt();
		System.out.println("번호를 입력하세요(ex.21): ");
		int stuNum = sc.nextInt();
		System.out.println("성별을 입력하세요(ex.M 또는 F): ");
		char gen = sc.next().charAt(0);
		System.out.println("성적을 입력하세요(ex.95.21): ");
		double score = sc.nextDouble();
		
		if(gen == 'M')
		{
			// 남학생
			System.out.println(grade + "학년 " + classNum + "반 " 
								+ stuNum + "번 남학생 " + name + "은 성적이 " + score + "이다." );
		}
		else
		{
			// 여학생
			System.out.println(grade + "학년 " + classNum + "반 " 
								+ stuNum + "번 여학생 " + name + "은 성적이 " + score + "이다." );
		}
	}
	
	public void sample3()
	{
		System.out.println("정수를 입력하세요: ");
		int num = sc.nextInt();
		String res = (num>0)? "양수다." : "양수가 아니다.";
		System.out.println(res);
	}
	
	public void sample4()
	{
		int num;
		String str;
		
		System.out.println("정수를 입력하세요: ");
		num = sc.nextInt();
		
		str = (num%2 == 0)? "짝수다":"홀수다";
		
		System.out.println(str);
	}
}
