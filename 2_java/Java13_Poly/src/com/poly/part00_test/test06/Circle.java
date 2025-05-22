package com.poly.part00_test.test06;

import java.util.Scanner;

public class Circle extends AreaImpl{

	private int radius;
	
	@Override
	public void make() {
		// 면적을 구하기 위한 수치값 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("반지름 : ");
		int r = sc.nextInt();
		
		// 면적
		double res = Math.PI * r * r;
		super.setResult(res+"");
		// String.format() -> 포맷에 맞는 스트링 값으로 리턴 
//		super.setResult(String.format("%f", res));
	}

}
