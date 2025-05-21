package com.test01.run;

import java.util.Scanner;
import com.test01.model.Book;

public class ObjectTest {

	public static void main(String[] args) {
		Book b1 = new Book("밝은 밤", "최은영", "문학동네", 15500);
		Book b2 = new Book("내게 무해한 사람", "최은영", "문학동네", 11500);
		Book b3 = new Book("사랑은 하트 모양이 아니야", "김효인", "안전가옥", 12000);
		Book b4 = new Book("바깥은 여름", "김애란", "문학동네", 14500);
		Book b5 = new Book("재와 물거품", "김창귤", "안전가옥", 13000);
		
//		System.out.println(b1.info()+"\n");
//		System.out.println(b2.info()+"\n");
//		System.out.println(b3.info()+"\n");
//		System.out.println(b4.info()+"\n");
//		System.out.println(b5.info()+"\n");
		
		// 도서 검색
		Scanner sc = new Scanner(System.in);
		System.out.println("제목을 입력해주세요: ");
		String searchTitle = sc.nextLine();
		
		if(b1.getTitle().equals(searchTitle)) {
			System.out.println(b1.info());
		}
		else if(b2.getTitle().equals(searchTitle)) {
			System.out.println(b2.info());
		}
		else if(b3.getTitle().equals(searchTitle)) {
			System.out.println(b3.info());
		}
		else if(b4.getTitle().equals(searchTitle)) {
			System.out.println(b4.info());
		}
		else if(b5.getTitle().equals(searchTitle)) {
			System.out.println(b5.info());
		}
		else {
			System.out.println("검색 결과가 없습니다.");
		}
			
		
		// 
	}

}
