package com.chap02_throw;

import java.io.IOException;

public class MTest {
	
	public static void main(String[] args) /*throws IOException*/{
		// throw
		// throws
		try {
			testA();
		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			System.out.println("우헿");
		}
		
	}
	
	public static void testA() throws IOException{
		testB();
	}
	
	public static void testB() throws IOException{
		testC();
	}
	
	public static void testC() throws IOException{
		System.out.println("Hi~");
		
		throw new IOException();		// 예외발생! 
		
		// 예외처리를 해야 한다
		// 1. try-catch : 예외가 발생하는 그 위치에서 예외를 처리하겠다
		// 2. throws : 예외 처리를 넘긴다. 자신을 호출한 곳으로.
	}
}
