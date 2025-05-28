package com.collection.part04_generics.controller;

public class Run {
	public static void main(String[] args) {
//		GenericsTest gt = new GenericsTest();
//		gt.test();
//		gt.test2();
//		gt.test3();
		
		String[] sarr = {"apple", "banana", "mango"};
		GenericTest2<String> my = new GenericTest2<String>(sarr);
		my.prn();
		
		System.out.println();
		
		Integer[] iarr = {1, 2, 3, 4};
		GenericTest2<Integer> my2 = new GenericTest2<Integer>(iarr);
		my2.prn();
	}
}
