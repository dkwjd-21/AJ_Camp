package com.silsub1;

import java.util.Scanner;

public class Munjae1 {
	
	Scanner sc = new Scanner(System.in);
	
	public void test1()
	{
		//국, 영, 수 세 과목(int)의 점수를 키보드로 입력받기
		System.out.println("국어 점수: ");
		int kor = sc.nextInt();
		System.out.println("영어 점수: ");
		int eng = sc.nextInt();
		System.out.println("수학 점수: ");
		int math = sc.nextInt();
		
		//합계와 평균을 계산하고,
		int sum = kor + eng + math;
		double evg = sum/3;
		
		//세 과목의 점수와 평균을 가지고 합격 여부 처리함
		//합격의 조건 : 세 과목의 점수가 각각 40점이상이고,
		//			평균이 60점 이상이면 합격, 
		//			아니면 불합격 처리함
		//합격인 경우에는 과목별 점수와 합계, 평균을 출력하고,
		//불합격인 경우는 "불합격" 출력함
		if(kor>=40 && eng>=40 && math>=40 && evg>=60)
		{
			System.out.printf("국어점수: %d / 영어점수: %d / 수학점수: %d \n", kor, eng, math);
			System.out.printf("합계: %d / 평균: %f \n", sum, evg);
			System.out.println("합격");			
		}
		else
		{
			System.out.println("불합격");
		}		
	}
	
	public void test2()
	{
		System.out.println("***초기 메뉴*** \n"
				+ "1. 입력 \n2. 수정 \n3. 입력 \n4. 삭제 \n7. 종료\n" );
		System.out.println("메뉴번호 입력: ");
		
		int num = sc.nextInt();
		
		switch(num)
		{
			case 1:
				System.out.println("입력메뉴가 선택되었습니다.");
				break;
			case 2:
				System.out.println("수정메뉴가 선택되었습니다.");
				break;
			case 3:
				System.out.println("입력메뉴가 선택되었습니다.");
				break;
			case 4:
				System.out.println("삭제메뉴가 선택되었습니다.");
				break;
			case 7:
				System.out.println("프로그램이 종료됩니다.");
				break;
			default:
				System.out.println("번호가 잘못 입력되었습니다.");
				System.out.println("다시 입력하십시오.");
		}
	}

	public void test3()
	{
		System.out.println("정수를 입력하세요: ");
		int num = sc.nextInt();
		
		if(num>0)
		{
			System.out.println("양수다.");
		}
		else
		{
			System.out.println("양수가 아니다.");
		}
		
	}

	public void test4()
	{
		int num;
		String str;
		
		System.out.println("양의 정수를 입력하세요: ");
		num = sc.nextInt();
		if(num>0)
		{
			if(num%2 == 0)
			{
				System.out.println("짝수다.");
			}
			else
			{
				System.out.println("홀수다.");
			}
		}
		else
		{
			System.out.println("양의 정수를 입력하세요.");
		}
	}

	public void inputTest()
	{
		String name;
		int age;
		double height;
		
		System.out.println("이름을 입력하세요: ");
		name = sc.next();
		System.out.println("나이를 입력하세요: ");
		age = sc.nextInt();
		System.out.println("키를 입력하세요: ");
		height = sc.nextDouble();
		
		
		if(name!=null && name.length()>0)
		{
			if(age>0 && height>0)
			{
				System.out.println("이름: " + name);
				System.out.println("나이: " + age);
				System.out.println("키: " + height);
				System.out.printf("%s의 나이는 %d세이고, 키는 %f cm 이다.", name, age, height);
			}
			else
			{
				System.out.println("나이와 신장을 정확히 입력해주세요.");
			}
		}
		else
		{
			System.out.println("이름을 정확히 입력해주세요.");
		}
	}

	public void test6()
	{
		int a, b;
		System.out.println("첫 번째 정수 입력: ");
		a = sc.nextInt();
		System.out.println("두 번째 정수 입력: ");
		b = sc.nextInt();
		
		if(a>0 && b>0)
		{
			System.out.print("첫번째 정수: "+a);
			System.out.print("두번째 정수: "+b);
			System.out.print(a + "+" + b + "=" + a+b);
			System.out.print(a + "-" + b + "=" + (a-b));
			System.out.print(a + "*" + b + "=" + a*b);
			System.out.print(a + "/" + b + "=" + a/b);
			System.out.print(a + "%" + b + "=" + a%b);
		}
	}
}
