package com.poly.part00_test.test06;

import java.util.Scanner;

public class Triangle extends AreaImpl{

	@Override
	public void make() {
		// 밑변과 높이 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.println("밑변: ");
		int x = sc.nextInt();
		System.out.println("높이: ");
		int y = sc.nextInt();
		
		// 면적 
		double res = (double)x*y/2;
		super.setResult(res+"");		
		
	}

}
