package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수 N 
		int N = Integer.parseInt(br.readLine());
		
		// N을 소인수분해한 결과를 한줄에 하나씩 오름차순으로 출력 
		// N이 1인 경우 아무것도 출력하지 않음
		if(N != 1) {
			for(int i=2; i<=N; i++) {
				// i로 N을 계속 나눈다. 
				while(N%i == 0) {
					// i로 나눠떨어지면 i는 N의 약수이다. 
					System.out.println(i);
					// N의 값을 i로 나눈 몫으로 변경한다. 
					N = N/i;
				}
			}
		}		
		br.close();
	}
}



