package com.test3.controller;

import java.util.Scanner;

import com.test3.model.vo.Product;

public class ProductController {
//	private Product[] pro = null;	// null로 할당하면 인덱스에 접근이 안됨 	
	private Product[] pro = new Product[100];	
	public static int count=0;		// 현재 추가된 객체 수
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		do {
			// 메뉴화면 출력. 
			// 각 버튼 선택 시 각각의 메소드 호출
			System.out.println("============ 제품 관리 메뉴 ============");
			System.out.println("1. 제품 정보 추가");
			System.out.println("2. 제품 전체 조회");
			System.out.println("9. 프로그램 종료");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				// 제품 정보 추가
				productInput();
				break;
			case 2:
				// 제품 전체 조회
				productPrint();
				break;
			case 9:
				// 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}while(true);
	}
	
	public void productInput() {
		// 키보드로 도서 정보를 입력 받아 객체 생성
		// -> Product 생성자 내부에서 ProductController의 count 클래스 변수 값이 1씩 증가
		// 현재 카운트 인덱스에 생성한 주소 저장
		int idx = count;
		System.out.println("제품 번호를 입력하세요(ex.1) : ");
		int pId = sc.nextInt();
		sc.nextLine();
		System.out.println("제품명을 입력하세요 : ");
		String pName = sc.nextLine();
		System.out.println("제품 가격을 입력하세요(ex.1000) : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.println("제품 세금을 입력하세요(ex.0.1) : ");
		double tax = sc.nextDouble();
		
		pro[idx] = new Product(pId, pName, price, tax);
		
	}
	
	public void productPrint() {
		// 현재까지 기록한 도서 정보 모두 출력
		for(int i=0; i<pro.length; i++) {
			if(pro[i] != null) {
				System.out.println(pro[i].information());
			}else {
				break;
			}			
		}
	}
	
	// 제품 삭제, 수정 검색 등 메소드 응용 
}
