package com.baekjoon;

import java.io.*;

public class p10988 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
		
		// 알파벳 소문자로만 이루어진 단어 입력
		String word = br.readLine();
		
		// 팰린드롬 : 앞으로 읽을때와 거꾸로 읽을때 똑같은 단어
		String reWord = new StringBuffer(word).reverse().toString();
		
		if(word.equals(reWord)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}	
}
