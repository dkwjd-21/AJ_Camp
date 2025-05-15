package com.test01;

public class WhileTest03 {

	public static void main(String[] args) {
		// 1. 1~100 까지의 숫자를 출력. 단 역순으로
		prr01();
		System.out.println("-----------------------");
		// 2. 1~100 까지의 숫자 중, 2의 배수만 출력
		prr02();
		System.out.println("-----------------------");
		// 3. 1~100 까지의 숫자 중, 7의 배수의 갯수와 총 합을 출력
		prr03();
	}
	
	public static void prr01() {
		int i = 100;
		do {
			System.out.println(i);
			i--;			
		}while(i>=1);			
	}
	
	public static void prr02() {
		int i = 1;
		do {
			if(i%2 == 0)
			{
				System.out.println(i);
			}
			i++;
		}while(i<=100);
	}
	
	
	public static void prr03() {
		int cnt = 0;
		int sum = 0;
		int i = 1;
		
		do {
			if(i%7 == 0)
			{
				cnt++;
				sum += i;
			}
			i++;
		}while(i<=100);
		
		System.out.println("7의 배수는 " + cnt+"개");
		System.out.println("7의 배수의 합은 " + sum);
	}
}
