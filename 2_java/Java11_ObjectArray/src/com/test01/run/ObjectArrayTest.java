package com.test01.run;

import java.util.Scanner;

import com.test01.model.Book;

public class ObjectArrayTest {

	public static void main(String[] args) {
		int[] arr = new int[5];
		
		// 객체 배열
		Book[] b = new Book[5];
		b[0] = new Book("밝은 밤", "최은영", "문학동네", 15500);
		b[1] = new Book("내게 무해한 사람", "최은영", "문학동네", 11500);
		b[2] = new Book("사랑은 하트 모양이 아니야", "김효인", "안전가옥", 12000);
		b[3] = new Book("바깥은 여름", "김애란", "문학동네", 14500);
		b[4] = new Book("재와 물거품", "김창귤", "안전가옥", 13000);
		
		Book[] bk = {
				new Book("밝은 밤", "최은영", "문학동네", 15500),
				new Book("내게 무해한 사람", "최은영", "문학동네", 11500),
				new Book("사랑은 하트 모양이 아니야", "김효인", "안전가옥", 12000),
				new Book("바깥은 여름", "김애란", "문학동네", 14500),
				new Book("재와 물거품", "김창귤", "안전가옥", 13000)
				};
		
		System.out.println(bk);			// bk => 참조형, Book[]
		System.out.println(bk[1]);		// bk[idx] => 참조형, Book 객체 
		System.out.println(bk[1].getPrice());		// 정수(기본자료형), int
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 제목: ");
		String searchTitle = sc.nextLine();
		
		for(int i=0; i<bk.length;i++) {
			if(bk[i].getTitle().equals(searchTitle)) {
				System.out.println(bk[i].info());
			}
		}
	}

}
