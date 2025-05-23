package com.test01;

import java.io.*;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException  
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수의 개수 N 
		int n = Integer.parseInt(br.readLine());
		// N개의 정수가 공백으로 구분되어 있다. 
		String[] arr = new String[n];
		arr = br.readLine().split(" ");
		// 찾으려고 하는 정수 v 
		int v = Integer.parseInt(br.readLine());
		
		// v의 개수
		int cnt = 0;		
		// N개의 정수 중에 v가 몇개인지 출력
		for(int i=0;i<arr.length;i++) {
			if(Integer.parseInt(arr[i]) == v) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
