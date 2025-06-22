package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 세 막대의 길이 a, b, c가 주어진다.
		String input[] = br.readLine().split(" ");
		int sides[] = {Integer.parseInt(input[0]),
				       Integer.parseInt(input[1]),
				       Integer.parseInt(input[2])};
		Arrays.sort(sides);
		
		while(true) {
			if(sides[2] < sides[0]+sides[1]) {
				break;
			} else {
				sides[2]--;
			}			
		}		
		
		System.out.println(sides[0]+sides[1]+sides[2]);
		br.close();
	}
}



