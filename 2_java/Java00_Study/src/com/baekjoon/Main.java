package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 자연수 N이 주어진다.
		int N = Integer.parseInt(br.readLine());
		
		// f(A) : A의 모든 약수를 더한 값
		// g(N) : N보다 작거나 같은 모든 자연수의 y의 f(y)를 더한 값
		//		  => N보다 작거나 같은 모든 자연수의 약수의 합 
		int sumG = 0;
		for(int i=1; i<=N; i++) {
			sumG += sumMea(i);			
		}
		
		System.out.println(sumG);
		
		br.close();
	}
	
	// f(A) : A의 모든 약수를 더하는 함수
	public static int sumMea(int A) {
		int sum = 0;
		
		for(int i=1; i<=A; i++) {
			if(A%i == 0) {
				sum += i;				
			}
		}
		
		return sum;
	}
}


