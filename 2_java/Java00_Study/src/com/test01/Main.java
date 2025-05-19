package com.test01;

import java.io.*;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException  
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();     // 숫자 입력 (예: 10)
		String str = sc.nextLine(); // 다음 줄 입력
		System.out.println("입력된 문자열: " + str);
	}
}