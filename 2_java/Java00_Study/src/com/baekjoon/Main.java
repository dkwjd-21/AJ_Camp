package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 수의 개수  N <= 1,000,000  
		int N = Integer.parseInt(br.readLine());
		int list[] = new int[N];
		
		// O(n)
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		// TimSort 방식. O(NlogN)
		Arrays.sort(list);
		
		// O(n) 
		for(int i : list) {
			bw.write(i+"\n");
		}
		
		bw.close();
		br.close();
	}
}


