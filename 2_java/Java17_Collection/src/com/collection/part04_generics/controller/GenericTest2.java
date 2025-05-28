package com.collection.part04_generics.controller;

public class GenericTest2<T> {
	private T[] array;
	
	public GenericTest2(T[] array) {
		this.array = array;
	}
	public void prn() {
		for(T tmp:array) {
			System.out.print(tmp+" ");
		}
	}
}
