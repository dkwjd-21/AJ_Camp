package com.test01;

import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째 줄에 정수 N과 M이 주어진다.
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		// N개의 요소를 가지는 int 배열
		int[] arr = new int[N];
		
		// M번 공을 넣음. = M번 int 배열에 요소를 저장함
		for(int i=0; i<M; i++) {
			// i번부터 j번까지 k를 넣음 
			String[] idx = br.readLine().split(" ");
			int idxI = Integer.parseInt(idx[0]);
			int idxJ = Integer.parseInt(idx[1]);
			int idxK = Integer.parseInt(idx[2]);
			
			// 배열의 인덱스는 i-1부터 j-1에 해당한다. 
			for(int j=idxI-1; j<idxJ; j++) {
				arr[j] = idxK;
			}
		}
		
		// 공의 번호를 공백으로 구분해 출력한다. 들어있지 않은 바구니는 0을 출력
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
