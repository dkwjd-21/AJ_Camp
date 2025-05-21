package com.test02.controller;

import java.util.Scanner;

import com.test02.model.Person;

// model 패키지 		: 데이터와 관련된 작업
// view 패키지 		: 	 
// controler 패키지 	: 

public class PersonController {
	private Person[] p = new Person[3];
	Scanner sc = new Scanner(System.in);
	
	public void insertPerson() {
		// 회원 추가
		for(int i=0;i<3;i++) {
			System.out.println("== 회원 정보 입력 ==");
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("나이 : ");
			int age = sc.nextInt();
			System.out.print("재산 : ");
			int wealth = sc.nextInt();
			
			p[i] = new Person(name, age, wealth);
		}
	}
	
	public void printPerson() {
		// 회원 전체 조회
//		for(int i=0;i<3;i++) {
//			System.out.println(p[i].info());
//			System.out.println();
//		}
		
		// 향상된 for문 
		for(Person people : p) {
			System.out.println(people.info());
			System.out.println();
		}
	}
	
	public void avgWealth() {
		// 회원 평균재산
		int sum =0;
		for(Person people : p) {
			sum += people.getWealth();
		}
		System.out.println("평균 재산은 "+sum+"원 입니다.");
	}
	
	public void searchName() {
		System.out.println("=== 이름 검색 ===");
		System.out.print("검색어 : ");
		String search = sc.nextLine();
		for(Person people : p) {
			if(people.getName().equals(search)) {
				System.out.println(people.info());
			}
		}
	}
	
}
