package com.chap03_myException;

public class MTest {
	public static void main(String[] args) {
		int no =5;
		
		try{
			checkNum(no);
		}catch(MyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static void checkNum(int num) throws MyException{
		if(num<10) {
			// 문제가 있음 -> 예외 발생 
//			MyException me = new MyException();
//			throw me;
			throw new MyException(num+"은 비정상적인 숫자(10미만)");
		}else {
			System.out.println(num+"은 정상적인 숫자(10이상)");
		}
		
	}
}
