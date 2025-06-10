package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수 n 입력
		int n = Integer.parseInt(br.readLine());
		
		while(n>0) {
			int sub = 0;
			// for문을 돌며 1, 11, 111, 1111 ... 을 나눈 값이 0이면 다음 케이스 진행
			for(int i=0; i<=n; i++) {
				sub += (int)Math.pow(10, i);
				
				if(sub%n == 0) {
					System.out.println(i+1);
					break;
				}
			}
			
			n = Integer.parseInt(br.readLine());
		}
	}
}



