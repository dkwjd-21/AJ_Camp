package com.test02;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Functional04 {
	public static void main(String[] args) {
		// Supplier : 매개변수X, 반환값O
		Supplier<Integer> ran = () -> (int)(Math.random()*50)+1;
		System.out.println(ran.get());
		
		// Consumer : 매개변수O, 반환값X
		Consumer<String> hello = (name) -> System.out.println("hi, "+name);
		hello.accept("Lambda");
		
		// BiConsumer : 매개변수O 2개, 반환값X 
		BiConsumer<String, Integer> cl = (sub, point) -> {
			System.out.println(sub+"정수: "+point);
		};
		cl.accept("Java", 99);
					
	}
	
}
