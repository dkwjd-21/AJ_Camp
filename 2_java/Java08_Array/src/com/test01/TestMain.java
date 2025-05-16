package com.test01;

public class TestMain {

	public static void main(String[] args) {
		ArrayTest01 at01 = new ArrayTest01();
		ArrayTest03 at03 = new ArrayTest03();
		// at01.testArray3();
		// at03.shallowCopy();
		
		at03.deepCopy2();
		System.out.println("=============================");
		at03.deepCopy3();
	}

}
