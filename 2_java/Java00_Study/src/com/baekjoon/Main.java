package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*	규칙
		 * 첫줄의 정사각형의 개수는 2^n
		 * 첫줄의 점의 개수는 2^n+1
		 * 전체 점의 개수는 2^n+1의 제곱
		 * */
		
		// N이 주어진다
		int N = Integer.parseInt(br.readLine());
		System.out.println(countDot(N));
		
		br.close();
	}
	
	public static int countDot(int N) {
		double cnt = 0.0;
		
		cnt = Math.pow(Math.pow(2, N)+1, 2);
		
		return (int)cnt;
	}
}

