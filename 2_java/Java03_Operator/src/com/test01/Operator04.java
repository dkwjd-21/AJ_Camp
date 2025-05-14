package com.test01;

import java.util.Scanner;

public class Operator04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operator04 op = new Operator04();
		op.test2();
	}
	
	public void test1()
	{
		// 복합대입연산자
		int num = 12, res;
		
		// num의 값을 3 증가시키고 싶다
		num += 3;
		System.out.println("[num+=3] " + num);
		num -= 5;
		System.out.println("[num-=5] " +num);
		num *= 4;
		System.out.println("[num*=4] " +num);
		num /= 2;
		System.out.println("[num/=2] " +num);
		num %= 3;
		System.out.println("[num%=3] " +num);
	}
	
	public void test2()
	{
		// 삼항 연산자
		// 항이 3개 : (조건식)? 참일때 : 거짓일때
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 하나 입력: ");
		int num = sc.nextInt();
		
		// 입력 받은 정수가 양수인지 양수가 아닌지 확인
		String res = (num>0)? "입력한 값은 양수임":"입력한 값은 양수가 아님" ;
		System.out.println(res);
		
		// 삼항연산자를 중첩해서 사용해보자 
		res = (num>0)? "입력한 값은 양수임":(num<0)? "입력한 값은 음수임":"입력한 값은 0임"  ;
		System.out.println(res);
	}
}
