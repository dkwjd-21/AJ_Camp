package com.test01;

public class ArrayTest02 {
	public static void main(String[] args)
	{
		// 1. a~z 배열에 저장하여 그 배열을 출력
		
		// 배열 생성 
		char[] ch = new char[26];
		
		char val = 'a';
		
		for(int i=0;i<ch.length;i++)
		{
			ch[i] = val;
			val++;
			System.out.print(ch[i] + " ");
		}		
		System.out.println();
		
		// 2. 1에서 만든 배열을 거꾸로 출력		
		reverse(ch);
		
		// 3. 1에서 만든 배열을 대문자로 바꿔 출력
		upper(ch);
		prn(ch);
	}
	
	public static void reverse(char[] ch)
	{
//		for(int i=ch.length; i>0; i--)
//		{
//			System.out.print(ch[i-1] + " ");					
//		}
		
		// 배열의 값을 역순으로 저장한 새로운 배열 생성
		char re[] = new char[26];
		int tmp = 0;
		
		for(int i=ch.length-1;i>=0;i--)
		{
			re[tmp] = ch[i];
			tmp++;
		}
		
		prn(re);
	}
	
	public static void upper(char[] ch)
	{
		for(int i=0; i<ch.length; i++)
		{
			ch[i] = Character.toUpperCase(ch[i]);
		}
	}
	
	public static void prn(char[] ch)
	{
		for(int i=0; i<ch.length; i++)
		{
			System.out.print(ch[i] + " ");
		}
		System.out.println();
	}
}
