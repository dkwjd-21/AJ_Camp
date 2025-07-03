package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// a~f 
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		int d = Integer.parseInt(input[3]);
		int e = Integer.parseInt(input[4]);
		int f = Integer.parseInt(input[5]);
		
		// [방정식1] a*x + b*y = c
		// [방정식2] d*x + e*y = f
		
		int x=1000, y=1000;
		
		for(int i=-999; i<=999; i++) {
			if(a!=0) {
				// y == i
				
				// 방정식1
				if((c-b*i)%a == 0) {		// x가 정수일 때만 계산
					x = (c-b*i)/a;
				}
				
				// 방정식2
				if(x>=-999 && x<=999 && d*x+e*i==f) {
					y = i;
				}
			} else if(b!=0) {	// a==0, b!=0
				// x == i
				
				// 방정식1
				if(c%b ==0) {	// y가 정수일 때만 계산 
					y = c/b;
				}
				
				// 방정식2
				if(y>=-999 && y<=999 && (d*i+e*y)==f) {
					x = i;
				}
			}
			
			if(x>=-999 && x<=999 && y>=-999 && y<=999) {
				break;
			}
		}
		
		System.out.println(x + " " + y);
			
		br.close();
	}
}


