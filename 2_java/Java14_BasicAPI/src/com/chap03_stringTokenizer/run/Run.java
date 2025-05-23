package com.chap03_stringTokenizer.run;

import java.util.StringTokenizer;

public class Run {
	// StringTokenizer
	// util 패키지 
	// split 차이점 : split()은 추출한 문자를 배열로 저장
	// StringTokenizer : 토큰으로 처리한다. 

	public static void main(String[] args) {
		String str = "송아정,24,경기 고양시,여";
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println(st.countTokens());
		
		while(st.hasMoreElements()) {
			// 다음 토큰으로 커서를 한칸 이동? 시킴 
			System.out.println(st.nextToken());
		}
		
		String arr[] = str.split(",");
		for(String s:arr) {
			System.out.println(s);
		}
	}

}
