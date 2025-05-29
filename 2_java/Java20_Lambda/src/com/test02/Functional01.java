package com.test02;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Functional01 {

	public static void main(String[] args) {
		unaryTest();
		binaryTest();
	}
	public static void unaryTest() {
		// UnaryOperator라는 함수형 인터페이스 
		UnaryOperator<String> hello = name -> "hello, "+name;
		
		System.out.println(hello.apply("Lambda"));
	}
	public static void binaryTest() {
		// BinaryOperator라는 함수형 인터페이스
		BinaryOperator<Integer> sum = (i, j) -> i+j;
		System.out.println(sum.apply(10, 3));
	}
}
