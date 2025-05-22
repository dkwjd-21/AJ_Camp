package com.poly.part00_test.test06;

import java.util.Scanner;

public class Square extends AreaImpl{

	@Override
	public void make() {
		// 가로 세로 입력을 받아 넓이 result 에 주기
		Scanner sc = new Scanner(System.in);
		System.out.println("가로: ");
		int x = sc.nextInt();
		System.out.println("세로: ");
		int y = sc.nextInt();
		
		// 면적
		int res = x*y;
		super.setResult(res+"");
	}

}
