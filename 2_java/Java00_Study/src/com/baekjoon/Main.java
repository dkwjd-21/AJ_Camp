package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째줄에 X가 주어진다. 
		int X = Integer.parseInt(br.readLine());
		
		int min = 1, max = 1;
		int idx = 1;
		
		while(true) {
			if(X>=min && X<=max) {
				break;
			}else {
				min = max+1;
				idx++;
				max += idx;
			}
		}
		
		// X는 대각선에서 X-min+1 번째에 있음! 
		int offset = X-min+1;
		// 분자, 분모
		int numerator, denominator;
		
		if(idx%2 == 1) {
			// idx 홀수번이면 위로 올라감
			numerator = idx-offset+1;
			denominator = offset;
		}else {
			// 짝수번이면 아래로 내려감
			numerator = offset;
			denominator = idx-offset+1;
		}
		
		System.out.println(numerator+"/"+denominator);
		br.close();		
	}
}



