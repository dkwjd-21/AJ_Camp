package com.part03_wrapperStream.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
//import java.util.Scanner;

public class TestStreamChange {
	public void input() {
		// InputStreamReader 클래스
		// byte 기반 / char 보조일 경우 많이 사용
		// 보조 : BufferredReader	: char 단위
		// 기반 : System.in		: 콘솔창, byte단위
		
		// new 보조스트림(new 보조스트림(다른스트림));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		new Scanner(System.in);
		try {
			System.out.println("문자열 입력: ");
			String val = br.readLine();
			System.out.println("val: "+val);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void output() {
		// OutputStreamWriter 클래스
		// 보조스트림 : BufferedWriter 
		// 기반스트림 : System.out 
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			bw.write("hello hi bye");
			bw.flush();
			
			int no = new Scanner(System.in).nextInt();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
