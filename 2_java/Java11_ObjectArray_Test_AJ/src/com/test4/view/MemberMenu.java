package com.test4.view;

import java.util.*;

import com.test4.controller.MemberController;

public class MemberMenu {
	private MemberController mc = new MemberController();
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		// 반복문을 이용하여 메인 메뉴를 반복적으로 실행 
		while(true) {
			System.out.println("========== 회원 관리 메뉴 ==========");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 정보 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 삭제");
			System.out.println("5. 회원 정보 출력");
			System.out.println("6. 회원 정보 정렬");
			System.out.println("9. 프로그램 종료");
			System.out.println("메뉴 번호를 입력하세요 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				// 신규 회원 등록
				break;
			case 2:
				// 회원 정보 검색
				break;
			case 3:
				// 회원 정보 수정
				break;
			case 4:
				// 회원 정보 삭제
				break;
			case 5:
				// 회원 정보 출력
				break;
			case 6:
				// 회원 정보 정렬
				break;
			case 9:
				// 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			}			
		}
	}
	
	public void inserMember() {
		
	}
}
