package com.chap02_stringBuffer_stringBuilder.run;

public class Run {
	public static void main(String[] args) {
		// StringBuffer
		test3();
	}
	
	public static void test1() {
		StringBuilder sb = new StringBuilder("AB CDE");
		System.out.println(sb);
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		
		StringBuffer sf = new StringBuffer("FG HI");
		System.out.println(sf);
	}
	
	public static void test2() {
		String str = "Hello";
		StringBuffer sf = new StringBuffer("Hi!");
		StringBuilder sb = new StringBuilder("Bye");
		
		// String 클래스
		System.out.println("str: "+str+", 주소: "+System.identityHashCode(str));
		str += "I'm java!";
		System.out.println("str: "+str+", 주소: "+System.identityHashCode(str));
	
		// StringBuffer
		System.out.println("sf: "+sf+", 주소: "+System.identityHashCode(sf));
		sf.append("I'm java!");
		System.out.println("sf: "+sf+", 주소: "+System.identityHashCode(sf));
	
		// StringBuilder
		System.out.println("sb: "+sb+", 주소: "+System.identityHashCode(sb));
		sb.append("I'm java!");
		System.out.println("sb: "+sb+", 주소: "+System.identityHashCode(sb));
	}
	
	public static void test3() {
		StringBuilder sb = new StringBuilder();
//		StringBuffer sb = new StringBuffer();
		sb.append("오늘은 ");
		sb.append("금요일").append("입니다.");		
		System.out.println(sb);
		System.out.println(sb.length());
		sb.insert(0, "너무너무 신나는 ");
		System.out.println(sb);
	}
}
