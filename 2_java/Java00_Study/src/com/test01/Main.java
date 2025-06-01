package com.test01;

import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
    
    // 첫째 줄에 N이 주어진다
    int N = Integer.parseInt(br.readLine());
    
    // 윗부분 N번 반복
    for(int i=1; i<=N; i++) {
    		// 앞부분 공백
    		for(int k=0; k<N-i; k++) {
    			System.out.print(" ");
    		}
    		// 별 찍기 : i번째 홀수만큼
    		for(int k=0; k<2*i-1; k++) {
    			System.out.print("*");
    		}
    		// 뒷부분 공백
    		for(int k=0; k<N-i; k++) {
    			System.out.print(" ");
    		}
    	System.out.println();	// 줄바꿈
    }
    
    // 아랫부분 N-1번 반복
    for(int i=N-1; i>=1; i--) {
    		// 앞부분 공백
    		for(int k=0; k<N-i; k++) {
    			System.out.print(" ");
    		}
    		// 별 찍기 : i번째 홀수만큼
    		for(int k=0; k<2*i-1; k++) {
    			System.out.print("*");
    		}
    		// 뒷부분 공백
    		for(int k=0; k<N-i; k++) {
    			System.out.print(" ");
    		}
    	System.out.println();	// 줄바꿈
    }
  }
}
