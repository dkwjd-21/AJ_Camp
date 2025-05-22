package com.test.part02_OberridingTest.Book;

public class Run {

	public static void main(String[] args) {
		Book b1 = new Book("사랑은 하트 모양이 아니야", "김효인", 12000);
		Book b2 = new Book("밝은 밤", "최은영", 15000);
		
		System.out.println("b1 = "+b1);
		System.out.println("b2 = "+b2);
		
//		System.out.println("b1 = "+b1.toString());
//		System.out.println("b2 = "+b2.toString());
		
		System.out.println("b1과 b2가 같나? : "+b1.equals(b2));
		
		Book b3 = b1;
		System.out.println("b1과 b3가 같나? : "+b1.equals(b3));
		
		Book b4 = new Book("사랑은 하트 모양이 아니야", "김효인", 12000);
		System.out.println("b1과 b4가 같나? : "+b1.equals(b4));
		
		// 주소 값은 다르지만 값이 같은 객체 = 동등 개체라고 한다. 
		// 주소 값(hashCode)도 같을 경우 동일객체 라고 한다. 
		
		// eqauls() 값이 true 인데 hashCode()가 다르면 다른 객체로 취급될 수 있다
		// 그래서 hashCode()도 overridng 해줘야 한다. 
	}
	
}
