package com.test.chap01_encapsulation;

public class Main {

	public static void main(String[] args) {
		Account a = new Account();
		
		a.prnBalance();
		
		a.in(100000000);
		a.prnBalance();
		
		a.in(100000000);
		a.prnBalance();
		
		// 출금
		a.out(50000);
		a.prnBalance();
		
		// private 필드의 변수에는 접근할 수 없다. 
		// a.balance -= 20000;
		
		// 출금
		a.out(50000);
		a.prnBalance();
		
		// 객체 추가
		Account b = new Account();
		
	}

}
