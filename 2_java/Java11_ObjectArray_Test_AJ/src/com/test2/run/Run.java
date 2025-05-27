package com.test2.run;

import java.util.Scanner;

import com.test2.model.vo.Student;

public class Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Student[] s = new Student[10];
		
		int cnt = 0;
		
		while(true) {
			System.out.println("=== 메뉴 선택 ===");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 전체 학생 정보");
			System.out.println("9. 프로그램 종료");
			System.out.println("메뉴 선택 : ");
			
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1:
					System.out.println("=== 학생 정보 추가 ===");
					System.out.println("학년: ");
					int grade = sc.nextInt();
					System.out.println("반: ");
					int classroom = sc.nextInt();
					sc.nextLine();
					System.out.println("이름: ");
					String name = sc.nextLine();
					System.out.println("국어점수: ");
					int kor = sc.nextInt();
					System.out.println("영어점수: ");
					int eng = sc.nextInt();
					System.out.println("수학점수: ");
					int math = sc.nextInt();
					
					s[cnt] = new Student();
					s[cnt].setGrade(grade);
					s[cnt].setClassroom(classroom);
					s[cnt].setName(name);
					s[cnt].setKor(kor);
					s[cnt].setEng(eng);
					s[cnt].setMath(math);
					
					cnt++;
					break;
				case 2:
					System.out.println("=== 전체 학생 정보 ===");
					for(int i=0;i<cnt;i++) {
						int sum = s[i].getKor()+s[i].getEng()+s[i].getMath();
						System.out.println(s[i].information());
						System.out.println(s[i].getName()+" 학생의 평균 점수는 "+sum/3+"점");
					}
					break;
				case 9:
					System.out.println("프로그램을 종료합니다.");
					return;
				default: 
					System.out.println("다시 입력해주세요.");
			}
			
		}
		
	}
}
