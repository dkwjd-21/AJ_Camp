package com.test.chap01_encapsulation;

public class Score {
	// 필드
	private String name = "송아정";
	private int kor = 90;
	private int eng = 84;
	private int math = 97;
	
	// 메소드
	
	// 생성자
	public Score() {}
	
	
	
	// 1. 점수의 총합을 구해 출력하는 메소드
	public void sumScore()
	{
		int sum = kor + eng + math;
		System.out.println("점수의 총합 : " + sum);
	}
	// 2. 점수의 평균을 구해 출력하는 메소드
	public void evgScore()
	{	
		int evg = (kor+eng+math)/3;
		System.out.println("평균 점수 : " + evg);
	}
	// 3. 평균을 확인하고 등급을 매기는 메소드 
	// (평균 점수가 90이상 A, 70이상 B, 나머지 C)
	public void grade()
	{
		int evg = (kor+eng+math)/3;
		if(evg>=90)
		{
			System.out.println("A");
		}
		else if(evg>=70)
		{
			System.out.println("B");
		}
		else
		{
			System.out.println("C");
		}
	}
	
	// 4. 필드값을 확인할 수 있게 출력해주는 메소드
	public void checkScore()
	{
		System.out.println("이름: "+name);
		System.out.println("국어 점수: "+kor);
		System.out.println("영어 점수: "+eng);
		System.out.println("수학 점수: "+math);
	}
}
