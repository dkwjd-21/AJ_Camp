package com.test.part00_test.bbb;

import com.test.part00_test.aaa.AAA;

public class BBB extends AAA {
	private int b;
	
	public BBB() {
		System.out.println("BBB 생성()");
	}
	public BBB(int b) {
		System.out.println("BBB 생성(b)");
		this.b = b;
	}
	public BBB(int no, int b) {
		super(no);
		this.b = b;
		System.out.println("BBB 생성 (no, b)");
	}
	
	// getter & setter
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	public int getSum() {
		int sum = getB() + getNo();
		return sum;
	}
	
	@Override
	public void prn() {
		System.out.println("BBB의 prn()");
	}
}
