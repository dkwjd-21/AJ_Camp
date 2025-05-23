package com.chap01_runtimeExcpetion;

import java.io.EOFException;
import java.io.IOException;
import java.sql.Array;
import java.util.Scanner;

public class RunExcep {
	/*
	 * 예외(Exception) : 코드 수정으로 해결 가능한 에러 
	 * 		- 해당하는 상황이 발생되면 예외 발생, throw 명령어를 통해 예외 발생
	 * 
	 *  RuntimeException 
	 *  	- ArrayIndexOutOfBoundsException : 배열의 접근에 잘못된 인덱스 값을 사용하는 상황
	 *  	- ClassCastException : 잘못된 형변환을 진행하는 상황
	 *   	- NullpointerException : 참조변수가 null을 가진 상황에서 메소드 호출하는 상황
	 *   	- 
	 * */
	
	Scanner sc = new Scanner(System.in);
	
	public void arithEx() {
		// Exception in thread "main" ArithmeticException : / by zero
		// System.out.println(1/0);
		
		// if로 예외처리
//		System.out.println("정수 입력: ");
//		int no = sc.nextInt();		
//		if(no!=0) {
//			int ran = (int)(Math.random()*10)+1;
//		
//			int res = ran/no;
//			System.out.println(ran+"/"+no+"="+res);
//		} else {
//			System.out.println("0 입력. 잘못 입력하였습니다.");
//		}
		
		// try catch로 예외처리
		try {
			// 예외가 발생할 코드를 작성
			System.out.println("정수 입력: ");
			int no = sc.nextInt();	
			
			int ran = (int)(Math.random()*10)+1;
			
			int res = ran/no;
			System.out.println(ran+"/"+no+"="+res);
		} catch(ArithmeticException e) {
			// 예외 발생시 실행할 코드를 작성
			// e.printStackTrace();
			System.out.println("0을 입력하셨습니다. 잘못된 입력.");
			System.out.println(e.getMessage());
		}
		System.out.println("프로그램 종료");		
	}
	
	public void classCastNarrayIndexEx() {
		// ClassCastException
//		Object obj = 'a';
//		System.out.println(obj);
		
//		String str = (String)obj;	// ClassCastException 발생 
		
		// if문으로 예외 처리
//		if(obj instanceof String) {
//			String str = (String)obj;	
//			System.out.println(str);
//		}
//		else {
//			System.out.println("String이 아닙니다.");
//		}
		
		// try - catch로 예외 처리
		try {
//			Object obj = 'a';
//			String str = (String)obj;	
//			System.out.println(str);		
//			
//			// ArrayIndexOutOfBoundsException 
//			// 배열의 인덱스 값을 벗어나는 요소에 접근하려고 할 때
//			int[] arr = new int[2];
//			arr[0] = 1;
//			arr[3] = 2;
			
			// NullPointerException
			String str = test();
			int length = str.length();
								
		}/*catch(ClassCastException e) {
			System.out.println("클래스 예외 발생@@");
			System.out.println(e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 예외 발생!!");
			System.out.println(e.getMessage());			
		}catch(NullPointerException e) {
			System.out.println("Null 예외 발생!@!@");
			System.out.println(e.getMessage());
		}*/catch(Exception e){
			System.out.println("예외 발생!!@@!@!");
			System.out.println(e.getMessage());
		}
		finally {
			// 예외가 발생하건 발생하지 않건
			// 무조건 마지막에 실행
			System.out.println("프로그램 실행!!");			
		}
	}
	
	public String test() {
		try{
			System.out.println("dldldl");
		}catch(ClassCastException | ArrayIndexOutOfBoundsException |
				NullPointerException | NegativeArraySizeException e) {
			System.out.println("런타임 익셉션");			
		}
		return null;
	}
}
