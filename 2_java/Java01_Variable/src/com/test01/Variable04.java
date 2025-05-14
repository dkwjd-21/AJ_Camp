package com.test01;

public class Variable04 {

	public static void main(String[] args) {
		// 준비
		Variable04 test = new Variable04();
		
		// 실행
		test.test1();
		test.test2();
		test.test3();
	}

	
	// 자동 형변환, 강제 형변환
	
	/*컴퓨터의 데이터 처리 원칙
	 * 같은 자료형끼리 대입가능 / 같은 자료형끼리 연산가능
	 * 작은 자료형을 큰 자료형으로, 정수형을 실수형으로 자동형변환 가능
	 * */
	
	public void test1()
	{
		// 형변환의 예외 : boolean
		boolean flag = true;
		// flag = "true";
		
		int num = 'A';
		System.out.println("num: " + num);
		
		char ch = 97;
		System.out.println("ch: " + ch);
		
		// 음수를 저장한 변수를 char로 강제 형변환 하게 되면 문자로 인식할 수 없다.
		// 아스키코드는 음수를 지원하지 않기 때문.
		// num = -65;
		// Type misMatch
		char ch2 = (char)num;		
		System.out.println("ch2: " + ch2);
	}
	
	
	public void test2()
	{
		int inum = 10;
		long lnum = 100;
		
		// int + long => 결과 값은 long 타입.
		// type misMatch 다른 자료형끼리 연산 후에 결과로 큰 자료형의 데이터가 나온다. 
//		int isum = inum + lnum;		// cannot convert long to int 
		
		// 1. int로 강제 형변환 
		int isum = (int)(inum+lnum);
		// 2. 
		int isum2 = inum + (int)lnum;
		// 3. 
		long isum3 = inum + lnum;
		
		System.out.printf("isum:%d, isum2:%d, isum3:%d \n", isum, isum2, isum3);
		
		// byte와 short의 연산 결과는 무조건 int이다.
		byte bnum = 1;
		short snum = 2;
		
		// type misMatch : cannot convert int to short
//		short sum = bnum + snum;
		short sum = (short)(bnum + snum);
		System.out.println("sum:"+ sum);
	}
	
	public void test3()
	{
		long lnum = 100;
		
		// 정수는 실수로 자동 형변환 된다. 
		float fnum = lnum;
		
		System.out.println("fnum:" + fnum);
		
		
		// 반대인 경우
		double dnum = 1234.567;
		int inum = (int)dnum;
		// 강제 형변환 후 데이터 손실 발생 
		System.out.println("inum:" + inum);
		System.out.println("inum:" + (double)inum);
	}
}



