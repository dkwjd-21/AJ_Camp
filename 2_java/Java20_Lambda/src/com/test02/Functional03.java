package com.test02;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Functional03 {

	public static void main(String[] args) {
		func01();
		func02();
	}
	
	// Function<T, R> T : 매개변수, R : 반환값
	// apply() : 매개변수O, 반환값O 
	public static void func01() {
		Function<Integer, String> fn = n -> (n>=10)? ""+n:"0"+n;
		System.out.println(fn.apply(5));
		System.out.println(fn.apply(9));
		System.out.println(fn.apply(12));
	}
	
	public static void func02() {
		// 매개변수 2개 
		BiFunction<String, String, Integer> bFn = (i, j) 
				-> Integer.parseInt(i)+Integer.parseInt(j);
		System.out.println(bFn.apply("10", "20"));
	}
}
