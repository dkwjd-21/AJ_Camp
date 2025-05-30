package com.test03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Mtest {
	public static void main(String[] args) {
		MyClac sum = (a, b) -> a+b;
		MyClac sub = (a, b) -> a-b;
		MyClac mul = (a, b) -> a*b;
		
		System.out.println(sum.clac(10, 3));
		System.out.println(sub.clac(50, 26));
		System.out.println(mul.clac(5, 8));
		
		//
		List<String> list = new ArrayList<>();
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return 0;
			}
		});
		
		Comparator c = (s1, s2) -> 0;
		
		// 람다식으로 작성 
		Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
		
	}
}
