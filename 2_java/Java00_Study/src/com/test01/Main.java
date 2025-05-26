package com.test01;

import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 30명의 번호 명단
		int[] list = new int[30];
		for(int i=0; i<list.length; i++) {
			list[i] = i+1;
		}
		
		// 28줄의 입력
		int[] input = new int[28];
		for(int i=0; i<input.length; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		// 30명의 번호 명단과 28줄의 입력 비교 
		int min = list[29];
		int max = list[0];
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<list.length; j++) {
				if(input[i] != list[j]) {
					if(input[i] > max) {
						max = input[i];
					}else if(input[i] < min) {
						min = input[i];
					}
				}
				else {
					break;
				}
			}
		}
		
		System.out.println(min);
		System.out.println(max);
	}
}
