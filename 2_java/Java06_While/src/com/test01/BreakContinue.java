package com.test01;

public class BreakContinue {

	public static void main(String[] args) {
		testCon();
	}
	
	public static void testBreak()
	{
		int no = 10;
		int sum = 0;
		
		int i = 0;
		
		while(true)
		{
			sum += i;
			if(i==no)
			{
				break;
			}
			i++;
		}
		
		System.out.println("sum: "+ sum);
	}
	
	public static void testCon()
	{
		int i = 0;
		while(i<10)
		{
			i++;
			if(i%2 == 0)
			{
				// 짝수일 때 건너뛰고 다시 반복문 진행
				continue;
			}
			System.out.println(i);
		}
	}
}
