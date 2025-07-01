package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=2*N-1; i++) {
			if(i<=N) {
				for(int j=1; j<i; j++) {
					System.out.print(" ");
				}				
				for(int j=1; j<=2*(N-i)+1; j++) {
					System.out.print("*");
				}
			} else {
				for(int j=2*N-i-1; j>0; j--) {
					System.out.print(" ");
				}
				for(int j=0; j<2*(i-N)+1; j++) {
					System.out.print("*");
				}
			}			
			System.out.println();
		}
		
		br.close();
	}
}


